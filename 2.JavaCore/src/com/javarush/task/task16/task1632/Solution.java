package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static{
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }
    public static void main(String[] args) {
    }
    public static class Thread1 extends Thread{
        public void run(){
            while(true){

            }
        }
    }
    public static class Thread2 extends Thread{
        public void run(){
            try{
                while (true)
                    sleep(1000);
            }
            catch (InterruptedException e){
                System.out.println("InterruptedException");
            }
        }

    }
    public static class Thread3 extends Thread {
        public void run() {
            try {
                while(true) {
                    System.out.println("Ура");
                    sleep(500);
                }
            } catch (InterruptedException e){

            }
        }

    }
    public static class Thread4 extends Thread implements Message{
        public void run(){
            while(!isInterrupted()){}
        }
        public void showWarning(){
            this.interrupt();
        }
    }
    public static class Thread5 extends Thread{
        public void run(){
            int sum =0;
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            if(!s.equals("N"))
                sum = Integer.parseInt(s);

            while(true){
                s = scanner.nextLine();
                if(s.equals("N"))
                    break;
                else{
                    sum += Integer.parseInt(s);
                }
            }
            System.out.println(sum);
        }

    }
}