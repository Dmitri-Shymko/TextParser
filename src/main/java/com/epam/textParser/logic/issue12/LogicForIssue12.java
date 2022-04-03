package com.epam.textParser.logic.issue12;

import com.epam.textParser.entity.FileName;
import com.epam.textParser.logic.util.Util;
import com.epam.textParser.entity.pattern.MyPattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogicForIssue12 {

    public void issue12WriteToFile(String inputTextFromFile, int deletedWordLength) {
        /*
         * Creating ArrayList. It's need for sorting method.
         */
        ArrayList<String> issue12List = new ArrayList<>();
        /*
         * Finding consonants.
         */
        Pattern pattern = Pattern.compile(MyPattern.CONSONANTS_REGEX);
        Matcher matcher = pattern.matcher(inputTextFromFile);

        try {
            while (matcher.find()) {
                issue12List.add(matcher.group());
            }
        } catch (NullPointerException e) {
            System.err.println(e);
        }
        /*
         * Sorting words in alphabetical order via sort method of ArrayList.
         */
        Collections.sort(issue12List, String::compareToIgnoreCase);
        String result = "";
        for (int i = 0; i < issue12List.size(); i++) {
            if (issue12List.get(i).length() == deletedWordLength) {
                issue12List.remove(i);
            } else {
                result = result + issue12List.get(i) + "\n";
            }
        }

        Util.clearFile(FileName.ISSUE_12);
        Util.makeFile(FileName.ISSUE_12, result);

    }
}
