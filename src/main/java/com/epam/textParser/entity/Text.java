package com.epam.textParser.entity;

public interface Text {
    void printText();

    String text = "";

    default String getValue() {
        return text;
    }
}
