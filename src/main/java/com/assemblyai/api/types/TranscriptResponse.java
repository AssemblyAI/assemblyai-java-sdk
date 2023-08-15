package com.assemblyai.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = TranscriptResponse.Builder.class)
public final class TranscriptResponse {
    private final String id;

    private final Optional<TranscriptStatus> status;

    private final Optional<String> acousticModel;

    private final Optional<Double> audioDuration;

    private final Optional<String> audioUrl;

    private final Optional<Double> confidence;

    private final Optional<Boolean> dualChannel;

    private final Optional<Boolean> formatText;

    private final Optional<String> languageModel;

    private final Optional<Boolean> languageDetection;

    private final Optional<Boolean> punctuate;

    private final Optional<String> text;

    private final Optional<List<TranscriptUtterance>> utterances;

    private final Optional<Double> webhookStatusCode;

    private final Optional<String> webhookUrl;

    private final Optional<List<TranscriptWord>> words;

    private TranscriptResponse(
            String id,
            Optional<TranscriptStatus> status,
            Optional<String> acousticModel,
            Optional<Double> audioDuration,
            Optional<String> audioUrl,
            Optional<Double> confidence,
            Optional<Boolean> dualChannel,
            Optional<Boolean> formatText,
            Optional<String> languageModel,
            Optional<Boolean> languageDetection,
            Optional<Boolean> punctuate,
            Optional<String> text,
            Optional<List<TranscriptUtterance>> utterances,
            Optional<Double> webhookStatusCode,
            Optional<String> webhookUrl,
            Optional<List<TranscriptWord>> words) {
        this.id = id;
        this.status = status;
        this.acousticModel = acousticModel;
        this.audioDuration = audioDuration;
        this.audioUrl = audioUrl;
        this.confidence = confidence;
        this.dualChannel = dualChannel;
        this.formatText = formatText;
        this.languageModel = languageModel;
        this.languageDetection = languageDetection;
        this.punctuate = punctuate;
        this.text = text;
        this.utterances = utterances;
        this.webhookStatusCode = webhookStatusCode;
        this.webhookUrl = webhookUrl;
        this.words = words;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("status")
    public Optional<TranscriptStatus> getStatus() {
        return status;
    }

    @JsonProperty("acoustic_model")
    public Optional<String> getAcousticModel() {
        return acousticModel;
    }

    @JsonProperty("audio_duration")
    public Optional<Double> getAudioDuration() {
        return audioDuration;
    }

    @JsonProperty("audio_url")
    public Optional<String> getAudioUrl() {
        return audioUrl;
    }

    @JsonProperty("confidence")
    public Optional<Double> getConfidence() {
        return confidence;
    }

    @JsonProperty("dual_channel")
    public Optional<Boolean> getDualChannel() {
        return dualChannel;
    }

    @JsonProperty("format_text")
    public Optional<Boolean> getFormatText() {
        return formatText;
    }

    @JsonProperty("language_model")
    public Optional<String> getLanguageModel() {
        return languageModel;
    }

    @JsonProperty("language_detection")
    public Optional<Boolean> getLanguageDetection() {
        return languageDetection;
    }

    @JsonProperty("punctuate")
    public Optional<Boolean> getPunctuate() {
        return punctuate;
    }

    @JsonProperty("text")
    public Optional<String> getText() {
        return text;
    }

    @JsonProperty("utterances")
    public Optional<List<TranscriptUtterance>> getUtterances() {
        return utterances;
    }

    @JsonProperty("webhook_status_code")
    public Optional<Double> getWebhookStatusCode() {
        return webhookStatusCode;
    }

    @JsonProperty("webhook_url")
    public Optional<String> getWebhookUrl() {
        return webhookUrl;
    }

    @JsonProperty("words")
    public Optional<List<TranscriptWord>> getWords() {
        return words;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TranscriptResponse && equalTo((TranscriptResponse) other);
    }

    private boolean equalTo(TranscriptResponse other) {
        return id.equals(other.id)
                && status.equals(other.status)
                && acousticModel.equals(other.acousticModel)
                && audioDuration.equals(other.audioDuration)
                && audioUrl.equals(other.audioUrl)
                && confidence.equals(other.confidence)
                && dualChannel.equals(other.dualChannel)
                && formatText.equals(other.formatText)
                && languageModel.equals(other.languageModel)
                && languageDetection.equals(other.languageDetection)
                && punctuate.equals(other.punctuate)
                && text.equals(other.text)
                && utterances.equals(other.utterances)
                && webhookStatusCode.equals(other.webhookStatusCode)
                && webhookUrl.equals(other.webhookUrl)
                && words.equals(other.words);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.status,
                this.acousticModel,
                this.audioDuration,
                this.audioUrl,
                this.confidence,
                this.dualChannel,
                this.formatText,
                this.languageModel,
                this.languageDetection,
                this.punctuate,
                this.text,
                this.utterances,
                this.webhookStatusCode,
                this.webhookUrl,
                this.words);
    }

