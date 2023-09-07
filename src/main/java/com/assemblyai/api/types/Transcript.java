package com.assemblyai.api.types;

import com.assemblyai.api.core.ObjectMappers;
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
@JsonDeserialize(builder = Transcript.Builder.class)
public final class Transcript {
    private final String id;

    private final Optional<String> languageModel;

    private final Optional<String> acousticModel;

    private final Optional<TranscriptStatus> status;

    private final Optional<TranscriptLanguageCode> languageCode;

    private final Optional<String> audioUrl;

    private final Optional<String> text;

    private final Optional<List<TranscriptWord>> words;

    private final Optional<List<TranscriptUtterance>> utterances;

    private final Optional<Double> confidence;

    private final Optional<Double> audioDuration;

    private final Optional<Boolean> punctuate;

    private final Optional<Boolean> formatText;

    private final Optional<Boolean> dualChannel;

    private final Optional<String> webhookUrl;

    private final Optional<Integer> webhookStatusCode;

    private final Optional<Boolean> webhookAuth;

    private final Optional<String> webhookAuthHeaderName;

    private final Optional<Boolean> speedBoost;

    private final Optional<Boolean> autoHighlights;

    private final Optional<AutoHighlightsResult> autoHighlightsResult;

    private final Optional<Integer> audioStartFrom;

    private final Optional<Integer> audioEndAt;

    private final Optional<List<String>> wordBoost;

    private final Optional<String> boostParam;

    private final Optional<Boolean> filterProfanity;

    private final Optional<Boolean> redactPii;

    private final Optional<Boolean> redactPiiAudio;

    private final Optional<String> redactPiiAudioQuality;

    private final Optional<List<PiiPolicies>> redactPiiPolicies;

    private final Optional<SubstitutionPolicy> redactPiiSub;

    private final Optional<Boolean> speakerLabels;

    private final Optional<Integer> speakersExpected;

    private final Optional<Boolean> contentSafety;

    private final Optional<TranscriptContentSafetyLabels> contentSafetyLabels;

    private final Optional<Boolean> iabCategories;

    private final Optional<TranscriptIabCategoriesResult> iabCategoriesResult;

    private final Optional<Boolean> languageDetection;

    private final Optional<List<TranscriptCustomSpelling>> customSpelling;

    private final Optional<Boolean> autoChapters;

    private final Optional<Boolean> summarization;

    private final Optional<String> summaryType;

    private final Optional<String> summaryModel;

    private final Optional<String> summary;

    private final Optional<Boolean> customTopics;

    private final Optional<List<String>> topics;

    private final Optional<Boolean> disfluencies;

    private final Optional<Boolean> sentimentAnalysis;

    private final Optional<List<SentimentAnalysisResult>> sentimentAnalysisResults;

    private final Optional<Boolean> entityDetection;

    private final Optional<List<Entity>> entities;

    private final Optional<Double> speechThreshold;

    private final Optional<Boolean> throttled;

    private final Optional<String> error;

    private Transcript(
            String id,
            Optional<String> languageModel,
            Optional<String> acousticModel,
            Optional<TranscriptStatus> status,
            Optional<TranscriptLanguageCode> languageCode,
            Optional<String> audioUrl,
            Optional<String> text,
            Optional<List<TranscriptWord>> words,
            Optional<List<TranscriptUtterance>> utterances,
            Optional<Double> confidence,
            Optional<Double> audioDuration,
            Optional<Boolean> punctuate,
            Optional<Boolean> formatText,
            Optional<Boolean> dualChannel,
            Optional<String> webhookUrl,
            Optional<Integer> webhookStatusCode,
            Optional<Boolean> webhookAuth,
            Optional<String> webhookAuthHeaderName,
            Optional<Boolean> speedBoost,
            Optional<Boolean> autoHighlights,
            Optional<AutoHighlightsResult> autoHighlightsResult,
            Optional<Integer> audioStartFrom,
            Optional<Integer> audioEndAt,
            Optional<List<String>> wordBoost,
            Optional<String> boostParam,
            Optional<Boolean> filterProfanity,
            Optional<Boolean> redactPii,
            Optional<Boolean> redactPiiAudio,
            Optional<String> redactPiiAudioQuality,
            Optional<List<PiiPolicies>> redactPiiPolicies,
            Optional<SubstitutionPolicy> redactPiiSub,
            Optional<Boolean> speakerLabels,
            Optional<Integer> speakersExpected,
            Optional<Boolean> contentSafety,
            Optional<TranscriptContentSafetyLabels> contentSafetyLabels,
            Optional<Boolean> iabCategories,
            Optional<TranscriptIabCategoriesResult> iabCategoriesResult,
            Optional<Boolean> languageDetection,
            Optional<List<TranscriptCustomSpelling>> customSpelling,
            Optional<Boolean> autoChapters,
            Optional<Boolean> summarization,
            Optional<String> summaryType,
            Optional<String> summaryModel,
            Optional<String> summary,
            Optional<Boolean> customTopics,
            Optional<List<String>> topics,
            Optional<Boolean> disfluencies,
            Optional<Boolean> sentimentAnalysis,
            Optional<List<SentimentAnalysisResult>> sentimentAnalysisResults,
            Optional<Boolean> entityDetection,
            Optional<List<Entity>> entities,
            Optional<Double> speechThreshold,
            Optional<Boolean> throttled,
            Optional<String> error) {
        this.id = id;
        this.languageModel = languageModel;
        this.acousticModel = acousticModel;
        this.status = status;
        this.languageCode = languageCode;
        this.audioUrl = audioUrl;
        this.text = text;
        this.words = words;
        this.utterances = utterances;
        this.confidence = confidence;
        this.audioDuration = audioDuration;
        this.punctuate = punctuate;
        this.formatText = formatText;
        this.dualChannel = dualChannel;
        this.webhookUrl = webhookUrl;
        this.webhookStatusCode = webhookStatusCode;
        this.webhookAuth = webhookAuth;
        this.webhookAuthHeaderName = webhookAuthHeaderName;
        this.speedBoost = speedBoost;
        this.autoHighlights = autoHighlights;
        this.autoHighlightsResult = autoHighlightsResult;
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
        this.contentSafetyLabels = contentSafetyLabels;
        this.iabCategories = iabCategories;
        this.iabCategoriesResult = iabCategoriesResult;
        this.languageDetection = languageDetection;
        this.customSpelling = customSpelling;
        this.autoChapters = autoChapters;
        this.summarization = summarization;
        this.summaryType = summaryType;
        this.summaryModel = summaryModel;
        this.summary = summary;
        this.customTopics = customTopics;
        this.topics = topics;
        this.disfluencies = disfluencies;
        this.sentimentAnalysis = sentimentAnalysis;
        this.sentimentAnalysisResults = sentimentAnalysisResults;
        this.entityDetection = entityDetection;
        this.entities = entities;
        this.speechThreshold = speechThreshold;
        this.throttled = throttled;
        this.error = error;
    }

    /**
     * @return The unique identifier of your transcription
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @return The language model that was used for the transcription
     */
    @JsonProperty("language_model")
    public Optional<String> getLanguageModel() {
        return languageModel;
    }

