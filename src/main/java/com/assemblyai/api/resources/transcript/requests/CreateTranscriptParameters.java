package com.assemblyai.api.resources.transcript.requests;

import com.assemblyai.api.core.ObjectMappers;
import com.assemblyai.api.types.PiiPolicies;
import com.assemblyai.api.types.SubstitutionPolicy;
import com.assemblyai.api.types.SummaryModel;
import com.assemblyai.api.types.SummaryType;
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
@JsonDeserialize(builder = CreateTranscriptParameters.Builder.class)
public final class CreateTranscriptParameters {
    private final Optional<String> audioUrl;

    private final Optional<TranscriptLanguageCode> languageCode;

    private final Optional<Boolean> punctuate;

    private final Optional<Boolean> formatText;

    private final Optional<Boolean> dualChannel;

    private final Optional<String> webhookUrl;

    private final Optional<String> webhookAuthHeaderName;

    private final Optional<String> webhookAuthHeaderValue;

    private final Optional<Integer> audioStartFrom;

    private final Optional<Integer> audioEndAt;

    private final Optional<List<String>> wordBoost;

    private final Optional<TranscriptBoostParam> boostParam;

    private final Optional<Boolean> filterProfanity;

    private final Optional<Boolean> redactPii;

    private final Optional<Boolean> redactPiiAudio;

    private final Optional<String> redactPiiAudioQuality;

    private final Optional<List<PiiPolicies>> redactPiiPolicies;

    private final Optional<SubstitutionPolicy> redactPiiSub;

    private final Optional<Boolean> speakerLabels;

    private final Optional<Integer> speakersExpected;

    private final Optional<Boolean> contentSafety;

    private final Optional<Boolean> iabCategories;

    private final Optional<Boolean> languageDetection;

    private final Optional<List<TranscriptCustomSpelling>> customSpelling;

    private final Optional<Boolean> disfluencies;

    private final Optional<Boolean> sentimentAnalysis;

    private final Optional<Boolean> autoChapters;

    private final Optional<Boolean> entityDetection;

    private final Optional<Double> speechThreshold;

    private final Optional<Boolean> summarization;

    private final Optional<SummaryModel> summaryModel;

    private final Optional<SummaryType> summaryType;

    private CreateTranscriptParameters(
            Optional<String> audioUrl,
            Optional<TranscriptLanguageCode> languageCode,
            Optional<Boolean> punctuate,
            Optional<Boolean> formatText,
            Optional<Boolean> dualChannel,
            Optional<String> webhookUrl,
            Optional<String> webhookAuthHeaderName,
            Optional<String> webhookAuthHeaderValue,
            Optional<Integer> audioStartFrom,
            Optional<Integer> audioEndAt,
            Optional<List<String>> wordBoost,
            Optional<TranscriptBoostParam> boostParam,
            Optional<Boolean> filterProfanity,
            Optional<Boolean> redactPii,
            Optional<Boolean> redactPiiAudio,
            Optional<String> redactPiiAudioQuality,
            Optional<List<PiiPolicies>> redactPiiPolicies,
            Optional<SubstitutionPolicy> redactPiiSub,
            Optional<Boolean> speakerLabels,
            Optional<Integer> speakersExpected,
            Optional<Boolean> contentSafety,
            Optional<Boolean> iabCategories,
            Optional<Boolean> languageDetection,
            Optional<List<TranscriptCustomSpelling>> customSpelling,
            Optional<Boolean> disfluencies,
            Optional<Boolean> sentimentAnalysis,
            Optional<Boolean> autoChapters,
            Optional<Boolean> entityDetection,
            Optional<Double> speechThreshold,
            Optional<Boolean> summarization,
            Optional<SummaryModel> summaryModel,
            Optional<SummaryType> summaryType) {
        this.audioUrl = audioUrl;
        this.languageCode = languageCode;
        this.punctuate = punctuate;
        this.formatText = formatText;
        this.dualChannel = dualChannel;
        this.webhookUrl = webhookUrl;
        this.webhookAuthHeaderName = webhookAuthHeaderName;
        this.webhookAuthHeaderValue = webhookAuthHeaderValue;
        this.audioStartFrom = audioStartFrom;
        this.audioEndAt = audioEndAt;
        this.wordBoost = wordBoost;
        this.boostParam = boostParam;
        this.filterProfanity = filterProfanity;
        this.redactPii = redactPii;
        this.redactPiiAudio = redactPiiAudio;
        this.redactPiiAudioQuality = redactPiiAudioQuality;
        this.redactPiiPolicies = redactPiiPolicies;
        this.redactPiiSub = redactPiiSub;
        this.speakerLabels = speakerLabels;
        this.speakersExpected = speakersExpected;
        this.contentSafety = contentSafety;
        this.iabCategories = iabCategories;
        this.languageDetection = languageDetection;
        this.customSpelling = customSpelling;
        this.disfluencies = disfluencies;
        this.sentimentAnalysis = sentimentAnalysis;
        this.autoChapters = autoChapters;
        this.entityDetection = entityDetection;
        this.speechThreshold = speechThreshold;
        this.summarization = summarization;
        this.summaryModel = summaryModel;
        this.summaryType = summaryType;
    }

