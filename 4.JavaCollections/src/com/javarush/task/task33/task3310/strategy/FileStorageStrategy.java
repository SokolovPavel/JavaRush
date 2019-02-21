package com.javarush.task.task33.task3310.strategy;

public class FileStorageStrategy implements StorageStrategy {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000;
    FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    int size;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    long maxBucketSize;

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    public int hash(Long k){
        int h;
        return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
    }
    public int indexFor(int hash, int length){
        return hash & (length-1);}

    public Entry getEntry(Long key){
        return table[indexFor(hash(key),table.length)].getEntry();}

    public void resize(int newCapacity){
        FileBucket[] newTable = new FileBucket[newCapacity];
        transfer(newTable);
        table = newTable;
    }

    public void transfer(FileBucket[] newTable){
        int newCapacity = newTable.length;
        for(int i=0;i< table.length;i++){
            Entry e = table[i].getEntry();
            while(e != null){
                Entry next = e.next;
                int index = indexFor(e.hash,newCapacity);
                e.next = newTable[index].getEntry();
                newTable[index].putEntry(e);
                e = next;
            }
        }

    }
    public void addEntry(int hash, Long key, String value, int bucketIndex){
        if(table[bucketIndex] != null){
            resize(table.length * 2);
            hash = hash(key);
            bucketIndex = indexFor(hash,table.length);
        }
        createEntry(hash,key,value,bucketIndex);

    }
    public void createEntry(int hash, Long key, String value, int bucketIndex){
        table[bucketIndex] = new FileBucket();
        table[bucketIndex].putEntry( new Entry(hash, key, value, null) );
        size++;
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        for(int i=0; i<table.length;i++){
            if(table[i] == null)continue;
            Entry e = table[i].getEntry();
            while(e != null) {
                if( e.getValue().equals(value) )return true;
                e = e.next;
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int index = indexFor(hash(key),table.length);
        int hash = hash(key);
        if(table[index] != null){
            Entry entry = table[index].getEntry();
            while (entry != null) {
                if (entry.getKey().equals(key)) {
                    entry.value = value;
                    return;
                }
                entry = entry.next;
            }
            addEntry(hash, key, value, index);
        }
        addEntry(hash,key,value,index);
    }

    @Override
    public Long getKey(String value) {
        for(int i=0; i<table.length;i++){
            Entry e = table[i].getEntry();
            if(e == null)continue;
            while(e != null) {
                if( e.getValue().equals(value) )return e.getKey();
                e = e.next;
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        return table[indexFor(hash(key),table.length)].getEntry().getValue();
    }
}
