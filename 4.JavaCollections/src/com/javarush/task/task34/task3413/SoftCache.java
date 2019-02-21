package com.javarush.task.task34.task3413;

import org.omg.CORBA.Any;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {
        if(cacheMap.containsKey(key)) {
            SoftReference<AnyObject> softReference = cacheMap.get(key);
            return softReference.get();
        }else{
            return null;
        }
        //напишите тут ваш код
    }

    public AnyObject put(Long key, AnyObject value) {
        if(cacheMap.containsKey(key)) {
            SoftReference<AnyObject> softReference = cacheMap.get(key);
            AnyObject obj = softReference.get();
            softReference.clear();
            return obj;
        }else{
            cacheMap.put(key, new SoftReference<>(value));
            return null;
        }
        //напишите тут ваш код
    }

    public AnyObject remove(Long key) {
        if(cacheMap.containsKey(key)) {
            SoftReference<AnyObject> softReference = cacheMap.remove(key);
            AnyObject value = softReference.get();
            softReference.clear();
            return value;
        }else{
            return null;
        }

        //напишите тут ваш код
    }
}