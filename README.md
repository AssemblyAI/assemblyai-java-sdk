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

## Installation

### Gradle

Add the dependency in your `build.gradle`:

```groovy
dependencies {
    implementation 'com.assemblyai:assemblyai-java:0.x.x'
}
```

### Maven

Add the dependency in your `pom.xml`:

```xml
<dependency>
    <groupId>com.assemblyai</groupId>
    <artifactId>assemblyai-java</artifactId>
    <version>0.x.x</version>
</dependency>
```

## HTTP Client Usage

The SDK exports a vanilla HTTP client, `AssemblyAI`. You can
use this to call into each of our API endpoints and get typed
responses back.

```typescript
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

```ts
import com.assemblyai.api.core.ApiError;

try {
  aai.transcript().get("transcript-id");
} catch (ApiError error) {
  System.out.println(error.getBody());
  System.out.println(error.getStatusCode());
}
```

## Using the Transcriber
Additionally, the SDK also exports a Transcriber class that has
utilities on top of the HTTP client, such as automatic polling.

```java
import com.assemblyai.api.Transcriber;

Transcriber transcriber = Transcriber.builder()
  .apiKey("YOUR_API_KEY")
  .build();

TranscriptResponse transcript =
        transcriber.transcribe("https://example.org/audio.mp3");
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
import com.assemblyai.api.CreateTranscriptParams;

CreateTranscriptParameters params = CreateTranscriptParameters.builder()
  .audioUrl("https://...")
  .build();
```

## Beta status
This SDK is in beta, and there may be breaking changes between versions
without a major version update. Therefore, we recommend pinning the package
version to a specific version in your build.gradle file. This way, you can
install the same version each time without breaking changes unless you are
intentionally looking for the latest version.

## Contributing
While we value open-source contributions to this SDK, this library
is generated programmatically. Additions made directly to this library
would have to be moved over to our generation code, otherwise they would
be overwritten upon the next generated release. Feel free to open a PR as a
proof of concept, but know that we will not be able to merge it as-is.
We suggest opening an issue first to discuss with us!

On the other hand, contributions to the README are always very welcome!
