package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.strategy.*;
import com.javarush.task.task33.task3310.Shortener;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import static com.javarush.task.task33.task3310.Helper.generateRandomString;

public class FunctionalTest {
    public void testStorage(Shortener shortener){
        String s1 = generateRandomString();
        String s2 = generateRandomString();
        String s3 = new String(s1);
        Long[] ids = {shortener.getId(s1),shortener.getId(s2),shortener.getId(s3)};
        Assert.assertNotEquals(ids[1],ids[0]);
        Assert.assertNotEquals(ids[1],ids[2]);
        Assert.assertEquals(ids[0],ids[2]);
        Assert.assertEquals(shortener.getString(ids[0]),s1);
        Assert.assertEquals(shortener.getString(ids[1]),s2);
        Assert.assertEquals(shortener.getString(ids[2]),s3);
    }

    @Test
    public void testHashMapStorageStrategy() {
        HashMapStorageStrategy strategy = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }
    @Test
    public void testOurHashMapStorageStrategy() {
        OurHashMapStorageStrategy strategy = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }
    @Test
    public void testFileStorageStrategy() {
        FileStorageStrategy strategy = new FileStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }
    @Test
    public void testHashBiMapStorageStrategy() {
        HashBiMapStorageStrategy strategy = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }
    @Test
    public void testDualHashBidiMapStorageStrategy() {
        DualHashBidiMapStorageStrategy strategy = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }
    @Test
    public void testOurHashBiMapStorageStrategy() {
        OurHashBiMapStorageStrategy strategy = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }
}
