package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d;
        //a b c
        if(b==a){
            System.out.println("3");
        }
        if(c==a){
            System.out.println("2");
        }
        if(c==b){
            System.out.println("1");
        }

    }
}