    /**
     * @return The acoustic model that was used for the transcription
     */
    @JsonProperty("acoustic_model")
    public Optional<String> getAcousticModel() {
        return acousticModel;
    }

    /**
     * @return The status of your transcription. Possible values are queued, processing, completed, or error.
     */
    @JsonProperty("status")
    public Optional<TranscriptStatus> getStatus() {
        return status;
    }

    /**
     * @return The language of your audio file. Possible values are found in <a href="https://www.assemblyai.com/docs/Concepts/supported_languages">Supported Languages</a>. The default value is 'en_us'.
     */
    @JsonProperty("language_code")
    public Optional<TranscriptLanguageCode> getLanguageCode() {
        return languageCode;
    }

    /**
     * @return The URL of the media that was transcribed
     */
    @JsonProperty("audio_url")
    public Optional<String> getAudioUrl() {
        return audioUrl;
    }

    /**
     * @return The textual transcript of your media file
     */
    @JsonProperty("text")
    public Optional<String> getText() {
        return text;
    }

    /**
     * @return An array of temporally-sequential word objects, one for each word in the transcript. See <a href="https://www.assemblyai.com/docs/Models/speech_recognition">Speech recognition</a> for more information.
     */
    @JsonProperty("words")
    public Optional<List<TranscriptWord>> getWords() {
        return words;
    }

    /**
     * @return When dual_channel or speaker_labels is enabled, a list of turn-by-turn utterance objects. See <a href="https://www.assemblyai.com/docs/Models/speaker_diarization">Speaker diarization</a> for more information.
     */
    @JsonProperty("utterances")
    public Optional<List<TranscriptUtterance>> getUtterances() {
        return utterances;
    }

    /**
     * @return The confidence score for the transcript, between 0.0 (low confidence) and 1.0 (high confidence)
     */
    @JsonProperty("confidence")
    public Optional<Double> getConfidence() {
        return confidence;
    }

    /**
     * @return The duration of this transcript object's media file, in seconds
     */
    @JsonProperty("audio_duration")
    public Optional<Double> getAudioDuration() {
        return audioDuration;
    }

    /**
     * @return Whether Automatic Punctuation was enabled in the transcription request, either true or false.
     */
    @JsonProperty("punctuate")
    public Optional<Boolean> getPunctuate() {
        return punctuate;
    }

    /**
     * @return Whether Text Formatting was enabled in the transcription request, either true or false
     */
    @JsonProperty("format_text")
    public Optional<Boolean> getFormatText() {
        return formatText;
    }

    /**
     * @return Whether <a href="https://www.assemblyai.com/docs/Models/speech_recognition#dual-channel-transcription">Dual channel transcription</a> was enabled in the transcription request, either true or false
     */
    @JsonProperty("dual_channel")
    public Optional<Boolean> getDualChannel() {
        return dualChannel;
    }

    /**
     * @return The URL to which we send webhooks upon trancription completion, if provided in the transcription request
     */
    @JsonProperty("webhook_url")
    public Optional<String> getWebhookUrl() {
        return webhookUrl;
    }

    /**
     * @return The status code we received from your server when delivering your webhook, if a webhook URL was provided in the transcription request
     */
    @JsonProperty("webhook_status_code")
    public Optional<Integer> getWebhookStatusCode() {
        return webhookStatusCode;
    }

    /**
     * @return Whether webhook authentication details were provided in the transcription request
     */
    @JsonProperty("webhook_auth")
    public Optional<Boolean> getWebhookAuth() {
        return webhookAuth;
    }

    /**
     * @return The header name which should be sent back with webhook calls, if provided in the transcription request
     */
    @JsonProperty("webhook_auth_header_name")
    public Optional<String> getWebhookAuthHeaderName() {
        return webhookAuthHeaderName;
    }

    /**
     * @return Whether speed boost was enabled in the transcription request
     */
    @JsonProperty("speed_boost")
    public Optional<Boolean> getSpeedBoost() {
        return speedBoost;
    }

    /**
     * @return Whether Key Phrases was enabled in the transcription request, either true or false
     */
    @JsonProperty("auto_highlights")
    public Optional<Boolean> getAutoHighlights() {
        return autoHighlights;
    }

    /**
     * @return An array of results for the Key Phrases model, if it was enabled during the transcription request. See <a href="https://www.assemblyai.com/docs/Models/key_phrases">Key phrases</a> for more information.
     */
    @JsonProperty("auto_highlights_result")
    public Optional<AutoHighlightsResult> getAutoHighlightsResult() {
        return autoHighlightsResult;
    }

    /**
     * @return The point in time, in milliseconds, in the file at which the transcription was started, if provided in the transcription request
     */
    @JsonProperty("audio_start_from")
    public Optional<Integer> getAudioStartFrom() {
        return audioStartFrom;
    }

    /**
     * @return The point in time, in milliseconds, in the file at which the transcription was terminated, if provided in the transcription request
     */
    @JsonProperty("audio_end_at")
    public Optional<Integer> getAudioEndAt() {
        return audioEndAt;
    }

    /**
     * @return The list of custom vocabulary to boost transcription probability for, if provided in the transcription request
     */
    @JsonProperty("word_boost")
    public Optional<List<String>> getWordBoost() {
        return wordBoost;
    }

    /**
     * @return The word boost parameter value, if provided in the transcription request
     */
    @JsonProperty("boost_param")
    public Optional<String> getBoostParam() {
        return boostParam;
    }

    /**
     * @return Whether <a href="https://www.assemblyai.com/docs/Models/speech_recognition#profanity-filtering">Profanity Filtering</a> was enabled in the transcription request, either true or false
     */
    @JsonProperty("filter_profanity")
    public Optional<Boolean> getFilterProfanity() {
        return filterProfanity;
    }

    /**
     * @return Whether <a href="https://www.assemblyai.com/docs/Models/pii_redaction">PII Redaction</a> was enabled in the transcription request, either true or false
     */
    @JsonProperty("redact_pii")
    public Optional<Boolean> getRedactPii() {
        return redactPii;
    }

    /**
     * @return Whether a redacted version of the audio file was generated (enabled or disabled in the transcription request), either true or false. See <a href="https://www.assemblyai.com/docs/Models/pii_redaction">PII redaction</a> for more information.
     */
    @JsonProperty("redact_pii_audio")
    public Optional<Boolean> getRedactPiiAudio() {
        return redactPiiAudio;
    }

    /**
     * @return The audio quality of the PII-redacted audio file, if enabled in the transcription request. See <a href="https://www.assemblyai.com/docs/Models/pii_redaction">PII redaction</a> for more information.
     */
    @JsonProperty("redact_pii_audio_quality")
    public Optional<String> getRedactPiiAudioQuality() {
        return redactPiiAudioQuality;
    }

    /**
     * @return The list of PII Redaction policies that were enabled, if PII Redaction is enabled. See <a href="https://www.assemblyai.com/docs/Models/pii_redaction">PII redaction</a> for more information.
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
     * @return Defaults to null. Tells the speaker label model how many speakers it should attempt to identify, up to 10. See <a href="https://www.assemblyai.com/docs/Models/speaker_diarization">Speaker diarization</a> for more details.
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
     * @return An array of results for the Content Moderation model, if it was enabled during the transcription request. See <a href="https://www.assemblyai.com/docs/Models/content_moderation">Content moderation</a> for more information.
     */
    @JsonProperty("content_safety_labels")
    public Optional<TranscriptContentSafetyLabels> getContentSafetyLabels() {
        return contentSafetyLabels;
    }

