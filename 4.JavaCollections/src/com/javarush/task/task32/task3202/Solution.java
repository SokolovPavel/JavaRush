package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter sw = new StringWriter();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));


            while (bufferedReader.ready())
                sw.write(bufferedReader.readLine());
        }
        catch (Exception e){
            sw.write("");
        }
        if (sw==null)sw.write("");
        return sw;
    }
}