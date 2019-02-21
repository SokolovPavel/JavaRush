package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    private int size=0;
    public int size(){
        return size;
    }
    public String get(int index){throw new UnsupportedOperationException();}
    public String set(int index, String element){throw new UnsupportedOperationException();}
    public void add(int index, String element){throw new UnsupportedOperationException();}
    public String remove(int index){throw new UnsupportedOperationException();}
    public List<String> subList(int fromIndex, int toIndex){throw new UnsupportedOperationException();}
    protected void removeRange(int fromIndex, int toIndex){throw new UnsupportedOperationException();}
    public boolean addAll(int index, Collection c){throw new UnsupportedOperationException();}

    Entry<String> root;

    CustomTree(){
        root = new Entry<String>("root");
    }
    @Override
    public boolean add(String elementName){
        return checkPlaceToAdd(root,elementName)!=null;
    }

    public String getParent(String s){
        return walkTree(root,s);
    }
    private String walkTree(Entry<String> entry, String parentName){
        if(parentName.equals(entry.elementName) && entry.leftChild!=null)return entry.leftChild.elementName;
        if((entry.parent != null) && (parentName.equals(entry.parent.elementName)))return entry.elementName;
        if(entry.leftChild != null) {
            String result = walkTree(entry.leftChild, parentName);
            if (result != null) return result;
        }
        if (entry.rightChild != null) {
            String result = walkTree(entry.rightChild, parentName);
            if (result != null) return result;
        }
        return null;
    }

    private Entry<String> checkPlaceToAdd(Entry<String> entry,String elementName){

        if(!entry.availableToAddLeftChildren && entry.availableToAddRightChildren){
            Entry<String> e = new Entry<>(elementName);
            entry.rightChild = e;
            entry.checkChildren();
            e.parent = entry;
            size++;
            System.out.println("added " + e.elementName + " to " + entry.elementName);
            return e;
        }
        if(entry.availableToAddLeftChildren){
            Entry<String> e = new Entry<>(elementName);
            entry.leftChild = e;
            entry.checkChildren();
            e.parent = entry;
            size++;
            System.out.println("added " + e.elementName + " to " + entry.elementName);
            return e;
        }

        if(!entry.availableToAddLeftChildren && !entry.availableToAddRightChildren){
            return checkPlaceToAdd(entry.leftChild,elementName);
        }
        return null;

    }

    static class Entry<T> implements Serializable{
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        Entry(String elementName){
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }
        void checkChildren(){
            if(leftChild != null)availableToAddLeftChildren = false;
            if(rightChild != null)availableToAddRightChildren = false;
        }
        boolean isAvailableToAddChildren(){
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }

}
