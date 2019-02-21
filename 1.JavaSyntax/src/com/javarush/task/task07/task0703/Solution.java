package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/
import java.util.Scanner;
public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[10];
        String[] strings = new String[10];
        for (int i = 0; i < 10; i++){
            strings[i] = scanner.nextLine();
            nums[i] = strings[i].length();
        }
        for (int i = 0; i < 10; i++)
            System.out.println(nums[i]);
    }
}
