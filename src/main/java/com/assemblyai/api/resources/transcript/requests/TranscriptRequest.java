package com.assemblyai.api.resources.transcript.requests;

import com.assemblyai.api.core.ObjectMappers;
import com.assemblyai.api.types.TranscriptBoostParam;
import com.assemblyai.api.types.TranscriptCustomSpelling;
import com.assemblyai.api.types.TranscriptLanguageCode;
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
@JsonDeserialize(builder = TranscriptRequest.Builder.class)
public final class TranscriptRequest {
    private final Optional<String> audioUrl;

    private final Optional<TranscriptLanguageCode> languageCode;

    private final Optional<Boolean> speakerLabels;

    private final Optional<List<String>> wordBoost;

    private final Optional<TranscriptBoostParam> boostParam;

    private final Optional<List<TranscriptCustomSpelling>> customSpelling;

    private final Optional<Boolean> dualChannel;

    private final Optional<Boolean> disfluencies;

    private final Optional<Boolean> languageDetection;

    private final Optional<Boolean> punctuate;

    private final Optional<Boolean> formatText;

    private final Optional<Boolean> filterProfanity;

    private final Optional<String> webhookUrl;

    private final Optional<String> webhookAuthHeaderName;

    private final Optional<String> webhookAuthHeaderValue;

    private TranscriptRequest(
            Optional<String> audioUrl,
            Optional<TranscriptLanguageCode> languageCode,
            Optional<Boolean> speakerLabels,
            Optional<List<String>> wordBoost,
            Optional<TranscriptBoostParam> boostParam,
            Optional<List<TranscriptCustomSpelling>> customSpelling,
            Optional<Boolean> dualChannel,
            Optional<Boolean> disfluencies,
            Optional<Boolean> languageDetection,
            Optional<Boolean> punctuate,
            Optional<Boolean> formatText,
            Optional<Boolean> filterProfanity,
            Optional<String> webhookUrl,
            Optional<String> webhookAuthHeaderName,
            Optional<String> webhookAuthHeaderValue) {
        this.audioUrl = audioUrl;
        this.languageCode = languageCode;
        this.speakerLabels = speakerLabels;
        this.wordBoost = wordBoost;
        this.boostParam = boostParam;
        this.customSpelling = customSpelling;
        this.dualChannel = dualChannel;
        this.disfluencies = disfluencies;
        this.languageDetection = languageDetection;
        this.punctuate = punctuate;
        this.formatText = formatText;
        this.filterProfanity = filterProfanity;
        this.webhookUrl = webhookUrl;
        this.webhookAuthHeaderName = webhookAuthHeaderName;
        this.webhookAuthHeaderValue = webhookAuthHeaderValue;
    }

    @JsonProperty("audio_url")
    public Optional<String> getAudioUrl() {
        return audioUrl;
    }

    @JsonProperty("language_code")
    public Optional<TranscriptLanguageCode> getLanguageCode() {
        return languageCode;
    }

    @JsonProperty("speaker_labels")
    public Optional<Boolean> getSpeakerLabels() {
        return speakerLabels;
    }

    @JsonProperty("word_boost")
    public Optional<List<String>> getWordBoost() {
        return wordBoost;
    }

    @JsonProperty("boost_param")
    public Optional<TranscriptBoostParam> getBoostParam() {
        return boostParam;
    }

    @JsonProperty("custom_spelling")
    public Optional<List<TranscriptCustomSpelling>> getCustomSpelling() {
        return customSpelling;
    }

    @JsonProperty("dual_channel")
    public Optional<Boolean> getDualChannel() {
        return dualChannel;
    }

    @JsonProperty("disfluencies")
    public Optional<Boolean> getDisfluencies() {
        return disfluencies;
    }

    @JsonProperty("language_detection")
    public Optional<Boolean> getLanguageDetection() {
        return languageDetection;
    }

    @JsonProperty("punctuate")
    public Optional<Boolean> getPunctuate() {
        return punctuate;
    }

    @JsonProperty("format_text")
    public Optional<Boolean> getFormatText() {
        return formatText;
    }

    @JsonProperty("filter_profanity")
    public Optional<Boolean> getFilterProfanity() {
        return filterProfanity;
    }

    @JsonProperty("webhook_url")
    public Optional<String> getWebhookUrl() {
        return webhookUrl;
    }

    @JsonProperty("webhook_auth_header_name")
    public Optional<String> getWebhookAuthHeaderName() {
        return webhookAuthHeaderName;
    }

