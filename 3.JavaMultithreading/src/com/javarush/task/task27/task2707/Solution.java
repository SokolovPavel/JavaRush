package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {

        synchronized (o1) {
            Thread.sleep(1);
            Thread thread1 = new Thread(new Runnable() {
                public void run() {
                    solution.someMethodWithSynchronizedBlocks(o1, o2);
                }
            });
            Thread thread2 = new Thread(new Runnable() {
                public void run() {
                    synchronized (o2){
                        try {
                            Thread.sleep(1000);
                        }
                        catch (InterruptedException e){}
                    }
                }
            });
            thread1.start();
            Thread.sleep(1);
            thread2.start();
            Thread.sleep(40);
            System.out.println(thread1.getState());
            System.out.println(thread2.getState());

            //1)
            if(thread2.getState() == Thread.State.TIMED_WAITING)return true;
            else return false;

            /*
            //2)
            if(thread2.getState() == Thread.State.BLOCKED)return false;
            else return true;
            */

        }

    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}
