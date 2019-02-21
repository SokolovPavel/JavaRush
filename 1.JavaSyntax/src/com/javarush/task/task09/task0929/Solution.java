package com.javarush.task.task09.task0929;

import java.io.*;

/* 
Обогатим код функциональностью!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sourceFileName = reader.readLine();

        InputStream fileInputStream;
        try {
            fileInputStream = getInputStream(sourceFileName);
        }
        catch (FileNotFoundException e){
            System.out.println("Файл не существует.");
            fileInputStream = getInputStream(reader.readLine());
        }
        String destinationFileName = reader.readLine();
        OutputStream fileOutputStream = getOutputStream(destinationFileName);

        /*int data=-1;
        while ((data = fileInputStream.read())!=-1) {

            fileOutputStream.write(data);
        }*/
        byte[] buffer = new byte[fileInputStream.available()];
        // считываем буфер
        fileInputStream.read(buffer, 0, buffer.length);
        // записываем из буфера в файл
        fileOutputStream.write(buffer, 0, buffer.length);

        fileInputStream.close();
        fileOutputStream.close();
    }

    public static InputStream getInputStream(String fileName) throws IOException {
        return new FileInputStream(fileName);
    }

    public static OutputStream getOutputStream(String fileName) throws IOException {
        return new FileOutputStream(fileName);
    }
}

