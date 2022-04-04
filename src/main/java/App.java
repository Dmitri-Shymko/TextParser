import com.epam.textParser.entity.filename.FileName;
import com.epam.textParser.logic.issue12.LogicForIssue12;
import com.epam.textParser.logic.issue6.LogicForIssue6;
import com.epam.textParser.logic.issue8.LogicForIssue8;
import com.epam.textParser.logic.util.Util;
import com.epam.textParser.parcer.*;

import java.util.Map;
import java.util.TreeMap;


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
        /*
         * Creating new TreeMaps for words and symbols.
         */
        TreeMap<Integer, String> words = wordParser.parseToMap(inputTextFromFile);
        TreeMap<Integer, String> symbols = symbolParser.parseToMap(inputTextFromFile);
        /*
         * Uniting TreeMaps.
         */
        words.putAll(symbols);
        /*
         * Creating new file with final result.
         */
        for (Map.Entry entry : words.entrySet()) {
             Util.makeFile(FileName.TEXT_ON_FINISH, entry.getValue().toString());
        }
        /*
         * Additional issues. Results are written to files.
         */
        LogicForIssue6 logicForIssue6 = new LogicForIssue6();
        LogicForIssue8 logicForIssue8 = new LogicForIssue8();
        LogicForIssue12 logicForIssue12 = new LogicForIssue12();

        logicForIssue6.issue6WriteToFile(inputTextFromFile);
        logicForIssue8.issue8WriteToFile(inputTextFromFile);
        logicForIssue12.issue12WriteToFile(inputTextFromFile, 3);

    }

}
