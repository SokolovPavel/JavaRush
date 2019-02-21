package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
        String filename1 = bufferedReader.readLine();
        String filename2 = bufferedReader.readLine();
        bufferedReader.close();

        FileReader fileReader = new FileReader(filename1);
        FileWriter fileWriter = new FileWriter(filename2);
        boolean even = false;
        while(fileReader.ready()){
            if(even)fileWriter.write(fileReader.read());
            else
                fileReader.read();
            even = !even;
        }
        fileReader.close();
        fileWriter.close();

    }
}
