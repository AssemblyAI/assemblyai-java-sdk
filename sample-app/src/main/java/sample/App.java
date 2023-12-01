package sample;

import com.assemblyai.api.AssemblyAI;
import com.assemblyai.api.RealtimeTranscriber;
import com.assemblyai.api.Transcriber;
import com.assemblyai.api.resources.transcript.requests.CreateTranscriptParameters;
import com.assemblyai.api.resources.transcript.requests.TranscriptWordSearchRequest;
import com.assemblyai.api.types.ParagraphsResponse;
import com.assemblyai.api.types.SentencesResponse;
import com.assemblyai.api.types.SubtitleFormat;
import com.assemblyai.api.types.Transcript;
import com.assemblyai.api.types.TranscriptList;
import com.assemblyai.api.types.UploadedFile;
import com.assemblyai.api.types.WordSearchResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;

public final class App {

    public static void main(String... args) throws IOException {
        RealtimeTranscriber realtimeTranscriber = RealtimeTranscriber.builder()
                .apiKey("cf33ed71255b4cfdb7dfd98ef5b5dd41")
                .onSessionStart(System.out::println)
                .onPartialTranscript(System.out::println)
                .onFinalTranscript(System.out::println)
                .onError((err) -> {
                    System.out.println(err.getMessage());
                })
                .build();
        realtimeTranscriber.connect();
        streamFile("sample-app/src/main/resources/gore-short.wav", realtimeTranscriber);
        realtimeTranscriber.close();
    }

    public static void streamFile(String filePath, RealtimeTranscriber realtimeTranscriber) {
        try (FileInputStream fileInputStream =
                new FileInputStream(filePath)) {
            byte[] buffer = new byte[8192];
            int bytesRead;

            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                realtimeTranscriber.sendAudio(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}