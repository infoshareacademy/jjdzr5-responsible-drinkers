package com.infoshareacademy.drinkers.service.filtering;

public enum FilterElements {
    APPLE_JUICE("Apple juice"),
    COFFEE("Coffee"),
    COGNAC("Cognac"),
    CRANBERRY_JUICE("Cranberry juice"),
    GIN("Gin"),
    GRAPEFRUIT_JUICE("Grapefruit juice"),
    GRENADINE("Grenadine"),
    JUICE("Juice"),
    LIME_JUICE("Lime juice"),
    MILK("Milk"),
    ORANGE_JUICE("Orange juice"),
    PINEAPPLE_JUICE("Pineapple juice"),
    RUM("Rum"),
    SODA_WATER("Soda water"),
    SUGAR("Sugar"),
    TONIC_WATER("Tonic water"),
    VODKA("Vodka"),
    WATER("Water");

    private final String name;

    FilterElements(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