    /**
     * @return The URL of the audio or video file to transcribe.
     */
    @JsonProperty("audio_url")
    public Optional<String> getAudioUrl() {
        return audioUrl;
    }

    /**
     * @return The language of your audio file. Possible values are found in <a href="https://www.assemblyai.com/docs/Concepts/supported_languages">Supported Languages</a>. The default value is 'en_us'.
     */
    @JsonProperty("language_code")
    public Optional<TranscriptLanguageCode> getLanguageCode() {
        return languageCode;
    }

    /**
     * @return Enable Automatic Punctuation, can be true or false.
     */
    @JsonProperty("punctuate")
    public Optional<Boolean> getPunctuate() {
        return punctuate;
    }

    /**
     * @return Enable Text Formatting, can be true or false.
     */
    @JsonProperty("format_text")
    public Optional<Boolean> getFormatText() {
        return formatText;
    }

    /**
     * @return Enable <a href="https://assemblyai.com/docs/Models/speech_recognition#dual-channel-transcription">Dual Channel</a> transcription, can be true or false.
     */
    @JsonProperty("dual_channel")
    public Optional<Boolean> getDualChannel() {
        return dualChannel;
    }

    /**
     * @return The URL to which we send webhooks upon trancription completion, if provided in the transcription request.
     */
    @JsonProperty("webhook_url")
    public Optional<String> getWebhookUrl() {
        return webhookUrl;
    }

    /**
     * @return The header name which should be sent back with webhook calls, if provided in the transcription request.
     */
    @JsonProperty("webhook_auth_header_name")
    public Optional<String> getWebhookAuthHeaderName() {
        return webhookAuthHeaderName;
    }

    /**
     * @return Defaults to null. Optionally allows a user to specify a header name and value to send back with a webhook call for added security.
     */
    @JsonProperty("webhook_auth_header_value")
    public Optional<String> getWebhookAuthHeaderValue() {
        return webhookAuthHeaderValue;
    }

    /**
     * @return The point in time, in milliseconds, to begin transcription from in your media file
     */
    @JsonProperty("audio_start_from")
    public Optional<Integer> getAudioStartFrom() {
        return audioStartFrom;
    }

    /**
     * @return The point in time, in milliseconds, to stop transcribing in your media file
     */
    @JsonProperty("audio_end_at")
    public Optional<Integer> getAudioEndAt() {
        return audioEndAt;
    }

    /**
     * @return The list of custom vocabulary to boost transcription probability for, if provided in the transcription request.
     */
    @JsonProperty("word_boost")
    public Optional<List<String>> getWordBoost() {
        return wordBoost;
    }

    /**
     * @return The word boost parameter value, if provided in the transcription request.
     */
    @JsonProperty("boost_param")
    public Optional<TranscriptBoostParam> getBoostParam() {
        return boostParam;
    }

