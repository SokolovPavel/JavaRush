package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import javafx.collections.transformation.SortedList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        //FileReader fileReader = new FileReader("C://PDF//1");
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader reader = new BufferedReader(fileReader);
        //List<Man> mans = new LinkedList<>();
        Map<String,Double> mans = new TreeMap<>();
        while (reader.ready()){
            //Man man = new Man(reader.readLine());
            String[] sa = reader.readLine().split(" ");
            if(mans.containsKey(sa[0]))
                mans.replace(sa[0],mans.get(sa[0]) + Double.parseDouble(sa[1]));
                else
            mans.put(sa[0],Double.parseDouble(sa[1]));

        }
        //for(Man m : mans)
        for(Map.Entry entry: mans.entrySet()) {
            //получить ключ
            String key = (String)entry.getKey();
            //получить значение
            Double value = (Double)entry.getValue();
            System.out.println(key + " " + value);
        }
        fileReader.close();
    }

    public static class Man implements Comparable<Man>{
        public String name;
        public Double salary;
        public Man(String name,Double salary){
            this.name = name;
            this.salary = salary;
        }
        public Man(String s){
            String[] sa = s.split(" ");
            name = sa[0];
            salary = Double.parseDouble(sa[1]);
        }
        public int compareTo(Man man){
            return name.compareTo(man.name);
        }
    }
}
