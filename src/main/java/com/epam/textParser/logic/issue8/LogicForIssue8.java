package com.epam.textParser.logic.issue8;

import com.epam.textParser.entity.filename.FileName;
import com.epam.textParser.logic.util.Util;
import com.epam.textParser.entity.pattern.MyPattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Issue 8: It's need to write words starting from vowel in alphabetical order.
 */

public class LogicForIssue8 {
    private static final Logger logger = (Logger) LogManager.getLogger(LogicForIssue8.class);

    public void issue8WriteToFile(String inputTextFromFile) {
        /*
         * Creating ArrayList. It's need for sorting method.
         */
        ArrayList<String> issue8List = new ArrayList<>();
        String result = "";

        Pattern pattern = Pattern.compile(MyPattern.VOWEL_REGEX);
        Matcher matcher = pattern.matcher(inputTextFromFile);
        logger.error("Issue 8 : my first error logger.");
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
