package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("name","Ivanov");
        map.put("country","Russia");
        map.put("city","Saint P");
        System.out.println(getQuery(map));
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder builder = new StringBuilder();
        boolean first = true;
        for(Map.Entry<String,String> e : params.entrySet()){
            if(e.getValue() != null) {
                if (!first) builder.append(" and ");
                first = false;
                builder.append(e.getKey() + " = '" + e.getValue() + "'");
            }
        }
        return builder.toString();
    }
}
