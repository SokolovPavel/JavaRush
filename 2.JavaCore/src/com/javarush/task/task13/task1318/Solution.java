package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        InputStream file;
        //BufferedReader reader = new BufferedReader(FileInputStream(fileName));
        try {
            file = new FileInputStream(fileName);
            int count = file.available();
            for(int i=0;i<count;i++)
                System.out.print((char)(file.read())); //записываем прочитанный байт в другой поток.
            file.close();
        }
        catch(Exception e)
        {

        }

        //reader.close();
    }
}