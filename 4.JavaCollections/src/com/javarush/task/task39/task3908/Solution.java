package com.javarush.task.task39.task3908;

import java.util.HashMap;
import java.util.Map;

/*
Возможен ли палиндром?
*/
public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isPalindromePermutation(String s) {
        if(s == null ||s.length()==0)return false;
        if(s.length()==1)return true;

        Map<Character,Integer> map = new HashMap<>();
        s = s.toLowerCase().replace(" ","");
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++){
            if(map.containsKey(chars[i])){
                int a = map.get(chars[i]);
                map.put(chars[i],a + 1);
            }
            else {
                map.put(chars[i],1);
            }
        }
        boolean chet = chars.length%2 == 0 ? true:false;
        boolean hastryed = false;
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue()%2 == 1){
                if( chet || hastryed)return false;
                if(!hastryed)hastryed = true;
            }
        }
        return true;
    }
}
