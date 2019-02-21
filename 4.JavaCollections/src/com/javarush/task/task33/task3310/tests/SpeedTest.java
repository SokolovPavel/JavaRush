package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static com.javarush.task.task33.task3310.Solution.getIds;
import static com.javarush.task.task33.task3310.Solution.getStrings;

public class SpeedTest {
    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids){
        Date date = new Date();
        ids = getIds(shortener, strings);
        Date date2 = new Date();
        return date2.getTime() - date.getTime();
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        Date date = new Date();
        date = new Date();
        strings = getStrings(shortener, ids);
        Date date2 = new Date();
        return date2.getTime() - date.getTime();
    }

    @Test
    public void testHashMapStorage(){
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> strings = new HashSet<>();
        for(int i=0;i<10000; i++)
            strings.add(Helper.generateRandomString());
        Set<Long> ids = new HashSet<>();
        Long t1 = getTimeForGettingIds(shortener1,strings,ids);
        Long t2 = getTimeForGettingIds(shortener2,strings,ids);
        Assert.assertTrue(t1>t2);

        t1 = getTimeForGettingStrings(shortener1,ids,strings);
        t2 = getTimeForGettingStrings(shortener2,ids,strings);
        Assert.assertEquals(t1,t2,30);
    }
}