    @JsonProperty("webhook_auth_header_value")
    public Optional<String> getWebhookAuthHeaderValue() {
        return webhookAuthHeaderValue;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TranscriptRequest && equalTo((TranscriptRequest) other);
    }

    private boolean equalTo(TranscriptRequest other) {
        return audioUrl.equals(other.audioUrl)
                && languageCode.equals(other.languageCode)
                && speakerLabels.equals(other.speakerLabels)
                && wordBoost.equals(other.wordBoost)
                && boostParam.equals(other.boostParam)
                && customSpelling.equals(other.customSpelling)
                && dualChannel.equals(other.dualChannel)
                && disfluencies.equals(other.disfluencies)
                && languageDetection.equals(other.languageDetection)
                && punctuate.equals(other.punctuate)
                && formatText.equals(other.formatText)
                && filterProfanity.equals(other.filterProfanity)
                && webhookUrl.equals(other.webhookUrl)
                && webhookAuthHeaderName.equals(other.webhookAuthHeaderName)
                && webhookAuthHeaderValue.equals(other.webhookAuthHeaderValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.audioUrl,
                this.languageCode,
                this.speakerLabels,
                this.wordBoost,
                this.boostParam,
                this.customSpelling,
                this.dualChannel,
                this.disfluencies,
                this.languageDetection,
                this.punctuate,
                this.formatText,
                this.filterProfanity,
                this.webhookUrl,
                this.webhookAuthHeaderName,
                this.webhookAuthHeaderValue);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> audioUrl = Optional.empty();

        private Optional<TranscriptLanguageCode> languageCode = Optional.empty();

        private Optional<Boolean> speakerLabels = Optional.empty();

        private Optional<List<String>> wordBoost = Optional.empty();

        private Optional<TranscriptBoostParam> boostParam = Optional.empty();

        private Optional<List<TranscriptCustomSpelling>> customSpelling = Optional.empty();

        private Optional<Boolean> dualChannel = Optional.empty();

        private Optional<Boolean> disfluencies = Optional.empty();

        private Optional<Boolean> languageDetection = Optional.empty();

        private Optional<Boolean> punctuate = Optional.empty();

        private Optional<Boolean> formatText = Optional.empty();

        private Optional<Boolean> filterProfanity = Optional.empty();

        private Optional<String> webhookUrl = Optional.empty();

        private Optional<String> webhookAuthHeaderName = Optional.empty();

        private Optional<String> webhookAuthHeaderValue = Optional.empty();

        private Builder() {}

        public Builder from(TranscriptRequest other) {
            audioUrl(other.getAudioUrl());
            languageCode(other.getLanguageCode());
            speakerLabels(other.getSpeakerLabels());
            wordBoost(other.getWordBoost());
            boostParam(other.getBoostParam());
            customSpelling(other.getCustomSpelling());
            dualChannel(other.getDualChannel());
            disfluencies(other.getDisfluencies());
            languageDetection(other.getLanguageDetection());
            punctuate(other.getPunctuate());
            formatText(other.getFormatText());
            filterProfanity(other.getFilterProfanity());
            webhookUrl(other.getWebhookUrl());
            webhookAuthHeaderName(other.getWebhookAuthHeaderName());
            webhookAuthHeaderValue(other.getWebhookAuthHeaderValue());
            return this;
        }

        @JsonSetter(value = "audio_url", nulls = Nulls.SKIP)
        public Builder audioUrl(Optional<String> audioUrl) {
            this.audioUrl = audioUrl;
            return this;
        }

        public Builder audioUrl(String audioUrl) {
            this.audioUrl = Optional.of(audioUrl);
            return this;
        }

        @JsonSetter(value = "language_code", nulls = Nulls.SKIP)
        public Builder languageCode(Optional<TranscriptLanguageCode> languageCode) {
            this.languageCode = languageCode;
            return this;
        }

        public Builder languageCode(TranscriptLanguageCode languageCode) {
            this.languageCode = Optional.of(languageCode);
            return this;
        }

        @JsonSetter(value = "speaker_labels", nulls = Nulls.SKIP)
        public Builder speakerLabels(Optional<Boolean> speakerLabels) {
            this.speakerLabels = speakerLabels;
            return this;
        }

        public Builder speakerLabels(Boolean speakerLabels) {
            this.speakerLabels = Optional.of(speakerLabels);
            return this;
        }

        @JsonSetter(value = "word_boost", nulls = Nulls.SKIP)
        public Builder wordBoost(Optional<List<String>> wordBoost) {
            this.wordBoost = wordBoost;
            return this;
        }

        public Builder wordBoost(List<String> wordBoost) {
            this.wordBoost = Optional.of(wordBoost);
            return this;
        }

        @JsonSetter(value = "boost_param", nulls = Nulls.SKIP)
        public Builder boostParam(Optional<TranscriptBoostParam> boostParam) {
            this.boostParam = boostParam;
            return this;
        }

        public Builder boostParam(TranscriptBoostParam boostParam) {
            this.boostParam = Optional.of(boostParam);
            return this;
        }

        @JsonSetter(value = "custom_spelling", nulls = Nulls.SKIP)
        public Builder customSpelling(Optional<List<TranscriptCustomSpelling>> customSpelling) {
            this.customSpelling = customSpelling;
            return this;
        }

        public Builder customSpelling(List<TranscriptCustomSpelling> customSpelling) {
            this.customSpelling = Optional.of(customSpelling);
            return this;
        }

        @JsonSetter(value = "dual_channel", nulls = Nulls.SKIP)
        public Builder dualChannel(Optional<Boolean> dualChannel) {
            this.dualChannel = dualChannel;
            return this;
        }

        public Builder dualChannel(Boolean dualChannel) {
            this.dualChannel = Optional.of(dualChannel);
            return this;
        }

        @JsonSetter(value = "disfluencies", nulls = Nulls.SKIP)
        public Builder disfluencies(Optional<Boolean> disfluencies) {
            this.disfluencies = disfluencies;
            return this;
        }

        public Builder disfluencies(Boolean disfluencies) {
            this.disfluencies = Optional.of(disfluencies);
            return this;
        }

        @JsonSetter(value = "language_detection", nulls = Nulls.SKIP)
        public Builder languageDetection(Optional<Boolean> languageDetection) {
            this.languageDetection = languageDetection;
            return this;
        }

        public Builder languageDetection(Boolean languageDetection) {
            this.languageDetection = Optional.of(languageDetection);
            return this;
        }

        @JsonSetter(value = "punctuate", nulls = Nulls.SKIP)
        public Builder punctuate(Optional<Boolean> punctuate) {
            this.punctuate = punctuate;
            return this;
        }

        public Builder punctuate(Boolean punctuate) {
            this.punctuate = Optional.of(punctuate);
            return this;
        }

        @JsonSetter(value = "format_text", nulls = Nulls.SKIP)
        public Builder formatText(Optional<Boolean> formatText) {
            this.formatText = formatText;
            return this;
        }

        public Builder formatText(Boolean formatText) {
            this.formatText = Optional.of(formatText);
            return this;
        }

        @JsonSetter(value = "filter_profanity", nulls = Nulls.SKIP)
        public Builder filterProfanity(Optional<Boolean> filterProfanity) {
            this.filterProfanity = filterProfanity;
            return this;
        }

        public Builder filterProfanity(Boolean filterProfanity) {
            this.filterProfanity = Optional.of(filterProfanity);
            return this;
        }

        @JsonSetter(value = "webhook_url", nulls = Nulls.SKIP)
        public Builder webhookUrl(Optional<String> webhookUrl) {
            this.webhookUrl = webhookUrl;
            return this;
        }

        public Builder webhookUrl(String webhookUrl) {
            this.webhookUrl = Optional.of(webhookUrl);
            return this;
        }

        @JsonSetter(value = "webhook_auth_header_name", nulls = Nulls.SKIP)
        public Builder webhookAuthHeaderName(Optional<String> webhookAuthHeaderName) {
            this.webhookAuthHeaderName = webhookAuthHeaderName;
            return this;
        }

        public Builder webhookAuthHeaderName(String webhookAuthHeaderName) {
            this.webhookAuthHeaderName = Optional.of(webhookAuthHeaderName);
            return this;
        }

        @JsonSetter(value = "webhook_auth_header_value", nulls = Nulls.SKIP)
        public Builder webhookAuthHeaderValue(Optional<String> webhookAuthHeaderValue) {
            this.webhookAuthHeaderValue = webhookAuthHeaderValue;
            return this;
        }

        public Builder webhookAuthHeaderValue(String webhookAuthHeaderValue) {
            this.webhookAuthHeaderValue = Optional.of(webhookAuthHeaderValue);
            return this;
        }

        public TranscriptRequest build() {
            return new TranscriptRequest(
                    audioUrl,
                    languageCode,
                    speakerLabels,
                    wordBoost,
                    boostParam,
                    customSpelling,
                    dualChannel,
                    disfluencies,
                    languageDetection,
                    punctuate,
                    formatText,
                    filterProfanity,
                    webhookUrl,
                    webhookAuthHeaderName,
                    webhookAuthHeaderValue);
        }
    }
}
