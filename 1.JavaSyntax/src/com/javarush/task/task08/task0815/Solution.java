package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String,String> map = new HashMap<String,String>();

        map.put("Улие","рпрfgпр");
        map.put("У2лие","рпdрпр");
        map.put("Уdл7ие","рпрпр");
        map.put("Ул3ие","рпfрgпр");
        map.put("Уdлие","рпрпр");
        map.put("Ули6е","рпрgпdр");
        map.put("Улdи7е","рпрпр");
        map.put("Ул8ие","рпрdпр");
        map.put("Улdие","рпрпр");
        map.put("Ули0е","рпрпр");

        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int count=0;
        for(String s: map.values())
            if(s.equals(name))count++;
        return count;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int count=0;
        for(String s: map.keySet())
            if(s.equals(lastName))count++;

        return count;

    }

    public static void main(String[] args) {

    }
}
