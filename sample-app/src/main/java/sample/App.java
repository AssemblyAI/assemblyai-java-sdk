package sample;

import com.assemblyai.api.AssemblyAI;
import com.assemblyai.api.RealtimeTranscriber;
import com.assemblyai.api.resources.transcripts.requests.TranscriptParams;
import com.assemblyai.api.resources.transcripts.requests.WordSearchParams;
import com.assemblyai.api.resources.transcripts.types.ParagraphsResponse;
import com.assemblyai.api.resources.transcripts.types.SentencesResponse;
import com.assemblyai.api.resources.transcripts.types.SubtitleFormat;
import com.assemblyai.api.resources.transcripts.types.Transcript;
import com.assemblyai.api.resources.transcripts.types.TranscriptList;
import com.assemblyai.api.resources.files.types.UploadedFile;
import com.assemblyai.api.resources.transcripts.types.WordSearchResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;

public final class App {

    public static void main(String... args) throws IOException {
        AssemblyAI aai = AssemblyAI.builder()
                .apiKey(System.getenv("ASSEMBLY_AI_API_KEY"))
                .build();

        Transcript transcript =
                aai.transcript().transcribe("https://storage.googleapis.com/aai-docs-samples/nbc.mp3");
        System.out.println(transcript);

        SentencesResponse sentences = aai.transcript().getSentences(transcript.getId());
        System.out.println("Get transcript sentences. " + sentences);

        ParagraphsResponse paragraphs = aai.transcript().getParagraphs(transcript.getId());
        System.out.println("Get transcript paragraphs. " + paragraphs);

        String srt = aai.transcript().getSubtitles(transcript.getId(), SubtitleFormat.SRT);
        System.out.println("Get transcript srt. " + srt);

        String vtt = aai.transcript().getSubtitles(transcript.getId(), SubtitleFormat.VTT);
        System.out.println("Get transcript vtt. " + vtt);

        WordSearchResponse search = aai.transcript().wordSearch(transcript.getId(), WordSearchParams.builder()
                .words("NBC")
                .build());
        System.out.println("Search transcript. " + search);

        transcript = aai.transcript().delete(transcript.getId());
        System.out.println("Delete transcript. " + transcript);

        File file = new File("sample-app/src/main/resources/nZP7pb_t4oA.mp3");
        UploadedFile uploadedFile = aai.files().upload(Files.readAllBytes(file.toPath()));
        System.out.println("Uploaded file" + uploadedFile);

        transcript = aai.transcript().submit(TranscriptParams.builder()
                .audioUrl("https://storage.googleapis.com/aai-docs-samples/nbc.mp3")
                .build());
        System.out.println("Created transcript " + transcript);

        transcript = aai.transcript().get(transcript.getId());
        System.out.println("Got transcript. " + transcript);

        TranscriptList transcripts = aai.transcript().list();
        System.out.println("List transcript. " + transcripts);

        RealtimeTranscriber realtimeTranscriber = RealtimeTranscriber.builder()
                .apiKey(System.getenv("ASSEMBLY_AI_API_KEY"))
                .onPartialTranscript(System.out::println)
                .onFinalTranscript(System.out::println)
                .onError((err) -> System.out.println(err.getMessage()))
                .build();
        realtimeTranscriber.connect();
        streamFile("sample-app/src/main/resources/gore-short.wav", realtimeTranscriber);
        realtimeTranscriber.close();
    }

    public static void streamFile(String filePath, RealtimeTranscriber realtimeTranscriber) {
        try (FileInputStream fileInputStream =
                new FileInputStream(filePath)) {
            byte[] buffer = new byte[8192];

            while (fileInputStream.read(buffer) != -1) {
                realtimeTranscriber.sendAudio(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}