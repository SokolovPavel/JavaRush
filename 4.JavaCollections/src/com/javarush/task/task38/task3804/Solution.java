package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

public class Solution {
    public static Class getFactoryClass() {
        return ExFactory.class;
    }

    public static void main(String[] args) {
        ExFactory factory = new ExFactory();
        System.out.println(factory.getEx(ExceptionDBMessage.NOT_ENOUGH_CONNECTIONS));
    }
}