package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        String sNum = scanner.nextLine();
        int nNum = Integer.parseInt(sNum);
        if(nNum>=0) System.out.println(nNum*2);
        else System.out.println(nNum+1);

    }

}