package com.epam.textParser.parcer;

import com.epam.textParser.entity.filename.FileName;
import com.epam.textParser.logic.util.Util;
import com.epam.textParser.entity.pattern.MyPattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SymbolParser extends Parser {
    private static final Logger logger = (Logger) LogManager.getLogger(SymbolParser.class);

    private TreeMap<Integer, String> symbolsMap = new TreeMap<>();

    public SymbolParser() {
    }

    public SymbolParser(Parser nextParser) {
        super(nextParser);
    }

    @Override
    public void parseToFile(String inputText) {
        int count = 1;
        Pattern pattern = Pattern.compile(MyPattern.SYMBOL_REGEX);
        Matcher matcher = pattern.matcher(inputText);
        logger.error("My first logger for symbol parser:)!");

        if (inputText != null) {
            while (matcher.find()) {
                Util.makeFile(FileName.SYMBOLS, "Symbol # " + count + " Starting index is: " + matcher.start() + " " + matcher.group() + "\n");
                count++;
            }

        } else if (getNextParser() != null) {
            getNextParser().parseToFile(inputText);
        }

    }

    @Override
    public TreeMap<Integer, String> parseToMap(String inputText) {
        Pattern pattern = Pattern.compile(MyPattern.SYMBOL_REGEX);
        Matcher matcher = pattern.matcher(inputText);
        logger.error("My first logger for symbol parser:)!");

        try {
            while (matcher.find()) {
                symbolsMap.put(matcher.start(), matcher.group());
            }

        } catch (NullPointerException e) {
            System.err.println(e);
        }
        return symbolsMap;
    }

    @Override
    public String parseToString(String inputText) {
        return null;
    }
}
