package com.epam.textParser.logic.issue6;

import com.epam.textParser.entity.FileName;
import com.epam.textParser.logic.util.Util;
import com.epam.textParser.entity.pattern.MyPattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Issue 6: It's need to write words in alphabetical order where new letter starts from new line.
 */

public class LogicForIssue6 {

    public void issue6WriteToFile(String inputTextFromFile) {
        /*
         * Creating ArrayList. It's need for sorting method.
         */
        ArrayList<String> issue6List = new ArrayList<>();

        Pattern pattern = Pattern.compile(MyPattern.WORD_REGEX);
        Matcher matcher = pattern.matcher(inputTextFromFile);
        /*
         * Finding words.
         */
        try {
            while (matcher.find()) {
                issue6List.add(matcher.group());
            }
        } catch (NullPointerException e) {
            System.err.println(e);
        }
        /*
         * Sorting words in alphabetical order via sort method of ArrayList.
         */
        Collections.sort(issue6List, String::compareToIgnoreCase);
        /*
         * We use cycle "For" for comparing words by first letters and adding spaces or new lines.
         */

        String result = "";
        for (int i = 0; i < issue6List.size() - 1; i++) {
            if (issue6List.get(i).substring(0, 1).equalsIgnoreCase(issue6List.get(i + 1).substring(0, 1))) {
                result = result + issue6List.get(i) + " ";
            } else {
                result = result + issue6List.get(i) + "\n";
            }
        }
        /*
         * Created text file "issue6.txt" and writing result to it. Clearing file method is need if this method was
         * started more then once time.
         */
        Util.clearFile(FileName.ISSUE_6);
        Util.makeFile(FileName.ISSUE_6, result);
    }
}
