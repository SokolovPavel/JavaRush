package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException{
        if(string == null)throw new TooShortStringException();
        int index = string.indexOf("\t");
        if(index < 0)throw new TooShortStringException();
        index = string.indexOf("\t",index + 1);
        if(index < 0)throw new TooShortStringException();
        return string.substring(string.indexOf("\t")+1, index);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\t-JavaRush - лучший сервис -\tобучения Java\t."));
    }
}
