package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        float num = scanner.nextFloat();
        num = num % 5;
        if((num>=0)&&(num<3) ) System.out.println("зелёный");
        else if(num<4) System.out.println("желтый");
        else System.out.println("красный");
    }
}