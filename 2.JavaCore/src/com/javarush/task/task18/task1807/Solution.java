package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String name1 = scanner.nextLine();
        FileInputStream inputStream = new FileInputStream(name1);
        int commaCount = 0;
        if(inputStream.available()>0){
            byte[] bytes = new byte[inputStream.available()];
            int count = inputStream.read(bytes);
            for(int i = 0; i<count; i++){
                if(bytes[i] == ',')commaCount++;

            }
        }
        System.out.println(commaCount);
        inputStream.close();
    }
}
