package com.epam.textParser.logic.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Util {
    private static final Logger logger = (Logger) LogManager.getLogger(Util.class);
    private static String inputFileText = "Empty file!";

    public static String scanFile(String filename) {
        try {
            logger.error("File reader first error logger!");
            FileReader fr = new FileReader(filename);
            char[] buffer = new char[8096];
            int numberOfChars = fr.read(buffer);
            while (numberOfChars != -1) {
                inputFileText = String.valueOf(buffer, 0, numberOfChars);
                numberOfChars = fr.read(buffer);
            }
            fr.close();

        } catch (IOException e) {
            System.err.println(e);
        }

        return inputFileText;
    }

    public static void makeFile(String filename, String outputInfo) {
        logger.error("File writer first error logger!");
        try {
            FileWriter fw = new FileWriter(filename, true);
            fw.append(outputInfo);
            fw.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void clearFile(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);
            fw.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

}
