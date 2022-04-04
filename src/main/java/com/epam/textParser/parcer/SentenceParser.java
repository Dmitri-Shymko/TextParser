package com.epam.textParser.parcer;

import com.epam.textParser.entity.filename.FileName;
import com.epam.textParser.logic.util.Util;
import com.epam.textParser.entity.pattern.MyPattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends Parser {
    private static final Logger logger = (Logger) LogManager.getLogger(SentenceParser.class);

    private String sentenceString = new String();
    private TreeMap<Integer, String> sentenceMap = new TreeMap<>();

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
        logger.error("My first for sentence parser logger:)!");

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
        logger.error("My first for sentence parser logger:)!");

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
        logger.error("My first for sentence parser logger:)!");

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
