package com.company.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author lekeping
 */
public class Generator {
    private static final String DATA_FOR_RANDOM_STRING = "abcdefghijklmn";
    private static final int MAX_FILE_NAME_LENGTH = 50;
    private static final int MAX_FILE_NUM = 2;
    private static final int MAX_FILE_LENGTH = 100;
    private static final int STRING_LENGTH = 20;

    public static void generateFiles(String dir) {
        Random rand = new Random();
        int firstCount = rand.nextInt(MAX_FILE_NUM) + 1;
        while (firstCount != 0) {
            String filename;
            try {
                filename = dir + "\\" + generateRandomString();
                File myObj = new File(filename);
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                } else {
                    System.out.println("File already exists.");
                    firstCount--;
                    continue;
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
                firstCount--;
                continue;

            }
            try {
                FileWriter fw = new FileWriter(filename, true);

                //true for append mode
                int secondCount = MAX_FILE_LENGTH;
                int numStrings = (secondCount / (rand.nextInt(10) + 1) + 1);
                ArrayList<String> listOfString = new ArrayList<>();
                for (int i = 0; i < numStrings; i++) {
                    listOfString.add(generateRandomString());
                }
                while (secondCount != 0) {
                    fw.write(String.format("%s\n", listOfString.get(rand.nextInt(numStrings))));
                    secondCount--;
                }
                fw.close();
                System.out.println("file saved.");
            } catch (Exception e) {
                e.printStackTrace();
            }
            firstCount--;
        }
    }

    public static String generateRandomString() {

        Random random = new Random();
        if (STRING_LENGTH < 1) {
            throw new IllegalArgumentException();
        }

        StringBuilder sb = new StringBuilder(STRING_LENGTH);
        for (int i = 0; i < STRING_LENGTH; i++) {

            // 0-62 (exclusive), random returns 0-61
            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);

            sb.append(rndChar);

        }

        return sb.toString();

    }

}
