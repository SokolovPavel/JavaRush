package com.javarush.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        char[] buffer = new char[1000];
        try {
            int count = reader.read(buffer);
            for (int i = 0; i < count; i++) {
                buffer[i] += key;
            }
            String s = new String(buffer, 0, count);
            if (s == null) return "";
            return s;
        }
        catch (Exception e){
            return "";
        }
    }
}