    /**
     * @return Filter profanity from the transcribed text, can be true or false.
     */
    @JsonProperty("filter_profanity")
    public Optional<Boolean> getFilterProfanity() {
        return filterProfanity;
    }

    /**
     * @return Redact PII from the transcribed text using the Redact PII model, can be true or false
     */
    @JsonProperty("redact_pii")
    public Optional<Boolean> getRedactPii() {
        return redactPii;
    }

    /**
     * @return Generate a copy of the original media file with spoken PII &quot;beeped&quot; out, can be true or false. See <a href="https://www.assemblyai.com/docs/Models/pii_redaction">PII redaction</a> for more details.
     */
    @JsonProperty("redact_pii_audio")
    public Optional<Boolean> getRedactPiiAudio() {
        return redactPiiAudio;
    }

    /**
     * @return Controls the filetype of the audio created by redact_pii_audio. Currently supports mp3 (default) and wav. See <a href="https://www.assemblyai.com/docs/Models/pii_redaction">PII redaction</a> for more details.
     */
    @JsonProperty("redact_pii_audio_quality")
    public Optional<String> getRedactPiiAudioQuality() {
        return redactPiiAudioQuality;
    }

    /**
     * @return The list of PII Redaction policies to enable. See <a href="https://www.assemblyai.com/docs/Models/pii_redaction">PII redaction</a> for more details.
     */
    @JsonProperty("redact_pii_policies")
    public Optional<List<PiiPolicies>> getRedactPiiPolicies() {
        return redactPiiPolicies;
    }

    /**
     * @return The replacement logic for detected PII, can be &quot;entity_type&quot; or &quot;hash&quot;. See <a href="https://www.assemblyai.com/docs/Models/pii_redaction">PII redaction</a> for more details.
     */
    @JsonProperty("redact_pii_sub")
    public Optional<SubstitutionPolicy> getRedactPiiSub() {
        return redactPiiSub;
    }

    /**
     * @return Enable <a href="https://www.assemblyai.com/docs/Models/speaker_diarization">Speaker diarization</a>, can be true or false
     */
    @JsonProperty("speaker_labels")
    public Optional<Boolean> getSpeakerLabels() {
        return speakerLabels;
    }

    /**
     * @return Tells the speaker label model how many speakers it should attempt to identify, up to 10. See <a href="https://www.assemblyai.com/docs/Models/speaker_diarization">Speaker diarization</a> for more details.
     */
    @JsonProperty("speakers_expected")
    public Optional<Integer> getSpeakersExpected() {
        return speakersExpected;
    }

    /**
     * @return Enable <a href="https://www.assemblyai.com/docs/Models/content_moderation">Content Moderation</a>, can be true or false
     */
    @JsonProperty("content_safety")
    public Optional<Boolean> getContentSafety() {
        return contentSafety;
    }

    /**
     * @return Enable <a href="https://www.assemblyai.com/docs/Models/iab_classification">Topic Detection</a>, can be true or false
     */
    @JsonProperty("iab_categories")
    public Optional<Boolean> getIabCategories() {
        return iabCategories;
    }

    /**
     * @return Whether <a href="https://www.assemblyai.com/docs/Models/speech_recognition#automatic-language-detection">Automatic language detection</a> was enabled in the transcription request, either true or false.
     */
    @JsonProperty("language_detection")
    public Optional<Boolean> getLanguageDetection() {
        return languageDetection;
    }

    /**
     * @return Customize how words are spelled and formatted using to and from values
     */
    @JsonProperty("custom_spelling")
    public Optional<List<TranscriptCustomSpelling>> getCustomSpelling() {
        return customSpelling;
    }

    /**
     * @return Transcribe Filler Words, like &quot;umm&quot;, in your media file; can be true or false.
     */
    @JsonProperty("disfluencies")
    public Optional<Boolean> getDisfluencies() {
        return disfluencies;
    }

    /**
     * @return Enable <a href="https://www.assemblyai.com/docs/Models/sentiment_analysis">Sentiment Analysis</a>, can be true or false
     */
    @JsonProperty("sentiment_analysis")
    public Optional<Boolean> getSentimentAnalysis() {
        return sentimentAnalysis;
    }

