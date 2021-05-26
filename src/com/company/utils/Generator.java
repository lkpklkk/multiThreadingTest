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
    private static final int MAX_FILE_NUM = 10;
    private static final int MAX_FILE_LENGTH = 100;
    private static final int STRING_LENGTH = 20;

    public static void generateFiles(String dir) {
        Random rand = new Random();
        int fileNum = MAX_FILE_NUM;
        while (fileNum != 0) {
            String filename;
            try {
                filename = dir + "\\" + generateRandomString();
                File myObj = new File(filename);
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                } else {
                    System.out.println("File already exists.");
                    fileNum--;
                    continue;
                }
            } catch (IOException e) {
                System.err.println("An error occurred.");
                e.printStackTrace();
                fileNum--;
                continue;

            }
            try {
                FileWriter fw = new FileWriter(filename, true);

                //true for append mode
                int fileLength = MAX_FILE_LENGTH;
                int numStrings = (fileLength / (rand.nextInt(10) + 1) + 1);
                ArrayList<String> listOfString = new ArrayList<>();
                for (int i = 0; i < numStrings; i++) {
                    listOfString.add(generateRandomString());
                }
                while (fileLength != 0) {
                    fw.write(String.format("%s\n", listOfString.get(rand.nextInt(numStrings))));
                    fileLength--;
                }
                fw.close();
                System.out.println("file saved.");
            } catch (Exception e) {
                e.printStackTrace();
            }
            fileNum--;
        }
    }

    public static String generateRandomString() {

        Random random = new Random();
        if (STRING_LENGTH < 1) {
            throw new IllegalArgumentException();
        }

        StringBuilder sb = new StringBuilder(STRING_LENGTH);
        for (int i = 0; i < STRING_LENGTH; i++) {
            

            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);

            sb.append(rndChar);

        }

        return sb.toString();

    }

}
