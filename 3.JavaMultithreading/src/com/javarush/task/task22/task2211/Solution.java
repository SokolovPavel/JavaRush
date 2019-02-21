package com.javarush.task.task22.task2211;

import java.io.*;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        FileOutputStream fos = new FileOutputStream(args[1]);
        int bytes = fis.available();
        byte[] buffer = new byte[bytes];
        fis.read(buffer);
        String s = new String(buffer,"Windows-1251");
        buffer = s.getBytes("utf-8");
        fos.write(buffer);
        fis.close();
        fos.close();
    }
}
