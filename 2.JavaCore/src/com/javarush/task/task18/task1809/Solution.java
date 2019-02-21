package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String name1 = scanner.nextLine();
        String name2 = scanner.nextLine();

        FileInputStream inputStream = new FileInputStream(name1);
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream(name2);

        if(inputStream.available()>0){
            byte[] bytes = new byte[inputStream.available()];
            int count = inputStream.read(bytes);
            for(int i = count-1;i>=0;i--)
                outputStream.write(bytes[i]);
        }

        inputStream.close();
        outputStream.close();
    }
}
