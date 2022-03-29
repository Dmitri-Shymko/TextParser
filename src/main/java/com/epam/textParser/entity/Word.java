package com.epam.textParser.entity;

public class Word implements Text{
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public void printText() {
        System.out.println(word + " ");
    }

    @Override
    public String getValue(){
        return getWord() + " ";
    }
}
