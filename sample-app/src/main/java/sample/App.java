package sample;

import com.assemblyai.api.AssemblyAI;
import com.assemblyai.api.RealtimeTranscriber;
import com.assemblyai.api.core.Environment;
import com.assemblyai.api.core.UserAgent;
import com.assemblyai.api.core.UserAgentItem;
import com.assemblyai.api.resources.files.types.UploadedFile;
import com.assemblyai.api.resources.lemur.requests.LemurTaskParams;
import com.assemblyai.api.resources.lemur.types.LemurTaskResponse;
import com.assemblyai.api.resources.realtime.requests.CreateRealtimeTemporaryTokenParams;
import com.assemblyai.api.resources.realtime.types.AudioEncoding;
import com.assemblyai.api.resources.realtime.types.RealtimeTemporaryTokenResponse;
import com.assemblyai.api.resources.realtime.types.SessionInformation;
import com.assemblyai.api.resources.transcripts.requests.*;
import com.assemblyai.api.resources.transcripts.types.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class App {

    public static void main(String... args) throws IOException, InterruptedException, ExecutionException {
        AssemblyAI client = AssemblyAI.builder()
                .apiKey(System.getenv("ASSEMBLYAI_API_KEY"))
                .build();

        Transcript transcript = client.transcripts().transcribe(
                "https://storage.googleapis.com/aai-docs-samples/nbc.mp3",
                TranscriptOptionalParams.builder()
                        .sentimentAnalysis(true)
                        .build()
        );

        if(transcript.getStatus() == TranscriptStatus.ERROR)
        {
            System.out.println("Transcript error: " + transcript.getError().get());
            System.exit(1);
            return;
        }

        for(SentimentAnalysisResult result: transcript.getSentimentAnalysisResults().get())
        {
            System.out.println("Text: " + result.getText());
            System.out.println("Sentiment: " + result.getSentiment());
            System.out.println("Confidence: " + result.getConfidence());
            System.out.printf("Timestamp: %s - %s", result.getStart(), result.getEnd());
        }

        SentencesResponse sentences = client.transcripts().getSentences(transcript.getId());
        System.out.println("Get transcript sentences. " + sentences);

        ParagraphsResponse paragraphs = client.transcripts().getParagraphs(transcript.getId());
        System.out.println("Get transcript paragraphs. " + paragraphs);

        String srt = client.transcripts().getSubtitles(transcript.getId(), SubtitleFormat.SRT);
        System.out.println("Get transcript srt. " + srt);

        String vtt = client.transcripts().getSubtitles(transcript.getId(), SubtitleFormat.VTT);
        System.out.println("Get transcript vtt. " + vtt);

        WordSearchResponse search = client.transcripts().wordSearch(transcript.getId(), List.of("NBC", "President"));
        System.out.println("Search transcript. " + search);

        LemurTaskResponse response = client.lemur().task(LemurTaskParams.builder()
                .prompt("Summarize this transcript.")
                .transcriptIds(List.of(transcript.getId()))
                .build());

        System.out.println("Summary: " + response.getResponse());

        transcript = client.transcripts().delete(transcript.getId());
        System.out.println("Delete transcript. " + transcript);

        File file = new File("sample-app/src/main/resources/nZP7pb_t4oA.mp3");
        UploadedFile uploadedFile = client.files().upload(Files.readAllBytes(file.toPath()));
        System.out.println("Uploaded file" + uploadedFile);

        transcript = client.transcripts().submit(TranscriptParams.builder()
                .audioUrl("https://storage.googleapis.com/client-docs-samples/nbc.mp3")
                .build());
        System.out.println("Created transcript " + transcript);

        transcript = client.transcripts().get(transcript.getId());
        System.out.println("Got transcript. " + transcript);

        TranscriptList transcripts = client.transcripts().list();
        System.out.println("List transcript. " + transcripts);

        RealtimeTemporaryTokenResponse tokenResponse = client.realtime().createTemporaryToken(CreateRealtimeTemporaryTokenParams.builder()
                .expiresIn(60)
                .build()
        );

        try (RealtimeTranscriber realtimeTranscriber = RealtimeTranscriber.builder()
                .apiKey(System.getenv("ASSEMBLYAI_API_KEY"))
                // alternatively, use token
                // .token(tokenResponse.getToken())
                .encoding(AudioEncoding.PCM_S16LE)
                .onSessionBegins(System.out::println)
                .onPartialTranscript(System.out::println)
                .onFinalTranscript(System.out::println)
                .onError((err) -> System.out.println(err.getMessage()))
                .onSessionInformation((info) -> System.out.println(info.getAudioDurationSeconds()))
                .onClose((code, reason) -> System.out.printf("%s: %s", code, reason))
                .build()) {
            realtimeTranscriber.connect();
            streamFile("sample-app/src/main/resources/gore-short.wav", realtimeTranscriber);
            Future<SessionInformation> closeFuture = realtimeTranscriber.closeWithSessionTermination();
            SessionInformation info = closeFuture.get();
            // Force exit is necessary for some reason.
            // The program will end after a while, but not immediately as it should.
            System.exit(0);
        }
    }

    public static void streamFile(String filePath, RealtimeTranscriber realtimeTranscriber) {
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            byte[] buffer = new byte[8192];

            while (fileInputStream.read(buffer) != -1) {
                realtimeTranscriber.sendAudio(buffer);
                Thread.sleep(300);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}