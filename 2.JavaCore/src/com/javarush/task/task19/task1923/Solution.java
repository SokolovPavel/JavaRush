package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        FileWriter writer = new FileWriter(args[1]);
        while (reader.ready()){
            String[] s = reader.readLine().split(" ");
            for (int i=0; i < s.length; i++)
                if( s[i].matches("(.*)[0-9]+(.*)")  )writer.write(s[i] + " ");
        }
        reader.close();
        writer.close();
    }
}
