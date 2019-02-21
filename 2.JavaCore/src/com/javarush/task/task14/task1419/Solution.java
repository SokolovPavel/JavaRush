package com.javarush.task.task14.task1419;


import javax.print.PrintException;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            //exceptions.add(e);
        }
        exceptions.add(new EOFException());
        exceptions.add(new IOException());
        exceptions.add(new ClassNotFoundException());
        exceptions.add(new RuntimeException());
        exceptions.add(new UnsupportedOperationException());
        exceptions.add(new EmptyStackException());
        exceptions.add(new IllegalArgumentException());
        exceptions.add(new PrintException());
        exceptions.add(new NullPointerException());
        exceptions.add(new NumberFormatException());

        //напишите тут ваш код

    }
}
