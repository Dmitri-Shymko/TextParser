package com.epam.textParser.logic;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Util {

    public static String inputFileText = "Empty file!";

    public static String scanFile(String filename) {
        try {

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
        try {
            FileWriter fw = new FileWriter(filename, true);
            fw.append(outputInfo);
            fw.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

}
