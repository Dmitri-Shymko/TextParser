import com.epam.textParser.logic.Util;
import com.epam.textParser.parcer.CodeParser;
import com.epam.textParser.parcer.Parser;
import com.epam.textParser.parcer.SentenceParser;
import com.epam.textParser.parcer.WordParser;

public class App {
    public static void main(String[] args) {
        Util.scanFile("test.txt");
//        System.out.println(Util.inputFileText);


        Parser parser = new WordParser();
        Parser codeParser = new CodeParser();
        parser.parse(Util.inputFileText);
        codeParser.parse(Util.inputFileText);

    }

}
