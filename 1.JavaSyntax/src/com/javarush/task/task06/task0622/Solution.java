package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[5];
        for (int i = 0; i < 5; i++)
            nums[i] = scanner.nextInt();
        int c;
        for(int j=0;j<4;j++) {
            for (int i = j+1; i < 5; i++) {
                if(nums[j]>nums[i]) {
                    c=nums[j];
                    nums[j]=nums[i];
                    nums[i]=c;
                }
            }
        }
        //напишите тут ваш код
        for (int i = 0; i < 5; i++)
            System.out.println(nums[i]);
    }
}
