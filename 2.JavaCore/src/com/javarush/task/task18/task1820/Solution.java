package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String filename = reader.readLine();
            String filename2 = reader.readLine();
            reader.close();

            BufferedReader filereader = new BufferedReader(new FileReader(filename));
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename2));
            String s = filereader.readLine();
            filereader.close();
            Scanner scanner = new Scanner(s);
            float f;
                while (scanner.hasNextFloat()){
                    f = scanner.nextFloat();
                    int i = Math.round(f);
                    writer.write(i + " ");
                }
             writer.close();
        }
        catch (Exception e){}
    }
}
