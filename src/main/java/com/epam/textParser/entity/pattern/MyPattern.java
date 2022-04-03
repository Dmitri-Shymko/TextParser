package com.epam.textParser.entity.pattern;

public class MyPattern {

    public static final String PARAGRAPH_REGEX = "(?m)(?=^\\s{4})";
    public static final String SENTENCE_REGEX =
            "[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?['\"]?(?=\\s|$)";
    public static final String CODE_REGEX =
            "((void)\\s\\w+\\(\\)\\s\\{([^}]*?)(\\})|(\\s\\}))|else\\s\\{([^}]*?)\\}|(class\\s\\w+\\s\\{([^}]*?)\\})|else\\sif\\s\\(\\D*\\d*\\)\\s\\{([^}]*?)\\}|(System\\D*\\})";
    public static final String WORD_REGEX = "[a-zA-Z]+";
    public static final String SYMBOL_REGEX = "\\W|\\d";
    public static final String VOWEL_REGEX = "\\b[aeiou|AEIOU].*?\\b";
    public static final String CONSONANTS_REGEX = "\\b[bcdfgjklmnpqstvxzhrwy|BCDFGJKLMNPQSTVXZHRWY].*?\\b";

}
