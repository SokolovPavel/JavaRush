package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int countSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }
        public int countSeconds = 3;
        public void run() {
            try{
                for (;countSeconds>0;) {
                    System.out.print(countSeconds + " ");
                    sleep(1000);
                    countSeconds-=1;
                }
                System.out.print("Марш!");
            }catch (InterruptedException e){
                System.out.print("Прервано!");
            }
            //add your code here - добавь код тут

        }
    }
}
