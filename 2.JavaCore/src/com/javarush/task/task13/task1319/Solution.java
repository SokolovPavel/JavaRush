package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.Scanner;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter(scanner.readLine()));
        while(true){
            String s = scanner.readLine();
            writer.write(s);

            if(s.equals("exit"))break;
            writer.write("\n");

        }
        writer.close();
        scanner.close();
        // напишите тут ваш код
    }
}
