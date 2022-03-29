package com.epam.textParser.parcer;

import com.epam.textParser.logic.Util;
import com.epam.textParser.pattern.MyPattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends Parser {

    public SentenceParser() {
    }

    public SentenceParser(Parser nextParser) {
        super(nextParser);
    }

    @Override
    public void parse(String textFromFile) {

        Pattern pattern = Pattern.compile(MyPattern.SENTENCE_REGEX);
        Matcher matcher = pattern.matcher(textFromFile);

        if (textFromFile != null) {
            while (matcher.find()) {
                String outputText = matcher.group();
                System.out.println(outputText);
                Util.makeFile("sentences.txt", outputText + "\n");
            }

        } else if (getNextParser() != null) {
            getNextParser().parse(textFromFile);
        }
    }

}
