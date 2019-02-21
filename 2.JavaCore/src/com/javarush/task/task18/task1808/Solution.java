package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        String filename3 = reader.readLine();
        reader.close();
        FileInputStream file1 = new FileInputStream(filename1);
        int size = file1.available();
        byte[] buffer = new byte[size];
        file1.read(buffer,0,size);
        file1.close();
        int border = (int)size/2;
        if(size%2 != 0)border++;
        FileOutputStream file2 = new FileOutputStream(filename2);
        file2.write(buffer,0,border);
        file2.close();

        FileOutputStream file3 = new FileOutputStream(filename3);
        file3.write(buffer,border,size - border);
        file3.close();
    }
}
