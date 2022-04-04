package com.epam.textParser.parcer;

import com.epam.textParser.entity.pattern.MyPattern;

import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextWithoutCodeParser extends Parser {

    private String textWithoutCode = new String();

    public TextWithoutCodeParser() {
    }

    public TextWithoutCodeParser(Parser nextParser) {
        super(nextParser);
    }

    @Override
    public void parseToFile(String inputText) {

    }

    @Override
    public TreeMap<Integer, String> parseToMap(String inputText) {
        return null;
    }

    public String parseToString(String inputText) {

        Pattern pattern = Pattern.compile(MyPattern.CODE_REGEX);
        Matcher matcher = pattern.matcher(inputText);

        try {
            while (matcher.find()) {
                int count = matcher.end() - matcher.start();
                textWithoutCode = matcher.replaceAll("\\s{" + count + "}");
            }
        } catch (NullPointerException e) {
            System.err.println(e);
        }

        return textWithoutCode;
    }
}