    @Override
    public String toString() {
        return "TranscriptResponse{" + "id: " + id + ", status: " + status + ", acousticModel: " + acousticModel
                + ", audioDuration: " + audioDuration + ", audioUrl: " + audioUrl + ", confidence: " + confidence
                + ", dualChannel: " + dualChannel + ", formatText: " + formatText + ", languageModel: " + languageModel
                + ", languageDetection: " + languageDetection + ", punctuate: " + punctuate + ", text: " + text
                + ", utterances: " + utterances + ", webhookStatusCode: " + webhookStatusCode + ", webhookUrl: "
                + webhookUrl + ", words: " + words + "}";
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        _FinalStage id(String id);

        Builder from(TranscriptResponse other);
    }

    public interface _FinalStage {
        TranscriptResponse build();

        _FinalStage status(Optional<TranscriptStatus> status);

        _FinalStage status(TranscriptStatus status);

        _FinalStage acousticModel(Optional<String> acousticModel);

        _FinalStage acousticModel(String acousticModel);

        _FinalStage audioDuration(Optional<Double> audioDuration);

        _FinalStage audioDuration(Double audioDuration);

        _FinalStage audioUrl(Optional<String> audioUrl);

        _FinalStage audioUrl(String audioUrl);

        _FinalStage confidence(Optional<Double> confidence);

        _FinalStage confidence(Double confidence);

        _FinalStage dualChannel(Optional<Boolean> dualChannel);

        _FinalStage dualChannel(Boolean dualChannel);

        _FinalStage formatText(Optional<Boolean> formatText);

        _FinalStage formatText(Boolean formatText);

        _FinalStage languageModel(Optional<String> languageModel);

        _FinalStage languageModel(String languageModel);

        _FinalStage languageDetection(Optional<Boolean> languageDetection);

        _FinalStage languageDetection(Boolean languageDetection);

        _FinalStage punctuate(Optional<Boolean> punctuate);

        _FinalStage punctuate(Boolean punctuate);

        _FinalStage text(Optional<String> text);

        _FinalStage text(String text);

        _FinalStage utterances(Optional<List<TranscriptUtterance>> utterances);

        _FinalStage utterances(List<TranscriptUtterance> utterances);

        _FinalStage webhookStatusCode(Optional<Double> webhookStatusCode);

        _FinalStage webhookStatusCode(Double webhookStatusCode);

        _FinalStage webhookUrl(Optional<String> webhookUrl);

        _FinalStage webhookUrl(String webhookUrl);

        _FinalStage words(Optional<List<TranscriptWord>> words);