    /**
     * @return Enable <a href="https://www.assemblyai.com/docs/Models/iab_classification">Topic Detection</a>, can be true or false
     */
    @JsonProperty("iab_categories")
    public Optional<Boolean> getIabCategories() {
        return iabCategories;
    }

    /**
     * @return An array of results for the Topic Detection model, if it was enabled during the transcription request. See <a href="https://www.assemblyai.com/docs/Models/iab_classification">Topic Detection</a> for more information.
     */
    @JsonProperty("iab_categories_result")
    public Optional<TranscriptIabCategoriesResult> getIabCategoriesResult() {
        return iabCategoriesResult;
    }

    /**
     * @return Whether <a href="https://www.assemblyai.com/docs/Models/speech_recognition#automatic-language-detection">Automatic language detection</a> was enabled in the transcription request, either true or false
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
     * @return Enable <a href="https://www.assemblyai.com/docs/Models/auto_chapters">Auto Chapters</a>, can be true or false
     */
    @JsonProperty("auto_chapters")
    public Optional<Boolean> getAutoChapters() {
        return autoChapters;
    }

    /**
     * @return Whether <a href="https://www.assemblyai.com/docs/Models/summarization">Summarization</a> was enabled in the transcription request, either true or false
     */
    @JsonProperty("summarization")
    public Optional<Boolean> getSummarization() {
        return summarization;
    }

    /**
     * @return The type of summary generated, if <a href="https://www.assemblyai.com/docs/Models/summarization">Summarization</a> was enabled in the transcription request
     */
    @JsonProperty("summary_type")
    public Optional<String> getSummaryType() {
        return summaryType;
    }

    /**
     * @return The Summarization model used to generate the summary, if <a href="https://www.assemblyai.com/docs/Models/summarization">Summarization</a> was enabled in the transcription request
     */
    @JsonProperty("summary_model")
    public Optional<String> getSummaryModel() {
        return summaryModel;
    }

    /**
     * @return The generated summary of the media file, if <a href="https://www.assemblyai.com/docs/Models/summarization">Summarization</a> was enabled in the transcription request
     */
    @JsonProperty("summary")
    public Optional<String> getSummary() {
        return summary;
    }

    /**
     * @return Whether custom topics was enabled in the transcription request, either true or false
     */
    @JsonProperty("custom_topics")
    public Optional<Boolean> getCustomTopics() {
        return customTopics;
    }

    /**
     * @return The list of custom topics provided if custom topics was enabled in the transcription request
     */
    @JsonProperty("topics")
    public Optional<List<String>> getTopics() {
        return topics;
    }

    /**
     * @return Transcribe Filler Words, like &quot;umm&quot;, in your media file; can be true or false
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
     * @return An array of results for the Sentiment Analysis model, if it was enabled during the transcription request. See <a href="https://www.assemblyai.com/docs/Models/sentiment_analysis">Sentiment analysis</a> for more information.
     */
    @JsonProperty("sentiment_analysis_results")
    public Optional<List<SentimentAnalysisResult>> getSentimentAnalysisResults() {
        return sentimentAnalysisResults;
    }

    /**
     * @return Enable <a href="https://www.assemblyai.com/docs/Models/entity_detection">Entity Detection</a>, can be true or false
     */
    @JsonProperty("entity_detection")
    public Optional<Boolean> getEntityDetection() {
        return entityDetection;
    }

    /**
     * @return An array of results for the Entity Detection model, if it was enabled during the transcription request. See <a href="https://www.assemblyai.com/docs/Models/entity_detection">Entity detection</a> for more information.
     */
    @JsonProperty("entities")
    public Optional<List<Entity>> getEntities() {
        return entities;
    }

    /**
     * @return Defaults to null. Reject audio files that contain less than this fraction of speech. Valid values are in the range [0, 1] inclusive.
     */
    @JsonProperty("speech_threshold")
    public Optional<Double> getSpeechThreshold() {
        return speechThreshold;
    }

    /**
     * @return True while a request is throttled and false when a request is no longer throttled
     */
    @JsonProperty("throttled")
    public Optional<Boolean> getThrottled() {
        return throttled;
    }

    /**
     * @return Error message of why the transcript failed
     */
    @JsonProperty("error")
    public Optional<String> getError() {
        return error;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Transcript && equalTo((Transcript) other);
    }

    private boolean equalTo(Transcript other) {
        return id.equals(other.id)
                && languageModel.equals(other.languageModel)
                && acousticModel.equals(other.acousticModel)
                && status.equals(other.status)
                && languageCode.equals(other.languageCode)
                && audioUrl.equals(other.audioUrl)
                && text.equals(other.text)
                && words.equals(other.words)
                && utterances.equals(other.utterances)
                && confidence.equals(other.confidence)
                && audioDuration.equals(other.audioDuration)
                && punctuate.equals(other.punctuate)
                && formatText.equals(other.formatText)
                && dualChannel.equals(other.dualChannel)
                && webhookUrl.equals(other.webhookUrl)
                && webhookStatusCode.equals(other.webhookStatusCode)
                && webhookAuth.equals(other.webhookAuth)
                && webhookAuthHeaderName.equals(other.webhookAuthHeaderName)
                && speedBoost.equals(other.speedBoost)
                && autoHighlights.equals(other.autoHighlights)
                && autoHighlightsResult.equals(other.autoHighlightsResult)
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
                && contentSafetyLabels.equals(other.contentSafetyLabels)
                && iabCategories.equals(other.iabCategories)
                && iabCategoriesResult.equals(other.iabCategoriesResult)
                && languageDetection.equals(other.languageDetection)
                && customSpelling.equals(other.customSpelling)
                && autoChapters.equals(other.autoChapters)
                && summarization.equals(other.summarization)
                && summaryType.equals(other.summaryType)
                && summaryModel.equals(other.summaryModel)
                && summary.equals(other.summary)
                && customTopics.equals(other.customTopics)
                && topics.equals(other.topics)
                && disfluencies.equals(other.disfluencies)
                && sentimentAnalysis.equals(other.sentimentAnalysis)
                && sentimentAnalysisResults.equals(other.sentimentAnalysisResults)
                && entityDetection.equals(other.entityDetection)
                && entities.equals(other.entities)
                && speechThreshold.equals(other.speechThreshold)
                && throttled.equals(other.throttled)
                && error.equals(other.error);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.languageModel,
                this.acousticModel,
                this.status,
                this.languageCode,
                this.audioUrl,
                this.text,
                this.words,
                this.utterances,
                this.confidence,
                this.audioDuration,
                this.punctuate,
                this.formatText,
                this.dualChannel,
                this.webhookUrl,
                this.webhookStatusCode,
                this.webhookAuth,
                this.webhookAuthHeaderName,
                this.speedBoost,
                this.autoHighlights,
                this.autoHighlightsResult,
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
                this.contentSafetyLabels,
                this.iabCategories,
                this.iabCategoriesResult,
                this.languageDetection,
                this.customSpelling,
                this.autoChapters,
                this.summarization,
                this.summaryType,
                this.summaryModel,
                this.summary,
                this.customTopics,
                this.topics,
                this.disfluencies,
                this.sentimentAnalysis,
                this.sentimentAnalysisResults,
                this.entityDetection,
                this.entities,
                this.speechThreshold,
                this.throttled,
                this.error);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        _FinalStage id(String id);

