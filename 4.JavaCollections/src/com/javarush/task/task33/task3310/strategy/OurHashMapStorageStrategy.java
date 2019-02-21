package com.javarush.task.task33.task3310.strategy;


import java.util.Arrays;
import java.util.HashMap;

public class OurHashMapStorageStrategy implements StorageStrategy{
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    int size;
    int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    float loadFactor = DEFAULT_LOAD_FACTOR;
    public int hash(Long k){
        int h;
        return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
    }
    public int indexFor(int hash, int length){
        return hash & (length-1);}

    public Entry getEntry(Long key){
        return table[indexFor(hash(key),table.length)];}

    public void resize(int newCapacity){
        Entry[] newTable = new Entry[newCapacity];
        threshold = (int)(newCapacity * loadFactor);
        transfer(newTable);
        table = newTable;
    }

    public void transfer(Entry[] newTable){
        int newCapacity = newTable.length;
        for(Entry e : table){
            while(e != null){
                Entry next = e.next;
                int i = indexFor(e.hash,newCapacity);
                e.next = newTable[i];
                newTable[i] = e;
                e = next;
            }
        }

    }
    public void addEntry(int hash, Long key, String value, int bucketIndex){
        if((size>=threshold) && (table[bucketIndex] != null)){
            resize(table.length * 2);
            hash = hash(key);
            bucketIndex = indexFor(hash,table.length);
        }
        createEntry(hash,key,value,bucketIndex);
        Entry e = table[bucketIndex];

    }
    public void createEntry(int hash, Long key, String value, int bucketIndex){
        Entry e = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, e);
        size++;
    }
    public boolean containsKey(Long key){
        return getEntry(key) != null;
    }

    public boolean containsValue(String value){
        for(Entry aTable : table)
            for(Entry e = aTable; e!=null; e=e.next)
                if(value.equals(e.getValue())) return true;
                return false;
    }
    public void put(Long key, String value){
        addEntry(hash(key),key,value,indexFor(hash(key),table.length));
    }

    public Long getKey(String value){
        for(Entry aTable : table)
            for(Entry e = aTable; e!=null; e=e.next)
                if(value.equals(e.getValue())) return e.getKey();
        return null;
    }

    public String getValue(Long Key){
        return getEntry(Key).getValue();
    }
}
