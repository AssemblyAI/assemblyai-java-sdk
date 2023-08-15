# AssemblyAI Java Library

[![Maven Central](https://img.shields.io/maven-central/v/io.github.fern-api/assemblyai)](https://central.sonatype.com/artifact/io.github.fern-api/assemblyai)
[![fern shield](https://img.shields.io/badge/%F0%9F%8C%BF-SDK%20generated%20by%20Fern-brightgreen)](https://github.com/fern-api/fern)

## Documentation

API reference documentation is available [here](https://www.assemblyai.com/docs/).

## Installation

### Gradle

Add the dependency in your `build.gradle`:

```groovy
dependencies {
    implementation 'io.github.fern-api:assemblyai:0.x.x'
}
```

### Maven

Add the dependency in your `pom.xml`:

```xml
<dependency>
    <groupId>io.github.fern-api</groupId>
    <artifactId>assemblyai</artifactId>
    <version>0.x.x</version>
</dependency>
```

## HTTP Client Usage

The SDK exports a vanilla HTTP client, `AssemblyAIClient`. You can
use this to call into each of our API endpoints and get typed
responses back.

```typescript
import com.assemblyai.api.AssemblyAIClient;

AssemblyAIClient aai = AssemblyAIClient.builder()
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

## Using the Transcriber class
Additionally, the SDK also exports a Transcriber class that has
utilities on top of the HTTP client, such as automatic polling.

```typescript
import com.assemblyai.api.Transcriber;

Transcriber transcriber = Transcriber.builder()
  .apiKey("YOUR_API_KEY")
  .build();

TranscriptResponse transcript = transcriber.transcribe(
    "https://example.org/audio.mp3", true);
```


## Staged Builders
The generated builders all follow the staged builder pattern. 
Read more [here](https://immutables.github.io/immutable.html#staged-builder).
Staged builders only allow you to build the object once all required 
properties have been specified. 

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
