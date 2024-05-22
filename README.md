# AssemblyAI Java Library

[![Maven Central](https://img.shields.io/maven-central/v/com.assemblyai/assemblyai-java)](https://central.sonatype.com/artifact/com.assemblyai/assemblyai-java)
[![fern shield](https://img.shields.io/badge/%F0%9F%8C%BF-SDK%20generated%20by%20Fern-brightgreen)](https://buildwithfern.com/?utm_source=assemblyai/assemblyai-java-sdk/readme)
[![GitHub License](https://img.shields.io/github/license/AssemblyAI/assemblyai-java-sdk)](https://github.com/AssemblyAI/assemblyai-java-sdk/blob/main/LICENSE)
[![AssemblyAI Twitter](https://img.shields.io/twitter/follow/AssemblyAI?label=%40AssemblyAI&style=social)](https://twitter.com/AssemblyAI)
[![AssemblyAI YouTube](https://img.shields.io/youtube/channel/subscribers/UCtatfZMf-8EkIwASXM4ts0A)](https://www.youtube.com/@AssemblyAI)
[![Discord](https://img.shields.io/discord/875120158014853141?logo=discord&label=Discord&link=https%3A%2F%2Fdiscord.com%2Fchannels%2F875120158014853141&style=social)
](https://assemblyai.com/discord)

## Documentation

API reference documentation is available [here](https://www.assemblyai.com/docs/).

## Requirements

Java 8+

## Installation

### Gradle

Add the dependency in your `build.gradle`:

```groovy
dependencies {
    implementation 'com.assemblyai:assemblyai-java:1.x.x'
}
```

### Maven

Add the dependency in your `pom.xml`:

```xml
<dependency>
    <groupId>com.assemblyai</groupId>
    <artifactId>assemblyai-java</artifactId>
    <version>1.x.x</version>
</dependency>
```

## HTTP Client Usage

The SDK exports a vanilla HTTP client, `AssemblyAI`. You can
use this to call into each of our API endpoints and get typed
responses back.

```java
import com.assemblyai.api.AssemblyAI;

AssemblyAI aai = AssemblyAI.builder()
  .apiKey("YOUR_API_KEY")
  .build();

TranscriptResponse transcriptResponse =
    aai.transcript().get("transcript-id");

System.out.printlin("Received response!" + transcriptResponse);
```

### Handling Errors
When the API returns a non-success status code (4xx or 5xx response),
a subclass of [ApiError](src/main/java/com/assemblyai/api/core/ApiError.java)
will be thrown:

```java
import com.assemblyai.api.core.ApiError;

try {
  aai.transcript().get("transcript-id");
} catch (ApiError error) {
  System.out.println(error.getBody());
  System.out.println(error.getStatusCode());
}
```

## Creating a transcript
When you create a transcript, you can either pass in a URL to an audio file 
or upload a file directly.

```java
import com.assemblyai.api.types.Transcript;

// Transcribe file at remote URL
Transcript transcript = aai.transcripts().transcribe(
        "https://storage.googleapis.com/aai-web-samples/espn-bears.m4a");

// Upload a file via local path and transcribe
transcript = aai.transcripts().transcribe(
        new File("./news.mp4"));
```

`transcribe` queues a transcription job and polls it until the status is completed or error.
If you don't want to wait until the transcript is ready, you can use submit:

```java
import com.assemblyai.api.types.Transcript;

// Transcribe file at remote URL
Transcript transcript = aai.transcripts().submit(
        "https://storage.googleapis.com/aai-web-samples/espn-bears.m4a");

// Upload a file via local path and transcribe
transcript = aai.transcripts().submit(
        new File("./news.mp4"));
```

## Using the Realtime Transcriber
The Realtime Transcriber can be used to process any live
audio streams and sends data over websockets. The Realtime Transcriber
will take event handlers

```java
import com.assemblyai.api.Transcriber;

RealtimeTranscriber realtime = RealtimeTranscriber.builder()
  .apiKey("YOUR_API_KEY")
  .onPartialTranscript(partial -> System.out.println(partial))
  .onFinalTranscript(finalTranscript -> System.out.println(finalTranscript))
  .build();

realtime.sendAudio(new byte[]{...});

realtime.close();
```

## Staged Builders
The generated builders all follow the staged builder pattern.
Read more [here](https://immutables.github.io/immutable.html#staged-builder).
Staged builders only allow you to construct the object once all required
properties have been specified.

For example, in the snippet below, you will not be able to access the build
method on `CreateTranscriptParameters` until you have specified the mandatory
audioUrl variable.

```java
import com.assemblyai.api.TranscriptParams;

TranscriptParams params = TranscriptParams.builder()
  .audioUrl("https://...")
  .build();
```

## Contributing
While we value open-source contributions to this SDK, this library
is generated programmatically. Additions made directly to this library
would have to be moved over to our generation code, otherwise they would
be overwritten upon the next generated release. Feel free to open a PR as a
proof of concept, but know that we will not be able to merge it as-is.
We suggest opening an issue first to discuss with us!

On the other hand, contributions to the README are always very welcome!
