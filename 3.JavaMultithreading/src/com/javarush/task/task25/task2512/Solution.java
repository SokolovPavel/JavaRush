package com.javarush.task.task25.task2512;
import java.util.Iterator;
import java.util.LinkedList;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        LinkedList<Throwable> queue = new LinkedList<>();
        Throwable the = e;
        while(the!=null) {
            queue.add(the);
            the = the.getCause();
        }
        Iterator<Throwable> iter = queue.descendingIterator();
        while(iter.hasNext() ) {
            Throwable ee = iter.next();
            System.out.println(ee.getClass().getName() + ": " + ee.getMessage());
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        solution.uncaughtException(new Thread(),
                new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}
