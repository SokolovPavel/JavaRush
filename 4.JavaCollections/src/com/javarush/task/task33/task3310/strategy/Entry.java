package com.javarush.task.task33.task3310.strategy;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map;

public class Entry implements Serializable {
    Long key;
    String value;
    Entry next;
    int hash;

    public Entry(int hash, Long key, String value, Entry next){
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }
    public Long getKey(){return key;}
    public String getValue(){return value;}
    public int hashCode(){
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
    public boolean equals(Object o){
        if((((Entry)o).getKey() == key) && ((Entry)o).getValue() == value)
            return true;
        else
            return false;
    }
    public String toString(){
        return key + "=" + value;
    }
}
