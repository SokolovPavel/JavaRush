package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        int key = 3;
        FileInputStream reader = new FileInputStream(args[1]);
        FileOutputStream writer = new FileOutputStream(args[2]);
        byte[] buffer = new byte[reader.available()];
        int count = reader.read(buffer);
        if(args[0].equals("-e")){
            for(int i=0;i<count;i++)
                writer.write(buffer[i]+key);
        }else if(args[0].equals("-d")) {
            for (int i = 0; i < count; i++)
                writer.write(buffer[i] - key);
        }
        reader.close();
        writer.close();
    }

}
