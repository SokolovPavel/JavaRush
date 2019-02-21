package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(bufferedReader.readLine()));
        bufferedReader.close();
        char[] buffer = new char[1000];
        int count = 0;
        String result = "";
        while (fileReader.ready()){
            result = result + fileReader.readLine();
        }
        result = result.replaceAll("[^a-zA-Z0-9 ]","");
        fileWriter.write(result);

        fileReader.close();
        fileWriter.close();
    }
}
