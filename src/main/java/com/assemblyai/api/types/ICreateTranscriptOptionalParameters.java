/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api.types;

import java.util.List;
import java.util.Optional;

public interface ICreateTranscriptOptionalParameters {
    Optional<TranscriptLanguageCode> getLanguageCode();

    Optional<Boolean> getPunctuate();

    Optional<Boolean> getFormatText();

    Optional<Boolean> getDualChannel();

    Optional<String> getWebhookUrl();

    Optional<String> getWebhookAuthHeaderName();

    Optional<String> getWebhookAuthHeaderValue();

    Optional<Boolean> getAutoHighlights();

    Optional<Integer> getAudioStartFrom();

    Optional<Integer> getAudioEndAt();

    Optional<List<String>> getWordBoost();

    Optional<TranscriptBoostParam> getBoostParam();

    Optional<Boolean> getFilterProfanity();

    Optional<Boolean> getRedactPii();

    Optional<Boolean> getRedactPiiAudio();

    Optional<String> getRedactPiiAudioQuality();

    Optional<List<PiiPolicy>> getRedactPiiPolicies();

    Optional<SubstitutionPolicy> getRedactPiiSub();

    Optional<Boolean> getSpeakerLabels();

    Optional<Integer> getSpeakersExpected();

    Optional<Boolean> getContentSafety();

    Optional<Boolean> getIabCategories();

    Optional<Boolean> getLanguageDetection();

    Optional<List<TranscriptCustomSpelling>> getCustomSpelling();

    Optional<Boolean> getDisfluencies();

    Optional<Boolean> getSentimentAnalysis();

    Optional<Boolean> getAutoChapters();

    Optional<Boolean> getEntityDetection();

    Optional<Double> getSpeechThreshold();

    Optional<Boolean> getSummarization();

    Optional<SummaryModel> getSummaryModel();

    Optional<SummaryType> getSummaryType();

    Optional<Boolean> getCustomTopics();

    Optional<List<String>> getTopics();
}
