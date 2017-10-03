package com.example.rikharthu.telephone;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TelephoneKeyboard {
    private String wordsFile;

    public TelephoneKeyboard(String wordsFile) {
        this.wordsFile = wordsFile;
    }

    public List<String> getMatchingsWords(String input) {
        List<String> result = new ArrayList();
        Scanner fileScanner = null;

        try {
            fileScanner = new Scanner(new BufferedReader(new FileReader(this.wordsFile)));
            fileScanner.useDelimiter("\\r\\n");

            while (fileScanner.hasNext()) {
                String word = fileScanner.next();
                if (toNumbersString(word).contains(input)) {
                    result.add(word);
                }
            }
        } catch (FileNotFoundException var8) {
            var8.printStackTrace();
        } finally {
            if (fileScanner != null) {
                fileScanner.close();
            }

        }

        return result;
    }

    public static String toNumbersString(String input) {
        StringBuilder sb = new StringBuilder(input.length());
        char[] var2 = input.toLowerCase().toCharArray();
        int var3 = var2.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            char c = var2[var4];
            sb.append(toNumber(c));
        }

        return sb.toString();
    }

    public static int toNumber(char c) {
        byte result;
        switch (c) {
            case 'a':
            case 'b':
            case 'c':
                result = 2;
                break;
            case 'd':
            case 'e':
            case 'f':
                result = 3;
                break;
            case 'g':
            case 'h':
            case 'i':
                result = 4;
                break;
            case 'j':
            case 'k':
            case 'l':
                result = 5;
                break;
            case 'm':
            case 'n':
            case 'o':
                result = 6;
                break;
            case 'p':
            case 'q':
            case 'r':
            case 's':
                result = 7;
                break;
            case 't':
            case 'u':
            case 'v':
                result = 8;
                break;
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                result = 9;
                break;
            default:
                result = 0;
        }

        return result;
    }
}
