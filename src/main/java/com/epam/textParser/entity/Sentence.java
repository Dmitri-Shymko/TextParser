package com.epam.textParser.entity;

public class Sentence implements Text{
    private String sentence;

    public Sentence(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    @Override
    public void printText() {
        System.out.print(sentence + " ");
    }

    @Override
    public String getValue(){
        return getSentence() + " ";
    }
}
