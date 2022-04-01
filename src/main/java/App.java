import com.epam.textParser.entity.FileName;
import com.epam.textParser.logic.Util;
import com.epam.textParser.parcer.*;

import java.util.ArrayList;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Util.scanFile("test.txt");
        Util.clearFile(FileName.SENTENCES);
        Util.clearFile(FileName.CODE);
        Util.clearFile(FileName.WORDS);
        Util.clearFile(FileName.SYMBOLS);


        Parser textWithoutCodeParser = new TextWithoutCodeParser();
        Parser sentenceParser = new SentenceParser();
        Parser codeParser = new CodeParser();
        Parser wordParser = new WordParser();
        Parser symbolParser = new SymbolParser();

//        sentenceParser.parseToFile(Util.inputFileText);
//        codeParser.parse(Util.inputFileText);
//        System.out.println(parser.parseToArray(Util.inputFileText) + "\n");

        String textWithoutCode = textWithoutCodeParser.parseToString(Util.inputFileText);
        sentenceParser.parseToFile(textWithoutCode);

        for (Map.Entry entry : sentenceParser.parseToMap(textWithoutCode).entrySet()) {
            System.out.println("Key: " + entry.getKey() + ". Value: " + entry.getValue());
        }

//        ArrayList<String> stringArrayList = sentenceParser.parseToArray(Util.inputFileText);
//        for (String element : stringArrayList) {
//            wordParser.parseToFile(element);
//        }
//        for (String element : stringArrayList) {
//            codeParser.parseToFile(element);
//        }

    }

}
