package com.assemblyai.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PiiPolicies {
    MEDICAL_PROCESS("medical_process"),

    MEDICAL_CONDITION("medical_condition"),

    BLOOD_TYPE("blood_type"),

    DRUG("drug"),

    INJURY("injury"),

    NUMBER_SEQUENCE("number_sequence"),

    EMAIL_ADDRESS("email_address"),

    DATE_OF_BIRTH("date_of_birth"),

    PHONE_NUMBER("phone_number"),

    US_SOCIAL_SECURITY_NUMBER("us_social_security_number"),

    CREDIT_CARD_NUMBER("credit_card_number"),

    CREDIT_CARD_EXPIRATION("credit_card_expiration"),

    CREDIT_CARD_CVV("credit_card_cvv"),

    DATE("date"),

    NATIONALITY("nationality"),

    EVENT("event"),

    LANGUAGE("language"),

    LOCATION("location"),

    MONEY_AMOUNT("money_amount"),

    PERSON_NAME("person_name"),

    PERSON_AGE("person_age"),

    ORGANIZATION("organization"),

    POLITICAL_AFFILIATION("political_affiliation"),

    OCCUPATION("occupation"),

    RELIGION("religion"),

    DRIVERS_LICENSE("drivers_license"),

    BANKING_INFORMATION("banking_information");

    private final String value;

    PiiPolicies(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
