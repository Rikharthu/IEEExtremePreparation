package com.example.rikharthu.cosine;

import java.util.Arrays;

public class Main {

    public static final String ARGUMENT_REGEX = "\\[(\\d,)*(\\d){1}\\]";

    public static void main(String[] args) {
        try {
            calculateCosineSimilarity(args);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    private static void calculateCosineSimilarity(String[] args) {
        if (args.length != 2) {
            System.out.println("Error");
            return;
        }

        String vector1Str = args[0];
        String vector2Str = args[1];

        // TODO fix regex to accept negative integers
        if (!(vector1Str.matches(ARGUMENT_REGEX) && vector2Str.matches(ARGUMENT_REGEX))) {
            System.out.println("Error");
            return;
        }

        String[] vector1Parts = vector1Str.substring(1, vector1Str.length() - 1).split(",");
        String[] vector2Parts = vector2Str.substring(1, vector2Str.length() - 1).split(",");

        if (!(vector1Parts.length == vector2Parts.length)) {
            System.out.println("Error");
            return;
        }

        int length = vector1Parts.length;
        int[] vector1 = new int[length];
        int[] vector2 = new int[length];
        for (int i = 0; i < length; i++) {
            vector1[i] = Integer.parseInt(vector1Parts[i]);
            vector2[i] = Integer.parseInt(vector2Parts[i]);
        }

        double result = cosineSimilarity(vector1, vector2);

        System.out.printf("%.4f\n", result);
    }

    private static double cosineSimilarity(int[] vector1, int[] vector2) {
        return Math.acos(dotProduct(vector1, vector2) / (vectorAbs(vector1) * vectorAbs(vector2)));
    }

    private static int dotProduct(int[] vector1, int[] vector2) {
        int[] result = new int[vector1.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = vector1[i] * vector2[i];
        }
        return Arrays.stream(result).sum();
    }

    private static double vectorAbs(int[] vector) {
        return Math.sqrt(Arrays.stream(vector).map(x -> x * x).sum());
    }
}