    /**
     * @return Enable <a href="https://www.assemblyai.com/docs/Models/auto_chapters">Auto Chapters</a>, can be true or false
     */
    @JsonProperty("auto_chapters")
    public Optional<Boolean> getAutoChapters() {
        return autoChapters;
    }

    /**
     * @return Enable <a href="https://www.assemblyai.com/docs/Models/entity_detection">Entity Detection</a>, can be true or false
     */
    @JsonProperty("entity_detection")
    public Optional<Boolean> getEntityDetection() {
        return entityDetection;
    }

    /**
     * @return Reject audio files that contain less than this fraction of speech. Valid values are in the range [0, 1] inclusive.
     */
    @JsonProperty("speech_threshold")
    public Optional<Double> getSpeechThreshold() {
        return speechThreshold;
    }

    /**
     * @return Enable <a href="https://www.assemblyai.com/docs/Models/summarization">Summarization</a>, can be true or false
     */
    @JsonProperty("summarization")
    public Optional<Boolean> getSummarization() {
        return summarization;
    }

    /**
     * @return The model to summarize the transcript
     */
    @JsonProperty("summary_model")
    public Optional<SummaryModel> getSummaryModel() {
        return summaryModel;
    }

    /**
     * @return The type of summary
     */
    @JsonProperty("summary_type")
    public Optional<SummaryType> getSummaryType() {
        return summaryType;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateTranscriptParameters && equalTo((CreateTranscriptParameters) other);
    }

