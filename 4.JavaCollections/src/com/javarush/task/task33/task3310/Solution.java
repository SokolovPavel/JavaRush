package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.OurHashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.*;

import java.util.*;

public class Solution {
    public static void main(String[] args){

        testStrategy(new HashMapStorageStrategy(),10000);
        testStrategy(new OurHashMapStorageStrategy(),10000);
        testStrategy(new HashBiMapStorageStrategy(),10000);
        testStrategy(new OurHashBiMapStorageStrategy(),10000);
    }
    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> result = new HashSet<>();
        for(String s : strings)
            result.add(shortener.getId(s));
        return result;
    }
    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> result = new HashSet<>();
        for(Long k : keys)
            result.add(shortener.getString(k));
        return result;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        System.out.println((strategy.getClass().getSimpleName()));
        Set<String> strings = new HashSet<>();
        for(int i=0;i<elementsNumber; i++)
            strings.add(Helper.generateRandomString());
        Shortener shortener = new Shortener(strategy);
        Date date = new Date();
        Set<Long> keys = getIds(shortener, strings);
        Date date2 = new Date();
        System.out.println(date2.getTime() - date.getTime());

        date = new Date();
        Set<String> strings_m = getStrings(shortener, keys);
        date2 = new Date();
        System.out.println(date2.getTime() - date.getTime());
        if(strings.containsAll(strings_m) && strings_m.containsAll(strings))
            System.out.println("Тест пройден.");
        else
            System.out.println("Тест не пройден.");
    }
}
