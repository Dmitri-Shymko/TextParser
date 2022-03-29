package com.epam.textParser.parcer;

import com.epam.textParser.logic.Util;
import com.epam.textParser.pattern.MyPattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeParser extends Parser{
    public CodeParser() {
    }

    public CodeParser(Parser nextParser) {
        super(nextParser);
    }

    @Override
    public void parse(String textFromFile) {
        Pattern pattern = Pattern.compile(MyPattern.CODE_REGEX);
        Matcher matcher = pattern.matcher(textFromFile);

        if (textFromFile != null) {
            while (matcher.find()) {
                String outputText = matcher.group();
                System.out.println(outputText);
                Util.makeFile("code.txt", outputText + "\n");
            }

        } else if (getNextParser() != null) {
            getNextParser().parse(textFromFile);
        }
    }
}
