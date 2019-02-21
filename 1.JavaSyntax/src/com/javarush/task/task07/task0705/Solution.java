package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int[] nums20 = new int[20];
        int[] nums10 = new int[10];
        int[] nums11 = new int[10];

        for (int i = 0; i < 20; i++)
            nums20[i] = scanner.nextInt();
        for (int i = 0; i < 10; i++)
            nums10[i] = nums20[i];
        for (int i = 0; i < 10; i++)
            nums11[i] = nums20[i+10];
        for (int i = 0; i < 10; i++)
            System.out.println(nums11[i]);
    }
}
