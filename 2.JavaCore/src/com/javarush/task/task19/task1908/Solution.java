package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
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
        //System.out.println(count + " " + result);
        //String[] s  = result.split("world");
        /*int count2 = s.length;
        System.out.println(count2);*/
        int count3 = 0;
        for(String s : result.split(" ")) {
            //System.out.println(s);
            Integer num;
            try{
                num = Integer.parseInt(s);
                fileWriter.write(num.toString());
                fileWriter.write(" ");
            }
            catch (NumberFormatException e){

            }

        }
        //System.out.println(count3);
        fileReader.close();
        fileWriter.close();
    }
}
