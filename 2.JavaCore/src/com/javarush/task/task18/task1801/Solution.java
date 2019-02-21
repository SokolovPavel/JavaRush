package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(br.readLine());
        int a = inputStream.available();
        int max;
        int num;
        max = inputStream.read();
        for(int i = 1; i<a;i++){
            num = inputStream.read();
            if(num>max)max = num;
        }
        System.out.println(max);
        inputStream.close();
    }
}
