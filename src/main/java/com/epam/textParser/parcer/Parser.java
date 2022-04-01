package com.epam.textParser.parcer;

import java.util.TreeMap;

public abstract class Parser {
    private Parser nextParser;

    public Parser() {
    }

    public Parser(Parser nextParser) {
        this.nextParser = nextParser;
    }

    public Parser getNextParser() {
        return nextParser;
    }

    public void setNextParser(Parser nextParser) {
        this.nextParser = nextParser;
    }

    public abstract void parseToFile(String inputText);

    public abstract TreeMap<Integer, String> parseToMap(String inputText);

    public abstract String parseToString(String inputText);

}