        Builder from(Transcript other);
    }

    public interface _FinalStage {
        Transcript build();

        _FinalStage languageModel(Optional<String> languageModel);

        _FinalStage languageModel(String languageModel);

        _FinalStage acousticModel(Optional<String> acousticModel);

        _FinalStage acousticModel(String acousticModel);

        _FinalStage status(Optional<TranscriptStatus> status);

        _FinalStage status(TranscriptStatus status);

        _FinalStage languageCode(Optional<TranscriptLanguageCode> languageCode);

        _FinalStage languageCode(TranscriptLanguageCode languageCode);

        _FinalStage audioUrl(Optional<String> audioUrl);

        _FinalStage audioUrl(String audioUrl);

        _FinalStage text(Optional<String> text);

        _FinalStage text(String text);

        _FinalStage words(Optional<List<TranscriptWord>> words);

        _FinalStage words(List<TranscriptWord> words);

        _FinalStage utterances(Optional<List<TranscriptUtterance>> utterances);

        _FinalStage utterances(List<TranscriptUtterance> utterances);

        _FinalStage confidence(Optional<Double> confidence);

        _FinalStage confidence(Double confidence);

        _FinalStage audioDuration(Optional<Double> audioDuration);

        _FinalStage audioDuration(Double audioDuration);

        _FinalStage punctuate(Optional<Boolean> punctuate);

        _FinalStage punctuate(Boolean punctuate);

        _FinalStage formatText(Optional<Boolean> formatText);

        _FinalStage formatText(Boolean formatText);

        _FinalStage dualChannel(Optional<Boolean> dualChannel);

        _FinalStage dualChannel(Boolean dualChannel);

        _FinalStage webhookUrl(Optional<String> webhookUrl);

        _FinalStage webhookUrl(String webhookUrl);

        _FinalStage webhookStatusCode(Optional<Integer> webhookStatusCode);

        _FinalStage webhookStatusCode(Integer webhookStatusCode);

        _FinalStage webhookAuth(Optional<Boolean> webhookAuth);

        _FinalStage webhookAuth(Boolean webhookAuth);

        _FinalStage webhookAuthHeaderName(Optional<String> webhookAuthHeaderName);

        _FinalStage webhookAuthHeaderName(String webhookAuthHeaderName);

        _FinalStage speedBoost(Optional<Boolean> speedBoost);

        _FinalStage speedBoost(Boolean speedBoost);

        _FinalStage autoHighlights(Optional<Boolean> autoHighlights);

        _FinalStage autoHighlights(Boolean autoHighlights);

        _FinalStage autoHighlightsResult(Optional<AutoHighlightsResult> autoHighlightsResult);

        _FinalStage autoHighlightsResult(AutoHighlightsResult autoHighlightsResult);

        _FinalStage audioStartFrom(Optional<Integer> audioStartFrom);

        _FinalStage audioStartFrom(Integer audioStartFrom);

        _FinalStage audioEndAt(Optional<Integer> audioEndAt);

        _FinalStage audioEndAt(Integer audioEndAt);

        _FinalStage wordBoost(Optional<List<String>> wordBoost);

        _FinalStage wordBoost(List<String> wordBoost);

        _FinalStage boostParam(Optional<String> boostParam);

        _FinalStage boostParam(String boostParam);

        _FinalStage filterProfanity(Optional<Boolean> filterProfanity);

        _FinalStage filterProfanity(Boolean filterProfanity);

        _FinalStage redactPii(Optional<Boolean> redactPii);

        _FinalStage redactPii(Boolean redactPii);

        _FinalStage redactPiiAudio(Optional<Boolean> redactPiiAudio);

        _FinalStage redactPiiAudio(Boolean redactPiiAudio);

        _FinalStage redactPiiAudioQuality(Optional<String> redactPiiAudioQuality);

        _FinalStage redactPiiAudioQuality(String redactPiiAudioQuality);

        _FinalStage redactPiiPolicies(Optional<List<PiiPolicies>> redactPiiPolicies);

        _FinalStage redactPiiPolicies(List<PiiPolicies> redactPiiPolicies);

        _FinalStage redactPiiSub(Optional<SubstitutionPolicy> redactPiiSub);

        _FinalStage redactPiiSub(SubstitutionPolicy redactPiiSub);

        _FinalStage speakerLabels(Optional<Boolean> speakerLabels);

        _FinalStage speakerLabels(Boolean speakerLabels);

        _FinalStage speakersExpected(Optional<Integer> speakersExpected);

        _FinalStage speakersExpected(Integer speakersExpected);

        _FinalStage contentSafety(Optional<Boolean> contentSafety);

        _FinalStage contentSafety(Boolean contentSafety);

        _FinalStage contentSafetyLabels(Optional<TranscriptContentSafetyLabels> contentSafetyLabels);

        _FinalStage contentSafetyLabels(TranscriptContentSafetyLabels contentSafetyLabels);

        _FinalStage iabCategories(Optional<Boolean> iabCategories);

        _FinalStage iabCategories(Boolean iabCategories);

        _FinalStage iabCategoriesResult(Optional<TranscriptIabCategoriesResult> iabCategoriesResult);

        _FinalStage iabCategoriesResult(TranscriptIabCategoriesResult iabCategoriesResult);

        _FinalStage languageDetection(Optional<Boolean> languageDetection);

        _FinalStage languageDetection(Boolean languageDetection);

        _FinalStage customSpelling(Optional<List<TranscriptCustomSpelling>> customSpelling);

        _FinalStage customSpelling(List<TranscriptCustomSpelling> customSpelling);

        _FinalStage autoChapters(Optional<Boolean> autoChapters);

        _FinalStage autoChapters(Boolean autoChapters);

        _FinalStage summarization(Optional<Boolean> summarization);

        _FinalStage summarization(Boolean summarization);

        _FinalStage summaryType(Optional<String> summaryType);

        _FinalStage summaryType(String summaryType);

        _FinalStage summaryModel(Optional<String> summaryModel);

        _FinalStage summaryModel(String summaryModel);

        _FinalStage summary(Optional<String> summary);

        _FinalStage summary(String summary);

        _FinalStage customTopics(Optional<Boolean> customTopics);

        _FinalStage customTopics(Boolean customTopics);

        _FinalStage topics(Optional<List<String>> topics);

        _FinalStage topics(List<String> topics);

        _FinalStage disfluencies(Optional<Boolean> disfluencies);

        _FinalStage disfluencies(Boolean disfluencies);

        _FinalStage sentimentAnalysis(Optional<Boolean> sentimentAnalysis);

        _FinalStage sentimentAnalysis(Boolean sentimentAnalysis);

        _FinalStage sentimentAnalysisResults(Optional<List<SentimentAnalysisResult>> sentimentAnalysisResults);

        _FinalStage sentimentAnalysisResults(List<SentimentAnalysisResult> sentimentAnalysisResults);

        _FinalStage entityDetection(Optional<Boolean> entityDetection);

        _FinalStage entityDetection(Boolean entityDetection);

        _FinalStage entities(Optional<List<Entity>> entities);

        _FinalStage entities(List<Entity> entities);

        _FinalStage speechThreshold(Optional<Double> speechThreshold);

        _FinalStage speechThreshold(Double speechThreshold);

        _FinalStage throttled(Optional<Boolean> throttled);

        _FinalStage throttled(Boolean throttled);

        _FinalStage error(Optional<String> error);

        _FinalStage error(String error);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdStage, _FinalStage {
        private String id;

        private Optional<String> error = Optional.empty();

        private Optional<Boolean> throttled = Optional.empty();

        private Optional<Double> speechThreshold = Optional.empty();

        private Optional<List<Entity>> entities = Optional.empty();

        private Optional<Boolean> entityDetection = Optional.empty();

        private Optional<List<SentimentAnalysisResult>> sentimentAnalysisResults = Optional.empty();

        private Optional<Boolean> sentimentAnalysis = Optional.empty();

        private Optional<Boolean> disfluencies = Optional.empty();

        private Optional<List<String>> topics = Optional.empty();

        private Optional<Boolean> customTopics = Optional.empty();

        private Optional<String> summary = Optional.empty();

        private Optional<String> summaryModel = Optional.empty();

        private Optional<String> summaryType = Optional.empty();

        private Optional<Boolean> summarization = Optional.empty();

        private Optional<Boolean> autoChapters = Optional.empty();

        private Optional<List<TranscriptCustomSpelling>> customSpelling = Optional.empty();

        private Optional<Boolean> languageDetection = Optional.empty();

        private Optional<TranscriptIabCategoriesResult> iabCategoriesResult = Optional.empty();

        private Optional<Boolean> iabCategories = Optional.empty();

        private Optional<TranscriptContentSafetyLabels> contentSafetyLabels = Optional.empty();

        private Optional<Boolean> contentSafety = Optional.empty();

        private Optional<Integer> speakersExpected = Optional.empty();

        private Optional<Boolean> speakerLabels = Optional.empty();

        private Optional<SubstitutionPolicy> redactPiiSub = Optional.empty();

        private Optional<List<PiiPolicies>> redactPiiPolicies = Optional.empty();

        private Optional<String> redactPiiAudioQuality = Optional.empty();

        private Optional<Boolean> redactPiiAudio = Optional.empty();

        private Optional<Boolean> redactPii = Optional.empty();

        private Optional<Boolean> filterProfanity = Optional.empty();

        private Optional<String> boostParam = Optional.empty();

        private Optional<List<String>> wordBoost = Optional.empty();

        private Optional<Integer> audioEndAt = Optional.empty();

        private Optional<Integer> audioStartFrom = Optional.empty();

        private Optional<AutoHighlightsResult> autoHighlightsResult = Optional.empty();

        private Optional<Boolean> autoHighlights = Optional.empty();

        private Optional<Boolean> speedBoost = Optional.empty();

        private Optional<String> webhookAuthHeaderName = Optional.empty();

        private Optional<Boolean> webhookAuth = Optional.empty();

        private Optional<Integer> webhookStatusCode = Optional.empty();

        private Optional<String> webhookUrl = Optional.empty();

        private Optional<Boolean> dualChannel = Optional.empty();

        private Optional<Boolean> formatText = Optional.empty();

        private Optional<Boolean> punctuate = Optional.empty();

        private Optional<Double> audioDuration = Optional.empty();

        private Optional<Double> confidence = Optional.empty();

        private Optional<List<TranscriptUtterance>> utterances = Optional.empty();

        private Optional<List<TranscriptWord>> words = Optional.empty();

        private Optional<String> text = Optional.empty();

        private Optional<String> audioUrl = Optional.empty();

        private Optional<TranscriptLanguageCode> languageCode = Optional.empty();

        private Optional<TranscriptStatus> status = Optional.empty();

        private Optional<String> acousticModel = Optional.empty();

        private Optional<String> languageModel = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(Transcript other) {
            id(other.getId());
            languageModel(other.getLanguageModel());
            acousticModel(other.getAcousticModel());
            status(other.getStatus());
            languageCode(other.getLanguageCode());
            audioUrl(other.getAudioUrl());
            text(other.getText());
            words(other.getWords());
            utterances(other.getUtterances());
            confidence(other.getConfidence());
            audioDuration(other.getAudioDuration());
            punctuate(other.getPunctuate());
            formatText(other.getFormatText());
            dualChannel(other.getDualChannel());
            webhookUrl(other.getWebhookUrl());
            webhookStatusCode(other.getWebhookStatusCode());
            webhookAuth(other.getWebhookAuth());
            webhookAuthHeaderName(other.getWebhookAuthHeaderName());
            speedBoost(other.getSpeedBoost());
            autoHighlights(other.getAutoHighlights());
            autoHighlightsResult(other.getAutoHighlightsResult());
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
            contentSafetyLabels(other.getContentSafetyLabels());
            iabCategories(other.getIabCategories());
            iabCategoriesResult(other.getIabCategoriesResult());
            languageDetection(other.getLanguageDetection());
            customSpelling(other.getCustomSpelling());
            autoChapters(other.getAutoChapters());
            summarization(other.getSummarization());
            summaryType(other.getSummaryType());
            summaryModel(other.getSummaryModel());
            summary(other.getSummary());
            customTopics(other.getCustomTopics());
            topics(other.getTopics());
            disfluencies(other.getDisfluencies());
            sentimentAnalysis(other.getSentimentAnalysis());
            sentimentAnalysisResults(other.getSentimentAnalysisResults());
            entityDetection(other.getEntityDetection());
            entities(other.getEntities());
            speechThreshold(other.getSpeechThreshold());
            throttled(other.getThrottled());
            error(other.getError());
            return this;
        }

        /**
         * <p>The unique identifier of your transcription</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("id")
        public _FinalStage id(String id) {
            this.id = id;
            return this;
        }

        /**
         * <p>Error message of why the transcript failed</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage error(String error) {
            this.error = Optional.of(error);
            return this;
        }

        @Override
        @JsonSetter(value = "error", nulls = Nulls.SKIP)
        public _FinalStage error(Optional<String> error) {
            this.error = error;
            return this;
        }

        /**
         * <p>True while a request is throttled and false when a request is no longer throttled</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage throttled(Boolean throttled) {
            this.throttled = Optional.of(throttled);
            return this;
        }

        @Override
        @JsonSetter(value = "throttled", nulls = Nulls.SKIP)
        public _FinalStage throttled(Optional<Boolean> throttled) {
            this.throttled = throttled;
            return this;
        }

        /**
         * <p>Defaults to null. Reject audio files that contain less than this fraction of speech. Valid values are in the range [0, 1] inclusive.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage speechThreshold(Double speechThreshold) {
            this.speechThreshold = Optional.of(speechThreshold);
            return this;
        }

        @Override
        @JsonSetter(value = "speech_threshold", nulls = Nulls.SKIP)
        public _FinalStage speechThreshold(Optional<Double> speechThreshold) {
            this.speechThreshold = speechThreshold;
            return this;
        }

        /**
         * <p>An array of results for the Entity Detection model, if it was enabled during the transcription request. See <a href="https://www.assemblyai.com/docs/Models/entity_detection">Entity detection</a> for more information.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage entities(List<Entity> entities) {
            this.entities = Optional.of(entities);
            return this;
        }

        @Override
        @JsonSetter(value = "entities", nulls = Nulls.SKIP)
        public _FinalStage entities(Optional<List<Entity>> entities) {
            this.entities = entities;
            return this;
        }

        /**
         * <p>Enable <a href="https://www.assemblyai.com/docs/Models/entity_detection">Entity Detection</a>, can be true or false</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage entityDetection(Boolean entityDetection) {
            this.entityDetection = Optional.of(entityDetection);
            return this;
        }

        @Override
        @JsonSetter(value = "entity_detection", nulls = Nulls.SKIP)
        public _FinalStage entityDetection(Optional<Boolean> entityDetection) {
            this.entityDetection = entityDetection;
            return this;
        }

        /**
         * <p>An array of results for the Sentiment Analysis model, if it was enabled during the transcription request. See <a href="https://www.assemblyai.com/docs/Models/sentiment_analysis">Sentiment analysis</a> for more information.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage sentimentAnalysisResults(List<SentimentAnalysisResult> sentimentAnalysisResults) {
            this.sentimentAnalysisResults = Optional.of(sentimentAnalysisResults);
            return this;
        }

        @Override
        @JsonSetter(value = "sentiment_analysis_results", nulls = Nulls.SKIP)
        public _FinalStage sentimentAnalysisResults(Optional<List<SentimentAnalysisResult>> sentimentAnalysisResults) {
            this.sentimentAnalysisResults = sentimentAnalysisResults;
            return this;
        }

        /**
         * <p>Enable <a href="https://www.assemblyai.com/docs/Models/sentiment_analysis">Sentiment Analysis</a>, can be true or false</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage sentimentAnalysis(Boolean sentimentAnalysis) {
            this.sentimentAnalysis = Optional.of(sentimentAnalysis);
            return this;
        }

        @Override
        @JsonSetter(value = "sentiment_analysis", nulls = Nulls.SKIP)
        public _FinalStage sentimentAnalysis(Optional<Boolean> sentimentAnalysis) {
            this.sentimentAnalysis = sentimentAnalysis;
            return this;
        }

        /**
         * <p>Transcribe Filler Words, like &quot;umm&quot;, in your media file; can be true or false</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage disfluencies(Boolean disfluencies) {
            this.disfluencies = Optional.of(disfluencies);
            return this;
        }

        @Override
        @JsonSetter(value = "disfluencies", nulls = Nulls.SKIP)
        public _FinalStage disfluencies(Optional<Boolean> disfluencies) {
            this.disfluencies = disfluencies;
            return this;
        }

        /**
         * <p>The list of custom topics provided if custom topics was enabled in the transcription request</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage topics(List<String> topics) {
            this.topics = Optional.of(topics);
            return this;
        }

        @Override
        @JsonSetter(value = "topics", nulls = Nulls.SKIP)
        public _FinalStage topics(Optional<List<String>> topics) {
            this.topics = topics;
            return this;
        }

        /**
         * <p>Whether custom topics was enabled in the transcription request, either true or false</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage customTopics(Boolean customTopics) {
            this.customTopics = Optional.of(customTopics);
            return this;
        }

        @Override
        @JsonSetter(value = "custom_topics", nulls = Nulls.SKIP)
        public _FinalStage customTopics(Optional<Boolean> customTopics) {
            this.customTopics = customTopics;
            return this;
        }

        /**
         * <p>The generated summary of the media file, if <a href="https://www.assemblyai.com/docs/Models/summarization">Summarization</a> was enabled in the transcription request</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage summary(String summary) {
            this.summary = Optional.of(summary);
            return this;
        }

        @Override
        @JsonSetter(value = "summary", nulls = Nulls.SKIP)
        public _FinalStage summary(Optional<String> summary) {
            this.summary = summary;
            return this;
        }

        /**
         * <p>The Summarization model used to generate the summary, if <a href="https://www.assemblyai.com/docs/Models/summarization">Summarization</a> was enabled in the transcription request</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage summaryModel(String summaryModel) {
            this.summaryModel = Optional.of(summaryModel);
            return this;
        }

        @Override
        @JsonSetter(value = "summary_model", nulls = Nulls.SKIP)
        public _FinalStage summaryModel(Optional<String> summaryModel) {
            this.summaryModel = summaryModel;
            return this;
        }

        /**
         * <p>The type of summary generated, if <a href="https://www.assemblyai.com/docs/Models/summarization">Summarization</a> was enabled in the transcription request</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage summaryType(String summaryType) {
            this.summaryType = Optional.of(summaryType);
            return this;
        }

        @Override
        @JsonSetter(value = "summary_type", nulls = Nulls.SKIP)
        public _FinalStage summaryType(Optional<String> summaryType) {
            this.summaryType = summaryType;
            return this;
        }

        /**
         * <p>Whether <a href="https://www.assemblyai.com/docs/Models/summarization">Summarization</a> was enabled in the transcription request, either true or false</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage summarization(Boolean summarization) {
            this.summarization = Optional.of(summarization);
            return this;
        }

        @Override
        @JsonSetter(value = "summarization", nulls = Nulls.SKIP)
        public _FinalStage summarization(Optional<Boolean> summarization) {
            this.summarization = summarization;
            return this;
        }

        /**
         * <p>Enable <a href="https://www.assemblyai.com/docs/Models/auto_chapters">Auto Chapters</a>, can be true or false</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage autoChapters(Boolean autoChapters) {
            this.autoChapters = Optional.of(autoChapters);
            return this;
        }

        @Override
        @JsonSetter(value = "auto_chapters", nulls = Nulls.SKIP)
        public _FinalStage autoChapters(Optional<Boolean> autoChapters) {
            this.autoChapters = autoChapters;
            return this;
        }

        /**
         * <p>Customize how words are spelled and formatted using to and from values</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage customSpelling(List<TranscriptCustomSpelling> customSpelling) {
            this.customSpelling = Optional.of(customSpelling);
            return this;
        }

        @Override
        @JsonSetter(value = "custom_spelling", nulls = Nulls.SKIP)
        public _FinalStage customSpelling(Optional<List<TranscriptCustomSpelling>> customSpelling) {
            this.customSpelling = customSpelling;
            return this;
        }

        /**
         * <p>Whether <a href="https://www.assemblyai.com/docs/Models/speech_recognition#automatic-language-detection">Automatic language detection</a> was enabled in the transcription request, either true or false</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
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

        /**
         * <p>An array of results for the Topic Detection model, if it was enabled during the transcription request. See <a href="https://www.assemblyai.com/docs/Models/iab_classification">Topic Detection</a> for more information.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage iabCategoriesResult(TranscriptIabCategoriesResult iabCategoriesResult) {
            this.iabCategoriesResult = Optional.of(iabCategoriesResult);
            return this;
        }

        @Override
        @JsonSetter(value = "iab_categories_result", nulls = Nulls.SKIP)
        public _FinalStage iabCategoriesResult(Optional<TranscriptIabCategoriesResult> iabCategoriesResult) {
            this.iabCategoriesResult = iabCategoriesResult;
            return this;
        }

        /**
         * <p>Enable <a href="https://www.assemblyai.com/docs/Models/iab_classification">Topic Detection</a>, can be true or false</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage iabCategories(Boolean iabCategories) {
            this.iabCategories = Optional.of(iabCategories);
            return this;
        }

        @Override
        @JsonSetter(value = "iab_categories", nulls = Nulls.SKIP)
        public _FinalStage iabCategories(Optional<Boolean> iabCategories) {
            this.iabCategories = iabCategories;
            return this;
        }

        /**
         * <p>An array of results for the Content Moderation model, if it was enabled during the transcription request. See <a href="https://www.assemblyai.com/docs/Models/content_moderation">Content moderation</a> for more information.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage contentSafetyLabels(TranscriptContentSafetyLabels contentSafetyLabels) {
            this.contentSafetyLabels = Optional.of(contentSafetyLabels);
            return this;
        }

        @Override
        @JsonSetter(value = "content_safety_labels", nulls = Nulls.SKIP)
        public _FinalStage contentSafetyLabels(Optional<TranscriptContentSafetyLabels> contentSafetyLabels) {
            this.contentSafetyLabels = contentSafetyLabels;
            return this;
        }

        /**
         * <p>Enable <a href="https://www.assemblyai.com/docs/Models/content_moderation">Content Moderation</a>, can be true or false</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage contentSafety(Boolean contentSafety) {
            this.contentSafety = Optional.of(contentSafety);
            return this;
        }

        @Override
        @JsonSetter(value = "content_safety", nulls = Nulls.SKIP)
        public _FinalStage contentSafety(Optional<Boolean> contentSafety) {
            this.contentSafety = contentSafety;
            return this;
        }

        /**
         * <p>Defaults to null. Tells the speaker label model how many speakers it should attempt to identify, up to 10. See <a href="https://www.assemblyai.com/docs/Models/speaker_diarization">Speaker diarization</a> for more details.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage speakersExpected(Integer speakersExpected) {
            this.speakersExpected = Optional.of(speakersExpected);
            return this;
        }

        @Override
        @JsonSetter(value = "speakers_expected", nulls = Nulls.SKIP)
        public _FinalStage speakersExpected(Optional<Integer> speakersExpected) {
            this.speakersExpected = speakersExpected;
            return this;
        }

        /**
         * <p>Enable <a href="https://www.assemblyai.com/docs/Models/speaker_diarization">Speaker diarization</a>, can be true or false</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage speakerLabels(Boolean speakerLabels) {
            this.speakerLabels = Optional.of(speakerLabels);
            return this;
        }

        @Override
        @JsonSetter(value = "speaker_labels", nulls = Nulls.SKIP)
        public _FinalStage speakerLabels(Optional<Boolean> speakerLabels) {
            this.speakerLabels = speakerLabels;
            return this;
        }

        /**
         * <p>The replacement logic for detected PII, can be &quot;entity_type&quot; or &quot;hash&quot;. See <a href="https://www.assemblyai.com/docs/Models/pii_redaction">PII redaction</a> for more details.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage redactPiiSub(SubstitutionPolicy redactPiiSub) {
            this.redactPiiSub = Optional.of(redactPiiSub);
            return this;
        }

        @Override
        @JsonSetter(value = "redact_pii_sub", nulls = Nulls.SKIP)
        public _FinalStage redactPiiSub(Optional<SubstitutionPolicy> redactPiiSub) {
            this.redactPiiSub = redactPiiSub;
            return this;
        }

        /**
         * <p>The list of PII Redaction policies that were enabled, if PII Redaction is enabled. See <a href="https://www.assemblyai.com/docs/Models/pii_redaction">PII redaction</a> for more information.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage redactPiiPolicies(List<PiiPolicies> redactPiiPolicies) {
            this.redactPiiPolicies = Optional.of(redactPiiPolicies);
            return this;
        }

        @Override
        @JsonSetter(value = "redact_pii_policies", nulls = Nulls.SKIP)
        public _FinalStage redactPiiPolicies(Optional<List<PiiPolicies>> redactPiiPolicies) {
            this.redactPiiPolicies = redactPiiPolicies;
            return this;
        }

        /**
         * <p>The audio quality of the PII-redacted audio file, if enabled in the transcription request. See <a href="https://www.assemblyai.com/docs/Models/pii_redaction">PII redaction</a> for more information.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage redactPiiAudioQuality(String redactPiiAudioQuality) {
            this.redactPiiAudioQuality = Optional.of(redactPiiAudioQuality);
            return this;
        }

        @Override
        @JsonSetter(value = "redact_pii_audio_quality", nulls = Nulls.SKIP)
        public _FinalStage redactPiiAudioQuality(Optional<String> redactPiiAudioQuality) {
            this.redactPiiAudioQuality = redactPiiAudioQuality;
            return this;
        }

        /**
         * <p>Whether a redacted version of the audio file was generated (enabled or disabled in the transcription request), either true or false. See <a href="https://www.assemblyai.com/docs/Models/pii_redaction">PII redaction</a> for more information.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage redactPiiAudio(Boolean redactPiiAudio) {
            this.redactPiiAudio = Optional.of(redactPiiAudio);
            return this;
        }

        @Override
        @JsonSetter(value = "redact_pii_audio", nulls = Nulls.SKIP)
        public _FinalStage redactPiiAudio(Optional<Boolean> redactPiiAudio) {
            this.redactPiiAudio = redactPiiAudio;
            return this;
        }

        /**
         * <p>Whether <a href="https://www.assemblyai.com/docs/Models/pii_redaction">PII Redaction</a> was enabled in the transcription request, either true or false</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage redactPii(Boolean redactPii) {
            this.redactPii = Optional.of(redactPii);
            return this;
        }

        @Override
        @JsonSetter(value = "redact_pii", nulls = Nulls.SKIP)
        public _FinalStage redactPii(Optional<Boolean> redactPii) {
            this.redactPii = redactPii;
            return this;
        }

        /**
         * <p>Whether <a href="https://www.assemblyai.com/docs/Models/speech_recognition#profanity-filtering">Profanity Filtering</a> was enabled in the transcription request, either true or false</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage filterProfanity(Boolean filterProfanity) {
            this.filterProfanity = Optional.of(filterProfanity);
            return this;
        }

        @Override
        @JsonSetter(value = "filter_profanity", nulls = Nulls.SKIP)
        public _FinalStage filterProfanity(Optional<Boolean> filterProfanity) {
            this.filterProfanity = filterProfanity;
            return this;
        }

        /**
         * <p>The word boost parameter value, if provided in the transcription request</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage boostParam(String boostParam) {
            this.boostParam = Optional.of(boostParam);
            return this;
        }

        @Override
        @JsonSetter(value = "boost_param", nulls = Nulls.SKIP)
        public _FinalStage boostParam(Optional<String> boostParam) {
            this.boostParam = boostParam;
            return this;
        }

        /**
         * <p>The list of custom vocabulary to boost transcription probability for, if provided in the transcription request</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage wordBoost(List<String> wordBoost) {
            this.wordBoost = Optional.of(wordBoost);
            return this;
        }

        @Override
        @JsonSetter(value = "word_boost", nulls = Nulls.SKIP)
        public _FinalStage wordBoost(Optional<List<String>> wordBoost) {
            this.wordBoost = wordBoost;
            return this;
        }

        /**
         * <p>The point in time, in milliseconds, in the file at which the transcription was terminated, if provided in the transcription request</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage audioEndAt(Integer audioEndAt) {
            this.audioEndAt = Optional.of(audioEndAt);
            return this;
        }

        @Override
        @JsonSetter(value = "audio_end_at", nulls = Nulls.SKIP)
        public _FinalStage audioEndAt(Optional<Integer> audioEndAt) {
            this.audioEndAt = audioEndAt;
            return this;
        }

        /**
         * <p>The point in time, in milliseconds, in the file at which the transcription was started, if provided in the transcription request</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage audioStartFrom(Integer audioStartFrom) {
            this.audioStartFrom = Optional.of(audioStartFrom);
            return this;
        }

        @Override
        @JsonSetter(value = "audio_start_from", nulls = Nulls.SKIP)
        public _FinalStage audioStartFrom(Optional<Integer> audioStartFrom) {
            this.audioStartFrom = audioStartFrom;
            return this;
        }

        /**
         * <p>An array of results for the Key Phrases model, if it was enabled during the transcription request. See <a href="https://www.assemblyai.com/docs/Models/key_phrases">Key phrases</a> for more information.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage autoHighlightsResult(AutoHighlightsResult autoHighlightsResult) {
            this.autoHighlightsResult = Optional.of(autoHighlightsResult);
            return this;
        }

        @Override
        @JsonSetter(value = "auto_highlights_result", nulls = Nulls.SKIP)
        public _FinalStage autoHighlightsResult(Optional<AutoHighlightsResult> autoHighlightsResult) {
            this.autoHighlightsResult = autoHighlightsResult;
            return this;
        }

        /**
         * <p>Whether Key Phrases was enabled in the transcription request, either true or false</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage autoHighlights(Boolean autoHighlights) {
            this.autoHighlights = Optional.of(autoHighlights);
            return this;
        }

        @Override
        @JsonSetter(value = "auto_highlights", nulls = Nulls.SKIP)
        public _FinalStage autoHighlights(Optional<Boolean> autoHighlights) {
            this.autoHighlights = autoHighlights;
            return this;
        }

        /**
         * <p>Whether speed boost was enabled in the transcription request</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage speedBoost(Boolean speedBoost) {
            this.speedBoost = Optional.of(speedBoost);
            return this;
        }

        @Override
        @JsonSetter(value = "speed_boost", nulls = Nulls.SKIP)
        public _FinalStage speedBoost(Optional<Boolean> speedBoost) {
            this.speedBoost = speedBoost;
            return this;
        }

        /**
         * <p>The header name which should be sent back with webhook calls, if provided in the transcription request</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage webhookAuthHeaderName(String webhookAuthHeaderName) {
            this.webhookAuthHeaderName = Optional.of(webhookAuthHeaderName);
            return this;
        }

        @Override
        @JsonSetter(value = "webhook_auth_header_name", nulls = Nulls.SKIP)
        public _FinalStage webhookAuthHeaderName(Optional<String> webhookAuthHeaderName) {
            this.webhookAuthHeaderName = webhookAuthHeaderName;
            return this;
        }

        /**
         * <p>Whether webhook authentication details were provided in the transcription request</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage webhookAuth(Boolean webhookAuth) {
            this.webhookAuth = Optional.of(webhookAuth);
            return this;
        }

        @Override
        @JsonSetter(value = "webhook_auth", nulls = Nulls.SKIP)
        public _FinalStage webhookAuth(Optional<Boolean> webhookAuth) {
            this.webhookAuth = webhookAuth;
            return this;
        }

        /**
         * <p>The status code we received from your server when delivering your webhook, if a webhook URL was provided in the transcription request</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage webhookStatusCode(Integer webhookStatusCode) {
            this.webhookStatusCode = Optional.of(webhookStatusCode);
            return this;
        }

        @Override
        @JsonSetter(value = "webhook_status_code", nulls = Nulls.SKIP)
        public _FinalStage webhookStatusCode(Optional<Integer> webhookStatusCode) {
            this.webhookStatusCode = webhookStatusCode;
            return this;
        }

        /**
         * <p>The URL to which we send webhooks upon trancription completion, if provided in the transcription request</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
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

        /**
         * <p>Whether <a href="https://www.assemblyai.com/docs/Models/speech_recognition#dual-channel-transcription">Dual channel transcription</a> was enabled in the transcription request, either true or false</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
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

        /**
         * <p>Whether Text Formatting was enabled in the transcription request, either true or false</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
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

        /**
         * <p>Whether Automatic Punctuation was enabled in the transcription request, either true or false.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
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

        /**
         * <p>The duration of this transcript object's media file, in seconds</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
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

        /**
         * <p>The confidence score for the transcript, between 0.0 (low confidence) and 1.0 (high confidence)</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
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

        /**
         * <p>When dual_channel or speaker_labels is enabled, a list of turn-by-turn utterance objects. See <a href="https://www.assemblyai.com/docs/Models/speaker_diarization">Speaker diarization</a> for more information.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
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

        /**
         * <p>An array of temporally-sequential word objects, one for each word in the transcript. See <a href="https://www.assemblyai.com/docs/Models/speech_recognition">Speech recognition</a> for more information.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
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

        /**
         * <p>The textual transcript of your media file</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
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

        /**
         * <p>The URL of the media that was transcribed</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
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

        /**
         * <p>The language of your audio file. Possible values are found in <a href="https://www.assemblyai.com/docs/Concepts/supported_languages">Supported Languages</a>. The default value is 'en_us'.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage languageCode(TranscriptLanguageCode languageCode) {
            this.languageCode = Optional.of(languageCode);
            return this;
        }

        @Override
        @JsonSetter(value = "language_code", nulls = Nulls.SKIP)
        public _FinalStage languageCode(Optional<TranscriptLanguageCode> languageCode) {
            this.languageCode = languageCode;
            return this;
        }

        /**
         * <p>The status of your transcription. Possible values are queued, processing, completed, or error.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
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

        /**
         * <p>The acoustic model that was used for the transcription</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
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

        /**
         * <p>The language model that was used for the transcription</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
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
        public Transcript build() {
            return new Transcript(
                    id,
                    languageModel,
                    acousticModel,
                    status,
                    languageCode,
                    audioUrl,
                    text,
                    words,
                    utterances,
                    confidence,
                    audioDuration,
                    punctuate,
                    formatText,
                    dualChannel,
                    webhookUrl,
                    webhookStatusCode,
                    webhookAuth,
                    webhookAuthHeaderName,
                    speedBoost,
                    autoHighlights,
                    autoHighlightsResult,
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
                    contentSafetyLabels,
                    iabCategories,
                    iabCategoriesResult,
                    languageDetection,
                    customSpelling,
                    autoChapters,
                    summarization,
                    summaryType,
                    summaryModel,
                    summary,
                    customTopics,
                    topics,
                    disfluencies,
                    sentimentAnalysis,
                    sentimentAnalysisResults,
                    entityDetection,
                    entities,
                    speechThreshold,
                    throttled,
                    error);
        }
    }
}
