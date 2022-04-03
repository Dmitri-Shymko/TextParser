package com.epam.textParser.logic.issue8;

import com.epam.textParser.entity.FileName;
import com.epam.textParser.logic.util.Util;
import com.epam.textParser.entity.pattern.MyPattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Issue 8: It's need to write words starting from vowel in alphabetical order.
 */

public class LogicForIssue8 {

    public void issue8WriteToFile(String inputTextFromFile) {
        /*
         * Creating ArrayList. It's need for sorting method.
         */
        ArrayList<String> issue8List = new ArrayList<>();
        String result = "";

        Pattern pattern = Pattern.compile(MyPattern.VOWEL_REGEX);
        Matcher matcher = pattern.matcher(inputTextFromFile);
        /*
         * Finding vowels.
         */
        try {
            while (matcher.find()) {
                issue8List.add(matcher.group());
            }
        } catch (NullPointerException e) {
            System.err.println(e);
        }
        /*
         * Sorting words in alphabetical order via sort method of ArrayList.
         */
        Collections.sort(issue8List, String::compareToIgnoreCase);
        for (String s : issue8List) {
            result = result + s + "\n";
        }
        /*
         * Created text file "issue8.txt" and writing result to it. Clearing file method is need if this method was
         * started more then once time.
         */
        Util.clearFile(FileName.ISSUE_8);
        Util.makeFile(FileName.ISSUE_8, result);

    }
}
