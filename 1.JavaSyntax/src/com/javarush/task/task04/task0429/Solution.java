package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
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
        int n=0,m=0;
        if(a>0)n++;
        if(b>0)n++;
        if(c>0)n++;
        if(a<0)m++;
        if(b<0)m++;
        if(c<0)m++;
        System.out.println("количество отрицательных чисел: " + m);
        System.out.println("количество положительных чисел: " + n);
    }
}
