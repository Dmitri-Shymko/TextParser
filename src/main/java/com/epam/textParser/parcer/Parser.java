package com.epam.textParser.parcer;

import com.epam.textParser.entity.CompositeText;
import com.epam.textParser.pattern.MyPattern;

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

    public abstract void parse(String textFromFile);
}
