package com.hand.domain.entity;

public enum SpecialFeature {
    TRAILERS("Trailers"),
    COMMENTARIES("Commentaries"),
    DELETED_SCENES("Deleted Scenes"),
    BEHIND_THE_SCENES("Behind the Scenes");

    private String stringValue;

    SpecialFeature(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    @Override
    public String toString() {
        return getStringValue();
    }

    public static SpecialFeature ofString(String specialFeature) {
        for (int i = 0; i < SpecialFeature.values().length; i++) {
            if (SpecialFeature.values()[i].getStringValue().equalsIgnoreCase(specialFeature)) {
                return SpecialFeature.values()[i];
            }
        }
        return null;
    }
}
