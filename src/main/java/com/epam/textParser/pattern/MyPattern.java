package com.epam.textParser.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyPattern {

    public static final String PARAGRAPH_REGEX = "(?m)(?=^\\s{4})";
    public static final String SENTENCE_REGEX =
            "[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?['\"]?(?=\\s|$)";
    public static final String CODE_REGEX =
            "((void)\\s\\w+\\(\\)\\s\\{([^}]*?)(\\})|(\\s\\}))|else\\s\\{([^}]*?)\\}|(class\\s\\w+\\s\\{([^}]*?)\\})|else\\sif\\s\\(\\D*\\d*\\)\\s\\{([^}]*?)\\}|(System\\D*\\})";
    public static final String WORD_REGEX = "[a-zA-Z]+";
    public static final String SYMBOL_REGEX = "\\W|\\d";

    public static boolean CompareSentence(String text) {

        boolean temp = false;
        Pattern pattern = Pattern.compile(SENTENCE_REGEX);
        Matcher matcher = pattern.matcher(text);
        if (matcher.matches()) {
            temp = true;
        }
        return temp;
    }

}
