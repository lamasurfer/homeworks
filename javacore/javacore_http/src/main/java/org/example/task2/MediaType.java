package org.example.task2;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MediaType {
    IMAGE ("image"),
    VIDEO ("video");


    private final String name;

    MediaType(String name) {
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
