package com.infoshareacademy.drinkers.domain.drink;

public enum Status {
    ACCEPTED("Accepted"),
    ADDED("Added"),
    BLOCKED("Blocked"),
    DELETED("Deleted"),
    MODIFIED("Modified");

    private final String name;

    Status(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
