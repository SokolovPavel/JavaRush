package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever{
    private LRUCache lruCache = new LRUCache(30);
    private OriginalRetriever originalRetriever;

    public CachingProxyRetriever(Storage storage){
        originalRetriever = new OriginalRetriever(storage);
    }
    public Object retrieve(long id){
        Object o = lruCache.find(id);
        if(o==null){
            Object or = originalRetriever.retrieve(id);
            lruCache.set(id,or);
            return or;
        }
        else{
            return o;
        }
    }
}
