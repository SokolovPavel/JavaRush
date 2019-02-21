package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
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
        if(b>a){d=a;a=b;b=d;}
        if(c>b){d=b;b=c;c=d;}
        if(b>a){d=a;a=b;b=d;}

        System.out.println(a + " " + " " + b + " " + c);
    }
}
