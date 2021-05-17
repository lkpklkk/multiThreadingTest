package com.company.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class HelperFunc
{
    private static final String DATA_FOR_RANDOM_STRING = "abcdefghijklmn";
    private static final int MAX_FILE_NAME_LENGTH = 50;
    private static final int MAX_FILE_NUM = 2;

    private static final int MAX_FILE_LENGTH = 100;
    public static void generateFiles(String dir){
        Random rand = new Random();
        int firstCount = rand.nextInt(MAX_FILE_NUM) + 1;
        while (firstCount != 0) {
            String filename;
            try {
                filename =  dir + "\\"+ generateRandomString(rand.nextInt(MAX_FILE_NAME_LENGTH)+1);
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
                FileWriter fw = new FileWriter(filename,true);

                // true for append mode
                //str stores the string which we have entered
                int secondCount = rand.nextInt(MAX_FILE_LENGTH);
                int numStrings = (secondCount / (rand.nextInt(10)+1)+1);
                ArrayList<String> listOfString = new ArrayList<String>();
                for (int i = 0;i<numStrings;i++){
                    listOfString.add(generateRandomString(rand.nextInt(20)+1));
                }
                while (secondCount != 0){
                    fw.write(String.format("%s\n", listOfString.get(rand.nextInt(numStrings))));
                    secondCount--;
                }
                fw.close();
                //writes bytes into file

                //close the file
                System.out.println("file saved.");
            } catch (Exception e) {
                e.printStackTrace();
            }
            firstCount--;
        }
    }

    public static String generateRandomString(int length) {
        Random random = new Random();
        if (length < 1) {
            throw new IllegalArgumentException();
        }

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {

            // 0-62 (exclusive), random returns 0-61
            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);

            sb.append(rndChar);

        }

        return sb.toString();

    }

}
