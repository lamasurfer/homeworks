package org.example.task1;

import com.fasterxml.jackson.annotation.JsonValue;

public enum FactType {
    CAT("cat");

    private final String name;

    FactType(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
