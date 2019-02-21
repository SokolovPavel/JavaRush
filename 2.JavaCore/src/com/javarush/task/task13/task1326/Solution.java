package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;


public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        ArrayList<Integer> nums = new ArrayList<Integer>();
        BufferedReader fis;
        FileInputStream fis2;
        try{
            fis2 = new FileInputStream(s);
            fis = new BufferedReader (new InputStreamReader(fis2));
            String s2 = fis.readLine();
            int num;
            while(s2!=null && s2.length()>0) {
                num = Integer.parseInt(s2);
                if (num%2==0)nums.add(num);
                    s2 = fis.readLine();
            }

            fis2.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
        Collections.sort(nums);
        int j = nums.size();
        for(int i=0; i<j;i++)
            System.out.println(nums.get(i));
    }
}