        _FinalStage words(List<TranscriptWord> words);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdStage, _FinalStage {
        private String id;

        private Optional<List<TranscriptWord>> words = Optional.empty();

        private Optional<String> webhookUrl = Optional.empty();

        private Optional<Double> webhookStatusCode = Optional.empty();

        private Optional<List<TranscriptUtterance>> utterances = Optional.empty();

        private Optional<String> text = Optional.empty();

        private Optional<Boolean> punctuate = Optional.empty();

        private Optional<Boolean> languageDetection = Optional.empty();

        private Optional<String> languageModel = Optional.empty();

        private Optional<Boolean> formatText = Optional.empty();

        private Optional<Boolean> dualChannel = Optional.empty();

        private Optional<Double> confidence = Optional.empty();

        private Optional<String> audioUrl = Optional.empty();

        private Optional<Double> audioDuration = Optional.empty();

        private Optional<String> acousticModel = Optional.empty();

        private Optional<TranscriptStatus> status = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(TranscriptResponse other) {
            id(other.getId());
            status(other.getStatus());
            acousticModel(other.getAcousticModel());
            audioDuration(other.getAudioDuration());
            audioUrl(other.getAudioUrl());
            confidence(other.getConfidence());
            dualChannel(other.getDualChannel());
            formatText(other.getFormatText());
            languageModel(other.getLanguageModel());
            languageDetection(other.getLanguageDetection());
            punctuate(other.getPunctuate());
            text(other.getText());
            utterances(other.getUtterances());
            webhookStatusCode(other.getWebhookStatusCode());
            webhookUrl(other.getWebhookUrl());
            words(other.getWords());
            return this;
        }

        @Override
        @JsonSetter("id")
        public _FinalStage id(String id) {
            this.id = id;
            return this;
        }

        @Override
        public _FinalStage words(List<TranscriptWord> words) {
            this.words = Optional.of(words);
            return this;
        }

        @Override
        @JsonSetter(value = "words", nulls = Nulls.SKIP)
        public _FinalStage words(Optional<List<TranscriptWord>> words) {
            this.words = words;
            return this;
        }

        @Override
        public _FinalStage webhookUrl(String webhookUrl) {
            this.webhookUrl = Optional.of(webhookUrl);
            return this;
        }

        @Override
        @JsonSetter(value = "webhook_url", nulls = Nulls.SKIP)
        public _FinalStage webhookUrl(Optional<String> webhookUrl) {
            this.webhookUrl = webhookUrl;
            return this;
        }

        @Override
        public _FinalStage webhookStatusCode(Double webhookStatusCode) {
            this.webhookStatusCode = Optional.of(webhookStatusCode);
            return this;
        }

        @Override
        @JsonSetter(value = "webhook_status_code", nulls = Nulls.SKIP)
        public _FinalStage webhookStatusCode(Optional<Double> webhookStatusCode) {
            this.webhookStatusCode = webhookStatusCode;
            return this;
        }

        @Override
        public _FinalStage utterances(List<TranscriptUtterance> utterances) {
            this.utterances = Optional.of(utterances);
            return this;
        }

        @Override
        @JsonSetter(value = "utterances", nulls = Nulls.SKIP)
        public _FinalStage utterances(Optional<List<TranscriptUtterance>> utterances) {
            this.utterances = utterances;
            return this;
        }

        @Override
        public _FinalStage text(String text) {
            this.text = Optional.of(text);
            return this;
        }

        @Override
        @JsonSetter(value = "text", nulls = Nulls.SKIP)
        public _FinalStage text(Optional<String> text) {
            this.text = text;
            return this;
        }

        @Override
        public _FinalStage punctuate(Boolean punctuate) {
            this.punctuate = Optional.of(punctuate);
            return this;
        }

        @Override
        @JsonSetter(value = "punctuate", nulls = Nulls.SKIP)
        public _FinalStage punctuate(Optional<Boolean> punctuate) {
            this.punctuate = punctuate;
            return this;
        }

        @Override
        public _FinalStage languageDetection(Boolean languageDetection) {
            this.languageDetection = Optional.of(languageDetection);
            return this;
        }

        @Override
        @JsonSetter(value = "language_detection", nulls = Nulls.SKIP)
        public _FinalStage languageDetection(Optional<Boolean> languageDetection) {
            this.languageDetection = languageDetection;
            return this;
        }

        @Override
        public _FinalStage languageModel(String languageModel) {
            this.languageModel = Optional.of(languageModel);
            return this;
        }

        @Override
        @JsonSetter(value = "language_model", nulls = Nulls.SKIP)
        public _FinalStage languageModel(Optional<String> languageModel) {
            this.languageModel = languageModel;
            return this;
        }

        @Override
        public _FinalStage formatText(Boolean formatText) {
            this.formatText = Optional.of(formatText);
            return this;
        }

        @Override
        @JsonSetter(value = "format_text", nulls = Nulls.SKIP)
        public _FinalStage formatText(Optional<Boolean> formatText) {
            this.formatText = formatText;
            return this;
        }

        @Override
        public _FinalStage dualChannel(Boolean dualChannel) {
            this.dualChannel = Optional.of(dualChannel);
            return this;
        }

        @Override
        @JsonSetter(value = "dual_channel", nulls = Nulls.SKIP)
        public _FinalStage dualChannel(Optional<Boolean> dualChannel) {
            this.dualChannel = dualChannel;
            return this;
        }

        @Override
        public _FinalStage confidence(Double confidence) {
            this.confidence = Optional.of(confidence);
            return this;
        }

        @Override
        @JsonSetter(value = "confidence", nulls = Nulls.SKIP)
        public _FinalStage confidence(Optional<Double> confidence) {
            this.confidence = confidence;
            return this;
        }

        @Override
        public _FinalStage audioUrl(String audioUrl) {
            this.audioUrl = Optional.of(audioUrl);
            return this;
        }

        @Override
        @JsonSetter(value = "audio_url", nulls = Nulls.SKIP)
        public _FinalStage audioUrl(Optional<String> audioUrl) {
            this.audioUrl = audioUrl;
            return this;
        }

        @Override
        public _FinalStage audioDuration(Double audioDuration) {
            this.audioDuration = Optional.of(audioDuration);
            return this;
        }

        @Override
        @JsonSetter(value = "audio_duration", nulls = Nulls.SKIP)
        public _FinalStage audioDuration(Optional<Double> audioDuration) {
            this.audioDuration = audioDuration;
            return this;
        }

        @Override
        public _FinalStage acousticModel(String acousticModel) {
            this.acousticModel = Optional.of(acousticModel);
            return this;
        }

        @Override
        @JsonSetter(value = "acoustic_model", nulls = Nulls.SKIP)
        public _FinalStage acousticModel(Optional<String> acousticModel) {
            this.acousticModel = acousticModel;
            return this;
        }

        @Override
        public _FinalStage status(TranscriptStatus status) {
            this.status = Optional.of(status);
            return this;
        }

        @Override
        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public _FinalStage status(Optional<TranscriptStatus> status) {
            this.status = status;
            return this;
        }

        @Override
        public TranscriptResponse build() {
            return new TranscriptResponse(
                    id,
                    status,
                    acousticModel,
                    audioDuration,
                    audioUrl,
                    confidence,
                    dualChannel,
                    formatText,
                    languageModel,
                    languageDetection,
                    punctuate,
                    text,
                    utterances,
                    webhookStatusCode,
                    webhookUrl,
                    words);
        }
    }
}
