package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
import java.util.Scanner;
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<Integer> nums = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++)
            nums.add(scanner.nextInt());
        int num=nums.get(0);
        int count=1,maxCount=1;
        for (int i = 1; i < 10; i++){
            if(nums.get(i)==num)count++;
            else {
                num = nums.get(i);
                if(maxCount<count)maxCount = count;
                count = 1;
            }
        }
        if(maxCount<count)maxCount = count;
        System.out.println(maxCount);
    }
}