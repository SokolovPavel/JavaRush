package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename = args[0];
        FileInputStream inputStream = new FileInputStream(filename);
        //FileInputStream inputStream = new FileInputStream("C:/PDF/1");
        if(inputStream.available()>0){
            int count2=0,c;
            int count = inputStream.available();
            for(int i = 0;i<count;i++){
                c = inputStream.read();
                if(c==32)count2++;
            }
            double a = 100.0*count2/count;
            System.out.format("%.2f",a);
        }

        inputStream.close();
    }
}
