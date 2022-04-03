package com.epam.textParser.parcer;

import com.epam.textParser.entity.FileName;
import com.epam.textParser.logic.util.Util;
import com.epam.textParser.pattern.MyPattern;

import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser extends Parser {

    private String words = new String();
    public TreeMap<Integer, String> wordMap = new TreeMap<>();

    public WordParser() {
    }

    public WordParser(Parser nextParser) {
        super(nextParser);
    }

    @Override
    public void parseToFile(String inputText) {
        int count = 1;
        Pattern pattern = Pattern.compile(MyPattern.WORD_REGEX);
        Matcher matcher = pattern.matcher(inputText);

        if (inputText != null) {
            while (matcher.find()) {
                Util.makeFile(FileName.WORDS, "Word # " + count + " Starting index is: " + matcher.start() + " " + matcher.group() + "\n");
                count++;
            }

        } else if (getNextParser() != null) {
            getNextParser().parseToFile(inputText);
        }
    }

    @Override
    public TreeMap<Integer, String> parseToMap(String inputText) {
        Pattern pattern = Pattern.compile(MyPattern.WORD_REGEX);
        Matcher matcher = pattern.matcher(inputText);

        try {
            while (matcher.find()) {
                wordMap.put(matcher.start(), matcher.group());
            }

        } catch (NullPointerException e) {
            System.err.println(e);
        }
        return wordMap;
    }

    @Override
    public String parseToString(String inputText) {
        Pattern pattern = Pattern.compile(MyPattern.WORD_REGEX);
        Matcher matcher = pattern.matcher(inputText);
        try {
            while (matcher.find()) {
                words = words + matcher.group() + " ";
            }

        } catch (NullPointerException e) {
            System.err.println(e);
        }
        return words;
    }
}
