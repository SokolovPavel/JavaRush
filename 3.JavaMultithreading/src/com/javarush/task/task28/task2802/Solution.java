package com.javarush.task.task28.task2802;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.NORM_PRIORITY;

/* 
Пишем свою ThreadFactory
*/
public class Solution {

    public static class AmigoThreadFactory implements ThreadFactory{
        public static AtomicInteger A = new AtomicInteger(0);
        public AtomicInteger B = new AtomicInteger(1);

        public AmigoThreadFactory() {
            A.incrementAndGet();
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setDaemon(false);
            thread.setPriority(NORM_PRIORITY);
            thread.setName(thread.getThreadGroup().getName()+ "-pool-" + A + "-thread-" + B);

            B.incrementAndGet();
            return thread;
        }
    }

    public static void main(String[] args) {
        class EmulateThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulateThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulateThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }
}
