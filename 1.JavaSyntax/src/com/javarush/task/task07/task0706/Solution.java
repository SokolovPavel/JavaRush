package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/
import java.util.Scanner;
public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] nums = new int[15];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 15; i++)
            nums[i] = scanner.nextInt();
        int sum1=0,sum2=0;
        for (int i = 0; i < 7; i++) {
            sum1 += nums[2 * i];
            sum2 +=nums[2*i+1];
        }
        sum1+=nums[14];
        if(sum1<sum2) System.out.println("В домах с нечетными номерами проживает больше жителей.");
        else System.out.println("В домах с четными номерами проживает больше жителей.");
    }
}
