package com.javarush.task.task37.task3707;

import java.io.*;
import java.util.*;



public class AmigoSet<E> extends AbstractSet implements Serializable, Cloneable, Set {
    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;
    public AmigoSet(){
        map = new HashMap<>();
    }
    public AmigoSet(Collection<? extends E> collection){
        int capacity = Math.max(16,(int)(collection.size()/.75f)+1);
        map = new HashMap<>(capacity);
        addAll(collection);
    }

    @Override
    public boolean add(Object e){
        return map.put((E)e,PRESENT) == null;

    }
    public boolean contains(Object o){
        return map.containsKey(o);
    }
    public void clear(){
        map.clear();
    }
    public boolean remove(Object o){
        return map.remove(o) == null;
    }
    public boolean isEmpty(){
        return map.isEmpty();
    }

    @Override
    public int size(){
        return map.size();
    }
    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }
    public Object clone() throws InternalError{
        AmigoSet<E> set = new AmigoSet<>();
        try {
            set.map = (HashMap<E,Object>)map.clone();
            return set;
        }
        catch (Exception e){
            throw new InternalError();

        }
        
    }

    private void writeObject(ObjectOutputStream objectOutputStream)throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        HashMapReflectionHelper helper = new HashMapReflectionHelper();
        objectOutputStream.writeInt(helper.callHiddenMethod(map,"capacity"));
        objectOutputStream.writeFloat(helper.callHiddenMethod(map,"loadFactor"));
        for(E e:map.keySet()){
            objectOutputStream.writeObject(e);
        }

    }
    private void readObject(ObjectInputStream in) throws ClassNotFoundException,IOException{
        in.defaultReadObject();
        int size = in.readInt();
        int capacity = in.readInt();
        float loadFactor = in.readFloat();
        map = new HashMap<>(capacity, loadFactor);
        for(int i=0;i<size;i++)
            map.put((E)in.readObject(),PRESENT);

    }
}
