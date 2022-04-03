package com.epam.textParser.parcer;

import com.epam.textParser.entity.FileName;
import com.epam.textParser.logic.util.Util;
import com.epam.textParser.entity.pattern.MyPattern;

import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends Parser {

    private String sentenceString = new String();
    public TreeMap<Integer, String> sentenceMap = new TreeMap<>();

    public SentenceParser() {
    }

    public SentenceParser(Parser nextParser) {
        super(nextParser);
    }

    @Override
    public void parseToFile(String inputText) {
        int count = 1;
        Pattern pattern = Pattern.compile(MyPattern.SENTENCE_REGEX);
        Matcher matcher = pattern.matcher(inputText);

        if (inputText != null) {
            while (matcher.find()) {

                Util.makeFile(FileName.SENTENCES,
                        "Sentence # " + count + " is: " + matcher.group() + "\n");
                count++;
            }

        } else if (getNextParser() != null) {
            getNextParser().parseToFile(inputText);
        }

    }

    @Override
    public TreeMap<Integer, String> parseToMap(String inputText) {

        Pattern pattern = Pattern.compile(MyPattern.SENTENCE_REGEX);
        Matcher matcher = pattern.matcher(inputText);

        try {
            while (matcher.find()) {
                sentenceMap.put(matcher.start(), matcher.group());
            }

        } catch (NullPointerException e) {
            System.err.println(e);
        }

        return sentenceMap;
    }

    @Override
    public String parseToString(String inputText) {

        Pattern pattern = Pattern.compile(MyPattern.SENTENCE_REGEX);
        Matcher matcher = pattern.matcher(inputText);

        if (inputText != null) {
            while (matcher.find()) {
                sentenceString = matcher.group();
            }

        } else if (getNextParser() != null) {
            getNextParser().parseToFile(inputText);
        }
        return sentenceString;
    }
}
