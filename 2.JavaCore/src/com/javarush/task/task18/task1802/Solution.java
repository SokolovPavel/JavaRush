package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(br.readLine());
        int a = inputStream.available();
        int min;
        int num;
        min = inputStream.read();
        for(int i = 1; i<a;i++){
            num = inputStream.read();
            if(num<min)min = num;
        }
        System.out.println(min);
        inputStream.close();
    }

}
