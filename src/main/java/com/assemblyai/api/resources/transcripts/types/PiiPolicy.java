/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api.resources.transcripts.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class PiiPolicy {
    public static final PiiPolicy MEDICAL_CONDITION = new PiiPolicy(Value.MEDICAL_CONDITION, "medical_condition");

    public static final PiiPolicy BLOOD_TYPE = new PiiPolicy(Value.BLOOD_TYPE, "blood_type");

    public static final PiiPolicy CREDIT_CARD_NUMBER = new PiiPolicy(Value.CREDIT_CARD_NUMBER, "credit_card_number");

    public static final PiiPolicy RELIGION = new PiiPolicy(Value.RELIGION, "religion");

    public static final PiiPolicy US_SOCIAL_SECURITY_NUMBER =
            new PiiPolicy(Value.US_SOCIAL_SECURITY_NUMBER, "us_social_security_number");

    public static final PiiPolicy LOCATION = new PiiPolicy(Value.LOCATION, "location");

    public static final PiiPolicy EVENT = new PiiPolicy(Value.EVENT, "event");

    public static final PiiPolicy PERSON_NAME = new PiiPolicy(Value.PERSON_NAME, "person_name");

    public static final PiiPolicy ORGANIZATION = new PiiPolicy(Value.ORGANIZATION, "organization");

    public static final PiiPolicy DRIVERS_LICENSE = new PiiPolicy(Value.DRIVERS_LICENSE, "drivers_license");

    public static final PiiPolicy LANGUAGE = new PiiPolicy(Value.LANGUAGE, "language");

    public static final PiiPolicy CREDIT_CARD_EXPIRATION =
            new PiiPolicy(Value.CREDIT_CARD_EXPIRATION, "credit_card_expiration");

    public static final PiiPolicy MONEY_AMOUNT = new PiiPolicy(Value.MONEY_AMOUNT, "money_amount");

    public static final PiiPolicy PHONE_NUMBER = new PiiPolicy(Value.PHONE_NUMBER, "phone_number");

    public static final PiiPolicy DRUG = new PiiPolicy(Value.DRUG, "drug");

    public static final PiiPolicy INJURY = new PiiPolicy(Value.INJURY, "injury");

    public static final PiiPolicy NUMBER_SEQUENCE = new PiiPolicy(Value.NUMBER_SEQUENCE, "number_sequence");

    public static final PiiPolicy POLITICAL_AFFILIATION =
            new PiiPolicy(Value.POLITICAL_AFFILIATION, "political_affiliation");

    public static final PiiPolicy DATE_OF_BIRTH = new PiiPolicy(Value.DATE_OF_BIRTH, "date_of_birth");

    public static final PiiPolicy EMAIL_ADDRESS = new PiiPolicy(Value.EMAIL_ADDRESS, "email_address");

    public static final PiiPolicy NATIONALITY = new PiiPolicy(Value.NATIONALITY, "nationality");

    public static final PiiPolicy MEDICAL_PROCESS = new PiiPolicy(Value.MEDICAL_PROCESS, "medical_process");

    public static final PiiPolicy DATE = new PiiPolicy(Value.DATE, "date");

    public static final PiiPolicy PERSON_AGE = new PiiPolicy(Value.PERSON_AGE, "person_age");

    public static final PiiPolicy BANKING_INFORMATION = new PiiPolicy(Value.BANKING_INFORMATION, "banking_information");

    public static final PiiPolicy CREDIT_CARD_CVV = new PiiPolicy(Value.CREDIT_CARD_CVV, "credit_card_cvv");

    public static final PiiPolicy OCCUPATION = new PiiPolicy(Value.OCCUPATION, "occupation");

    private final Value value;

    private final String string;

    PiiPolicy(Value value, String string) {
        this.value = value;
        this.string = string;
    }

    public Value getEnumValue() {
        return value;
    }

    @Override
    @JsonValue
    public String toString() {
        return this.string;
    }

    @Override
    public boolean equals(Object other) {
        return (this == other) || (other instanceof PiiPolicy && this.string.equals(((PiiPolicy) other).string));
    }

    @Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case MEDICAL_CONDITION:
                return visitor.visitMedicalCondition();
            case BLOOD_TYPE:
                return visitor.visitBloodType();
            case CREDIT_CARD_NUMBER:
                return visitor.visitCreditCardNumber();
            case RELIGION:
                return visitor.visitReligion();
            case US_SOCIAL_SECURITY_NUMBER:
                return visitor.visitUsSocialSecurityNumber();
            case LOCATION:
                return visitor.visitLocation();
            case EVENT:
                return visitor.visitEvent();
            case PERSON_NAME:
                return visitor.visitPersonName();
            case ORGANIZATION:
                return visitor.visitOrganization();
            case DRIVERS_LICENSE:
                return visitor.visitDriversLicense();
            case LANGUAGE:
                return visitor.visitLanguage();
            case CREDIT_CARD_EXPIRATION:
                return visitor.visitCreditCardExpiration();
            case MONEY_AMOUNT:
                return visitor.visitMoneyAmount();
            case PHONE_NUMBER:
                return visitor.visitPhoneNumber();
            case DRUG:
                return visitor.visitDrug();
            case INJURY:
                return visitor.visitInjury();
            case NUMBER_SEQUENCE:
                return visitor.visitNumberSequence();
            case POLITICAL_AFFILIATION:
                return visitor.visitPoliticalAffiliation();
            case DATE_OF_BIRTH:
                return visitor.visitDateOfBirth();
            case EMAIL_ADDRESS:
                return visitor.visitEmailAddress();
            case NATIONALITY:
                return visitor.visitNationality();
            case MEDICAL_PROCESS:
                return visitor.visitMedicalProcess();
            case DATE:
                return visitor.visitDate();
            case PERSON_AGE:
                return visitor.visitPersonAge();
            case BANKING_INFORMATION:
                return visitor.visitBankingInformation();
            case CREDIT_CARD_CVV:
                return visitor.visitCreditCardCvv();
            case OCCUPATION:
                return visitor.visitOccupation();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static PiiPolicy valueOf(String value) {
        switch (value) {
            case "medical_condition":
                return MEDICAL_CONDITION;
            case "blood_type":
                return BLOOD_TYPE;
            case "credit_card_number":
                return CREDIT_CARD_NUMBER;
            case "religion":
                return RELIGION;
            case "us_social_security_number":
                return US_SOCIAL_SECURITY_NUMBER;
            case "location":
                return LOCATION;
            case "event":
                return EVENT;
            case "person_name":
                return PERSON_NAME;
            case "organization":
                return ORGANIZATION;
            case "drivers_license":
                return DRIVERS_LICENSE;
            case "language":
                return LANGUAGE;
            case "credit_card_expiration":
                return CREDIT_CARD_EXPIRATION;
            case "money_amount":
                return MONEY_AMOUNT;
            case "phone_number":
                return PHONE_NUMBER;
            case "drug":
                return DRUG;
            case "injury":
                return INJURY;
            case "number_sequence":
                return NUMBER_SEQUENCE;
            case "political_affiliation":
                return POLITICAL_AFFILIATION;
            case "date_of_birth":
                return DATE_OF_BIRTH;
            case "email_address":
                return EMAIL_ADDRESS;
            case "nationality":
                return NATIONALITY;
            case "medical_process":
                return MEDICAL_PROCESS;
            case "date":
                return DATE;
            case "person_age":
                return PERSON_AGE;
            case "banking_information":
                return BANKING_INFORMATION;
            case "credit_card_cvv":
                return CREDIT_CARD_CVV;
            case "occupation":
                return OCCUPATION;
            default:
                return new PiiPolicy(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        MEDICAL_PROCESS,

        MEDICAL_CONDITION,

        BLOOD_TYPE,

        DRUG,

        INJURY,

        NUMBER_SEQUENCE,

        EMAIL_ADDRESS,

        DATE_OF_BIRTH,

        PHONE_NUMBER,

        US_SOCIAL_SECURITY_NUMBER,

        CREDIT_CARD_NUMBER,

        CREDIT_CARD_EXPIRATION,

        CREDIT_CARD_CVV,

        DATE,

        NATIONALITY,

        EVENT,

        LANGUAGE,

        LOCATION,

        MONEY_AMOUNT,

        PERSON_NAME,

        PERSON_AGE,

        ORGANIZATION,

        POLITICAL_AFFILIATION,

        OCCUPATION,

        RELIGION,

        DRIVERS_LICENSE,

        BANKING_INFORMATION,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitMedicalProcess();

        T visitMedicalCondition();

        T visitBloodType();

        T visitDrug();

        T visitInjury();

        T visitNumberSequence();

        T visitEmailAddress();

        T visitDateOfBirth();

        T visitPhoneNumber();

        T visitUsSocialSecurityNumber();

        T visitCreditCardNumber();

        T visitCreditCardExpiration();

        T visitCreditCardCvv();

        T visitDate();

        T visitNationality();

        T visitEvent();

        T visitLanguage();

        T visitLocation();

        T visitMoneyAmount();

        T visitPersonName();

        T visitPersonAge();

        T visitOrganization();

        T visitPoliticalAffiliation();

        T visitOccupation();

        T visitReligion();

        T visitDriversLicense();

        T visitBankingInformation();

        T visitUnknown(String unknownType);
    }
}