    private boolean equalTo(CreateTranscriptParameters other) {
        return audioUrl.equals(other.audioUrl)
                && languageCode.equals(other.languageCode)
                && punctuate.equals(other.punctuate)
                && formatText.equals(other.formatText)
                && dualChannel.equals(other.dualChannel)
                && webhookUrl.equals(other.webhookUrl)
                && webhookAuthHeaderName.equals(other.webhookAuthHeaderName)
                && webhookAuthHeaderValue.equals(other.webhookAuthHeaderValue)
                && audioStartFrom.equals(other.audioStartFrom)
                && audioEndAt.equals(other.audioEndAt)
                && wordBoost.equals(other.wordBoost)
                && boostParam.equals(other.boostParam)
                && filterProfanity.equals(other.filterProfanity)
                && redactPii.equals(other.redactPii)
                && redactPiiAudio.equals(other.redactPiiAudio)
                && redactPiiAudioQuality.equals(other.redactPiiAudioQuality)
                && redactPiiPolicies.equals(other.redactPiiPolicies)
                && redactPiiSub.equals(other.redactPiiSub)
                && speakerLabels.equals(other.speakerLabels)
                && speakersExpected.equals(other.speakersExpected)
                && contentSafety.equals(other.contentSafety)
                && iabCategories.equals(other.iabCategories)
                && languageDetection.equals(other.languageDetection)
                && customSpelling.equals(other.customSpelling)
                && disfluencies.equals(other.disfluencies)
                && sentimentAnalysis.equals(other.sentimentAnalysis)
                && autoChapters.equals(other.autoChapters)
                && entityDetection.equals(other.entityDetection)
                && speechThreshold.equals(other.speechThreshold)
                && summarization.equals(other.summarization)
                && summaryModel.equals(other.summaryModel)
                && summaryType.equals(other.summaryType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.audioUrl,
                this.languageCode,
                this.punctuate,
                this.formatText,
                this.dualChannel,
                this.webhookUrl,
                this.webhookAuthHeaderName,
                this.webhookAuthHeaderValue,
                this.audioStartFrom,
                this.audioEndAt,
                this.wordBoost,
                this.boostParam,
                this.filterProfanity,
                this.redactPii,
                this.redactPiiAudio,
                this.redactPiiAudioQuality,
                this.redactPiiPolicies,
                this.redactPiiSub,
                this.speakerLabels,
                this.speakersExpected,
                this.contentSafety,
                this.iabCategories,
                this.languageDetection,
                this.customSpelling,
                this.disfluencies,
                this.sentimentAnalysis,
                this.autoChapters,
                this.entityDetection,
                this.speechThreshold,
                this.summarization,
                this.summaryModel,
                this.summaryType);
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

        private Optional<Boolean> punctuate = Optional.empty();

        private Optional<Boolean> formatText = Optional.empty();

        private Optional<Boolean> dualChannel = Optional.empty();

        private Optional<String> webhookUrl = Optional.empty();

        private Optional<String> webhookAuthHeaderName = Optional.empty();

        private Optional<String> webhookAuthHeaderValue = Optional.empty();

        private Optional<Integer> audioStartFrom = Optional.empty();

        private Optional<Integer> audioEndAt = Optional.empty();

        private Optional<List<String>> wordBoost = Optional.empty();

        private Optional<TranscriptBoostParam> boostParam = Optional.empty();

        private Optional<Boolean> filterProfanity = Optional.empty();

        private Optional<Boolean> redactPii = Optional.empty();

        private Optional<Boolean> redactPiiAudio = Optional.empty();

        private Optional<String> redactPiiAudioQuality = Optional.empty();

        private Optional<List<PiiPolicies>> redactPiiPolicies = Optional.empty();

        private Optional<SubstitutionPolicy> redactPiiSub = Optional.empty();

        private Optional<Boolean> speakerLabels = Optional.empty();

        private Optional<Integer> speakersExpected = Optional.empty();

        private Optional<Boolean> contentSafety = Optional.empty();

        private Optional<Boolean> iabCategories = Optional.empty();

        private Optional<Boolean> languageDetection = Optional.empty();

        private Optional<List<TranscriptCustomSpelling>> customSpelling = Optional.empty();

        private Optional<Boolean> disfluencies = Optional.empty();

        private Optional<Boolean> sentimentAnalysis = Optional.empty();

        private Optional<Boolean> autoChapters = Optional.empty();

        private Optional<Boolean> entityDetection = Optional.empty();

        private Optional<Double> speechThreshold = Optional.empty();

        private Optional<Boolean> summarization = Optional.empty();

        private Optional<SummaryModel> summaryModel = Optional.empty();

        private Optional<SummaryType> summaryType = Optional.empty();

        private Builder() {}

        public Builder from(CreateTranscriptParameters other) {
            audioUrl(other.getAudioUrl());
            languageCode(other.getLanguageCode());
            punctuate(other.getPunctuate());
            formatText(other.getFormatText());
            dualChannel(other.getDualChannel());
            webhookUrl(other.getWebhookUrl());
            webhookAuthHeaderName(other.getWebhookAuthHeaderName());
            webhookAuthHeaderValue(other.getWebhookAuthHeaderValue());
            audioStartFrom(other.getAudioStartFrom());
            audioEndAt(other.getAudioEndAt());
            wordBoost(other.getWordBoost());
            boostParam(other.getBoostParam());
            filterProfanity(other.getFilterProfanity());
            redactPii(other.getRedactPii());
            redactPiiAudio(other.getRedactPiiAudio());
            redactPiiAudioQuality(other.getRedactPiiAudioQuality());
            redactPiiPolicies(other.getRedactPiiPolicies());
            redactPiiSub(other.getRedactPiiSub());
            speakerLabels(other.getSpeakerLabels());
            speakersExpected(other.getSpeakersExpected());
            contentSafety(other.getContentSafety());
            iabCategories(other.getIabCategories());
            languageDetection(other.getLanguageDetection());
            customSpelling(other.getCustomSpelling());
            disfluencies(other.getDisfluencies());
            sentimentAnalysis(other.getSentimentAnalysis());
            autoChapters(other.getAutoChapters());
            entityDetection(other.getEntityDetection());
            speechThreshold(other.getSpeechThreshold());
            summarization(other.getSummarization());
            summaryModel(other.getSummaryModel());
            summaryType(other.getSummaryType());
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

        @JsonSetter(value = "dual_channel", nulls = Nulls.SKIP)
        public Builder dualChannel(Optional<Boolean> dualChannel) {
            this.dualChannel = dualChannel;
            return this;
        }

        public Builder dualChannel(Boolean dualChannel) {
            this.dualChannel = Optional.of(dualChannel);
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

        @JsonSetter(value = "audio_start_from", nulls = Nulls.SKIP)
        public Builder audioStartFrom(Optional<Integer> audioStartFrom) {
            this.audioStartFrom = audioStartFrom;
            return this;
        }

        public Builder audioStartFrom(Integer audioStartFrom) {
            this.audioStartFrom = Optional.of(audioStartFrom);
            return this;
        }

        @JsonSetter(value = "audio_end_at", nulls = Nulls.SKIP)
        public Builder audioEndAt(Optional<Integer> audioEndAt) {
            this.audioEndAt = audioEndAt;
            return this;
        }

        public Builder audioEndAt(Integer audioEndAt) {
            this.audioEndAt = Optional.of(audioEndAt);
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

        @JsonSetter(value = "filter_profanity", nulls = Nulls.SKIP)
        public Builder filterProfanity(Optional<Boolean> filterProfanity) {
            this.filterProfanity = filterProfanity;
            return this;
        }

        public Builder filterProfanity(Boolean filterProfanity) {
            this.filterProfanity = Optional.of(filterProfanity);
            return this;
        }

        @JsonSetter(value = "redact_pii", nulls = Nulls.SKIP)
        public Builder redactPii(Optional<Boolean> redactPii) {
            this.redactPii = redactPii;
            return this;
        }

        public Builder redactPii(Boolean redactPii) {
            this.redactPii = Optional.of(redactPii);
            return this;
        }

        @JsonSetter(value = "redact_pii_audio", nulls = Nulls.SKIP)
        public Builder redactPiiAudio(Optional<Boolean> redactPiiAudio) {
            this.redactPiiAudio = redactPiiAudio;
            return this;
        }

        public Builder redactPiiAudio(Boolean redactPiiAudio) {
            this.redactPiiAudio = Optional.of(redactPiiAudio);
            return this;
        }

        @JsonSetter(value = "redact_pii_audio_quality", nulls = Nulls.SKIP)
        public Builder redactPiiAudioQuality(Optional<String> redactPiiAudioQuality) {
            this.redactPiiAudioQuality = redactPiiAudioQuality;
            return this;
        }

        public Builder redactPiiAudioQuality(String redactPiiAudioQuality) {
            this.redactPiiAudioQuality = Optional.of(redactPiiAudioQuality);
            return this;
        }

        @JsonSetter(value = "redact_pii_policies", nulls = Nulls.SKIP)
        public Builder redactPiiPolicies(Optional<List<PiiPolicies>> redactPiiPolicies) {
            this.redactPiiPolicies = redactPiiPolicies;
            return this;
        }

        public Builder redactPiiPolicies(List<PiiPolicies> redactPiiPolicies) {
            this.redactPiiPolicies = Optional.of(redactPiiPolicies);
            return this;
        }

        @JsonSetter(value = "redact_pii_sub", nulls = Nulls.SKIP)
        public Builder redactPiiSub(Optional<SubstitutionPolicy> redactPiiSub) {
            this.redactPiiSub = redactPiiSub;
            return this;
        }

        public Builder redactPiiSub(SubstitutionPolicy redactPiiSub) {
            this.redactPiiSub = Optional.of(redactPiiSub);
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

        @JsonSetter(value = "speakers_expected", nulls = Nulls.SKIP)
        public Builder speakersExpected(Optional<Integer> speakersExpected) {
            this.speakersExpected = speakersExpected;
            return this;
        }

        public Builder speakersExpected(Integer speakersExpected) {
            this.speakersExpected = Optional.of(speakersExpected);
            return this;
        }

        @JsonSetter(value = "content_safety", nulls = Nulls.SKIP)
        public Builder contentSafety(Optional<Boolean> contentSafety) {
            this.contentSafety = contentSafety;
            return this;
        }

        public Builder contentSafety(Boolean contentSafety) {
            this.contentSafety = Optional.of(contentSafety);
            return this;
        }

        @JsonSetter(value = "iab_categories", nulls = Nulls.SKIP)
        public Builder iabCategories(Optional<Boolean> iabCategories) {
            this.iabCategories = iabCategories;
            return this;
        }

        public Builder iabCategories(Boolean iabCategories) {
            this.iabCategories = Optional.of(iabCategories);
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

        @JsonSetter(value = "custom_spelling", nulls = Nulls.SKIP)
        public Builder customSpelling(Optional<List<TranscriptCustomSpelling>> customSpelling) {
            this.customSpelling = customSpelling;
            return this;
        }

        public Builder customSpelling(List<TranscriptCustomSpelling> customSpelling) {
            this.customSpelling = Optional.of(customSpelling);
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

        @JsonSetter(value = "sentiment_analysis", nulls = Nulls.SKIP)
        public Builder sentimentAnalysis(Optional<Boolean> sentimentAnalysis) {
            this.sentimentAnalysis = sentimentAnalysis;
            return this;
        }

        public Builder sentimentAnalysis(Boolean sentimentAnalysis) {
            this.sentimentAnalysis = Optional.of(sentimentAnalysis);
            return this;
        }

        @JsonSetter(value = "auto_chapters", nulls = Nulls.SKIP)
        public Builder autoChapters(Optional<Boolean> autoChapters) {
            this.autoChapters = autoChapters;
            return this;
        }

        public Builder autoChapters(Boolean autoChapters) {
            this.autoChapters = Optional.of(autoChapters);
            return this;
        }

        @JsonSetter(value = "entity_detection", nulls = Nulls.SKIP)
        public Builder entityDetection(Optional<Boolean> entityDetection) {
            this.entityDetection = entityDetection;
            return this;
        }

        public Builder entityDetection(Boolean entityDetection) {
            this.entityDetection = Optional.of(entityDetection);
            return this;
        }

        @JsonSetter(value = "speech_threshold", nulls = Nulls.SKIP)
        public Builder speechThreshold(Optional<Double> speechThreshold) {
            this.speechThreshold = speechThreshold;
            return this;
        }

        public Builder speechThreshold(Double speechThreshold) {
            this.speechThreshold = Optional.of(speechThreshold);
            return this;
        }

        @JsonSetter(value = "summarization", nulls = Nulls.SKIP)
        public Builder summarization(Optional<Boolean> summarization) {
            this.summarization = summarization;
            return this;
        }

        public Builder summarization(Boolean summarization) {
            this.summarization = Optional.of(summarization);
            return this;
        }

        @JsonSetter(value = "summary_model", nulls = Nulls.SKIP)
        public Builder summaryModel(Optional<SummaryModel> summaryModel) {
            this.summaryModel = summaryModel;
            return this;
        }

        public Builder summaryModel(SummaryModel summaryModel) {
            this.summaryModel = Optional.of(summaryModel);
            return this;
        }

        @JsonSetter(value = "summary_type", nulls = Nulls.SKIP)
        public Builder summaryType(Optional<SummaryType> summaryType) {
            this.summaryType = summaryType;
            return this;
        }

        public Builder summaryType(SummaryType summaryType) {
            this.summaryType = Optional.of(summaryType);
            return this;
        }

        public CreateTranscriptParameters build() {
            return new CreateTranscriptParameters(
                    audioUrl,
                    languageCode,
                    punctuate,
                    formatText,
                    dualChannel,
                    webhookUrl,
                    webhookAuthHeaderName,
                    webhookAuthHeaderValue,
                    audioStartFrom,
                    audioEndAt,
                    wordBoost,
                    boostParam,
                    filterProfanity,
                    redactPii,
                    redactPiiAudio,
                    redactPiiAudioQuality,
                    redactPiiPolicies,
                    redactPiiSub,
                    speakerLabels,
                    speakersExpected,
                    contentSafety,
                    iabCategories,
                    languageDetection,
                    customSpelling,
                    disfluencies,
                    sentimentAnalysis,
                    autoChapters,
                    entityDetection,
                    speechThreshold,
                    summarization,
                    summaryModel,
                    summaryType);
        }
    }
}
