package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }
    /*static {
        words.add("А");
        words.add("Б");
        words.add("В");
    }*/

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        while(file.ready()){
            String line = file.readLine();
            String[] data = line.split(" ");
            int same=0;
            for(int i=0; i< data.length; i++) {
                for (int j = 0; j < words.size(); j++)
                    if (data[i].equals(words.get(j))) {
                        same++;
                        break;
                    }
                    if(same>2)break;
            }
            if(same == 2) System.out.println(line);
        }
        file.close();
    }
}
