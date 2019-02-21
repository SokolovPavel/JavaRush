package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
*/

public class Solution {
    static int count = 15;
    static volatile Integer countCreatedThreads = 0;

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread{
        public GenerateThread(){
            super((countCreatedThreads++).toString());
            start();
        }
        public void run(){
            if(countCreatedThreads<=16)System.out.println(new GenerateThread());
        }
        @Override
        public String toString() {
            return Thread.currentThread().getName() + " created";
        }
    }
}
