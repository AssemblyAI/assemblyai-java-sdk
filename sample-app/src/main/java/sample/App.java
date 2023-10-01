package sample;

import com.assemblyai.api.AssemblyAI;
import com.assemblyai.api.Transcriber;
import com.assemblyai.api.resources.transcript.requests.CreateTranscriptParameters;
import com.assemblyai.api.resources.transcript.requests.TranscriptWordSearchRequest;
import com.assemblyai.api.types.Transcript;
import com.assemblyai.api.types.UploadedFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public final class App {

    public static void main(String... args)  throws IOException {
        AssemblyAI aai = AssemblyAI.builder()
                .apiKey("YOUR_API_KEY")
                .build();

        Transcriber transcriber = Transcriber.builder()
                .apiKey("YOUR_API_KEY")
                .build();

        Transcript transcript =
                transcriber.transcribe("https://storage.googleapis.com/aai-docs-samples/nbc.mp3", true);
        System.out.println(transcript);

        var sentences = aai.transcript().getSentences(transcript.getId());
        System.out.println("Get transcript sentences. " + sentences);

        var paragraphs = aai.transcript().getParagraphs(transcript.getId());
        System.out.println("Get transcript paragraphs. " + paragraphs);

        var srt = aai.transcript().exportAsSrt(transcript.getId());
        System.out.println("Get transcript srt. " + srt);

        var vtt = aai.transcript().exportAsVtt(transcript.getId());
        System.out.println("Get transcript vtt. " + vtt);

        var search = aai.transcript().wordSearch(transcript.getId(), TranscriptWordSearchRequest.builder()
                .words("NBC")
                .build());
        System.out.println("Search transcript. " + search);

        transcript = aai.transcript().delete(transcript.getId());
        System.out.println("Delete transcript. " + transcript);

        File file = new File("sample-app/src/main/resources/nZP7pb_t4oA.mp3");
        UploadedFile uploadedFile = aai.files().upload(Files.readAllBytes(file.toPath()));
        System.out.println("Uploaded file" + uploadedFile);

        transcript = aai.transcript().create(CreateTranscriptParameters.builder()
                .audioUrl("https://storage.googleapis.com/aai-docs-samples/nbc.mp3")
                .build());
        System.out.println("Created transcript " + transcript);

        transcript = aai.transcript().get(transcript.getId());
        System.out.println("Got transcript. " + transcript);

        var transcripts = aai.transcript().list();
        System.out.println("List transcript. " + transcripts);
    }
}
