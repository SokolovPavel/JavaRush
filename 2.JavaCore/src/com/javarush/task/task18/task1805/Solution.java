package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Set<Byte> set = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        FileInputStream reader  = new FileInputStream(scanner.nextLine());
        byte[] buffer = new byte[reader.available()];
        int count = reader.read(buffer);
        reader.close();
        for(int i=0; i< count; i++)
            set.add(buffer[i]);
        ArrayList<Byte> list = new ArrayList<>(set);
        list.sort(Byte::compareTo);
        for(Byte b:list)
            System.out.print(b + " ");
    }
}
