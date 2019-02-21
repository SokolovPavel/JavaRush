package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader file1 = new BufferedReader(new FileReader(args[0]));
        TreeSet<Character> set = new TreeSet<>();
        while(file1.ready()){
            String s = file1.readLine().replaceAll("[^\\w]","").toLowerCase();
            for(int i=0;i<s.length();i++)
                set.add(s.charAt(i));
        }

        Iterator<Character> iterator = set.iterator();

        int size = set.size()>5? 5 : set.size();

        for(int i=0; i<size; i++){
            System.out.print(iterator.next());
        }
    }
}
