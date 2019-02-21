package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
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

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        for(Map.Entry<String, String> pair : map.entrySet() ) {
            for (Map.Entry<String, String> pair2 : map.entrySet()) {
                if (pair.getKey() != pair2.getKey() && pair.getValue() == pair2.getValue()) {
                    removeItemFromMapByValue(map,pair.getValue());
                }
            }
        }

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}
