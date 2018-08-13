package com.hand.domain.entity;

public enum RatingEnum {
    G("G"),
    PG("PG"),
    PG_13("PG_13"),
    R("R"),
    NC_17("NC_17");

    private String stringValue;

    RatingEnum(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    @Override
    public String toString() {
        return getStringValue();
    }

    public static RatingEnum ofString(String rating) {
        for (int i = 0; i < RatingEnum.values().length; i++) {
            if (RatingEnum.values()[i].getStringValue().equalsIgnoreCase(rating)) {
                return RatingEnum.values()[i];
            }
        }
        return null;
    }
}
