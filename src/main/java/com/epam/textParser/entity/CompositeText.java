package com.epam.textParser.entity;

import java.util.List;

public class CompositeText implements Text {
    private List<Text> childTexts;

    @Override
    public void printText() {
        for (Text childText : childTexts) {
            childText.printText();
        }
    }

    @Override
    public String getValue() {
        for (Text childText : childTexts) {
            childText.getValue();
        }
        return childTexts.toString();
    }

    public void addText(Text text) {
        childTexts.add(text);
    }

    public void removeText(Text text) {
        childTexts.remove(text);
    }
}
