package sample;

import com.assemblyai.api.Transcriber;
import com.assemblyai.api.resources.transcript.requests.TranscriptRequest;
import com.assemblyai.api.resources.transcript.requests.TranscriptSearchRequest;
import com.assemblyai.api.types.TranscriptResponse;
import com.assemblyai.api.types.UploadResponse;
import java.io.File;
import java.lang.String;
import com.assemblyai.api.AssemblyAIClient;

public final class App {

    public static void main(String[] args) {
        AssemblyAIClient aai = AssemblyAIClient.builder()
                .apiKey("API_KEY")
                .build();

        Transcriber transcriber = Transcriber.builder()
                .apiKey("API_KEY")
                .build();

        TranscriptResponse transcriptResponse =
                transcriber.transcribe("https://storage.googleapis.com/aai-docs-samples/nbc.mp3", true);
        System.out.println(transcriptResponse);

        var sentences = aai.transcript().exportSentences(transcriptResponse.getId());
        System.out.println("Get transcript sentences. " + sentences);

        var paragraphs = aai.transcript().exportParagraphs(transcriptResponse.getId());
        System.out.println("Get transcript paragraphs. " + paragraphs);

        var srt = aai.transcript().exportAsSrt(transcriptResponse.getId());
        System.out.println("Get transcript srt. " + srt);

        var vtt = aai.transcript().exportAsVtt(transcriptResponse.getId());
        System.out.println("Get transcript vtt. " + vtt);

        var search = aai.transcript().search(transcriptResponse.getId(), TranscriptSearchRequest.builder()
                .words("NBC")
                .build());
        System.out.println("Search transcript. " + search);

        var transcript = aai.transcript().delete(transcriptResponse.getId());
        System.out.println("Delete transcript. " + transcript);

        File file = new File("sample-app/src/main/resources/nZP7pb_t4oA.mp3");
        UploadResponse uploadResponse = aai.files().upload(file);
        System.out.println("Uploaded file" + uploadResponse);

        transcript = aai.transcript().create(TranscriptRequest.builder()
                .audioUrl("https://storage.googleapis.com/aai-docs-samples/nbc.mp3")
                .build());
        System.out.println("Created transcript " + transcript);

        transcript = aai.transcript().get(transcript.getId());
        System.out.println("Got transcript. " + transcript);

        var transcripts = aai.transcript().list();
        System.out.println("List transcript. " + transcripts);
    }
}
