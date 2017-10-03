package com.example.rikharthu.telephone;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath;
        String number;
        if (args.length == 2) {
            filePath = args[0];
            number = args[1];
        } else {
            System.out.printf("Wrong number of arguments: expected 2, was %d\n", args.length);
            return;
        }

        TelephoneKeyboard telephoneKeyboard = new TelephoneKeyboard(filePath);
        List<String> matchingWords = telephoneKeyboard.getMatchingsWords(number);

        int count = matchingWords.size();
        if (count > 0) {
            if (count > 1) {
                System.out.printf("%d matches:\n\n", count);
            }
            matchingWords.forEach(System.out::println);
        } else {
            System.out.println("No matches");
        }

    }
}
