package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename = args[0];
        int c,count2=0;
        FileInputStream inputStream = new FileInputStream(filename);
        if(inputStream.available()>0){
            int count = inputStream.available();
            for(int i = 0;i<count;i++){
                c = inputStream.read();
                if(((c>=65)&&(c<=90))||((c>=97)&&(c<=122)))count2++;
            }
        }
        System.out.println(count2);
        inputStream.close();
    }
}
