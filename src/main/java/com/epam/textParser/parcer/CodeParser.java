package com.epam.textParser.parcer;

import com.epam.textParser.entity.FileName;
import com.epam.textParser.logic.util.Util;
import com.epam.textParser.pattern.MyPattern;

import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeParser extends Parser {

    public TreeMap<Integer, String> codeMap = new TreeMap<>();

    public CodeParser() {
    }

    public CodeParser(Parser nextParser) {
        super(nextParser);
    }

    @Override
    public void parseToFile(String inputText) {
        int count = 1;
        Pattern pattern = Pattern.compile(MyPattern.CODE_REGEX);
        Matcher matcher = pattern.matcher(inputText);

        if (inputText != null) {
            while (matcher.find()) {
                Util.makeFile(FileName.CODE, "Code block # " + count + " is: " + matcher.group() + "\n");
                count++;
            }

        } else if (getNextParser() != null) {
            getNextParser().parseToFile(inputText);
        }
    }

    @Override
    public TreeMap<Integer, String> parseToMap(String inputText) {

        Pattern pattern = Pattern.compile(MyPattern.CODE_REGEX);
        Matcher matcher = pattern.matcher(inputText);

        try {
            while (matcher.find()) {
                codeMap.put(matcher.start(), matcher.group());
            }

        } catch (NullPointerException e) {
            System.err.println(e);
        }

        return codeMap;
    }

    @Override
    public String parseToString(String inputText) {
        return null;
    }
}
