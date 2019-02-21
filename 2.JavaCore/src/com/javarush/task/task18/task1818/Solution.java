package com.javarush.task.task18.task1818;

/* 
Два в одном
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
        String name3 = scanner.nextLine();
        scanner.close();
        FileOutputStream outputStream = new FileOutputStream(name1);
        FileInputStream inputStream = new FileInputStream(name2);
        FileInputStream inputStream2 = new FileInputStream(name3);

        byte[] bytes = new byte[inputStream.available()];
        int count = inputStream.read(bytes);
        outputStream.write(bytes,0,count);
        byte[] bytes2 = new byte[inputStream2.available()];
        int count2 = inputStream2.read(bytes2);
        outputStream.write(bytes2,0,count2);

        inputStream.close();
        outputStream.close();
        inputStream2.close();
    }
}
