package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        //1FileReader fileReader = new FileReader("C://PDF//1");
        BufferedReader reader = new BufferedReader(fileReader);
        Map<String,Double> mans = new TreeMap<>();
        Double num,max=0.0;
        while (reader.ready()){
            String[] sa = reader.readLine().split(" ");
            if(mans.containsKey(sa[0])) {
                num = mans.get(sa[0]) + Double.parseDouble(sa[1]);
                mans.replace(sa[0], num);
            } else {
                num = Double.parseDouble(sa[1]);

                mans.put(sa[0], num);
            }
            if(num>max){
                max = num;
                //System.out.println(max);
            }
        }
        for(Map.Entry entry: mans.entrySet()) {
            //получить ключ
            String key = (String)entry.getKey();
            //получить значение
            Double value = (Double)entry.getValue();
            if(value >= max)
                System.out.println(key);
        }
        fileReader.close();
    }
}
