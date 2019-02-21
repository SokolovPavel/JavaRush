package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(bufferedReader.readLine());
        FileWriter fileWriter = new FileWriter(bufferedReader.readLine());
        bufferedReader.close();
        char[] buffer = new char[1000];
        int count = 0;
        String result = "";
        while (count != -1){
            count = fileReader.read(buffer);
            if(count == -1)break;
        result = result + new String(buffer,0,count);
        }
        //System.out.println(count + " " + result);
        //String[] s  = result.split("world");
        /*int count2 = s.length;
        System.out.println(count2);*/
        int count3 = 0;
        for(String s : result.split("\\D")) {
            //System.out.println(s);
            if(s.length()>0)
            fileWriter.write(s);
        }
        //System.out.println(count3);
        fileReader.close();
        fileWriter.close();
    }
}
