package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int Num = Integer.parseInt(scanner.nextLine());
        if( ((Num%4)==0) && (((Num%100)!=0)||((Num%400)==0)) ) System.out.println("количество дней в году: 366");
        else System.out.println("количество дней в году: 365");
}
}