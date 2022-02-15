package com.infoshareacademy;

public enum FilterElements {
    ALCOHOL("Alcoholic"),
    APPLE_JUICE("Apple juice"),
    COFFEE("Coffee"),
    COGNAC("Cognac"),
    CRANBERRY_JIUCE("Cranberry juice"),
    GIN("Gin"),
    GRAPEFRUIT_JIUCE("Grapefruit juice"),
    GRENADINE("Grenadine"),
    JIUCE("Juice"),
    LIME_JUICE("Lime juice"),
    PINEAPPLE_JUICE("Pineapple juice"),
    MILK("Milk"),
    NON_ALCOHOL("Non alcoholic"),
    ORANGE_JIUCE("Orange juice"),
    SODA_WATER("Soda water"),
    SUGAR("Sugar"),
    TONIC_WATER("Tonic water"),
    VODKA("Vodka");


    private String name;

    FilterElements(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
