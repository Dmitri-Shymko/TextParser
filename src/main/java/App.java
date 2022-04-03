import com.epam.textParser.entity.FileName;
import com.epam.textParser.logic.issue6.LogicForIssue6;
import com.epam.textParser.logic.util.Util;
import com.epam.textParser.parcer.*;
import com.epam.textParser.pattern.MyPattern;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        /*
         * Reading text from file.
         */
        String inputTextFromFile = Util.scanFile("test.txt");
        /*
         * Creating and clearing new files.
         */
        Util.clearFile(FileName.SENTENCES);
        Util.clearFile(FileName.CODE);
        Util.clearFile(FileName.WORDS);
        Util.clearFile(FileName.SYMBOLS);
        Util.clearFile(FileName.TEXT_ON_FINISH);

        Parser sentenceParser = new SentenceParser();
        Parser textWithoutCodeParser = new TextWithoutCodeParser();
        Parser codeParser = new CodeParser();
        Parser wordParser = new WordParser();
        Parser symbolParser = new SymbolParser();
        /*
         * Adding files by parsers.
         */
        String textWithoutCode = textWithoutCodeParser.parseToString(inputTextFromFile);
        sentenceParser.parseToFile(textWithoutCode);
        codeParser.parseToFile(inputTextFromFile);
        wordParser.parseToFile(inputTextFromFile);
        symbolParser.parseToFile(inputTextFromFile);

        TreeMap<Integer, String> words = wordParser.parseToMap(inputTextFromFile);
        TreeMap<Integer, String> symbols = symbolParser.parseToMap(inputTextFromFile);

        words.putAll(symbols);

        for (Map.Entry entry : words.entrySet()) {
             Util.makeFile(FileName.TEXT_ON_FINISH, entry.getValue().toString());
        }
        LogicForIssue6 logicForIssue6 = new LogicForIssue6();
        logicForIssue6.issue6WriteToFile(inputTextFromFile);


    }

}
