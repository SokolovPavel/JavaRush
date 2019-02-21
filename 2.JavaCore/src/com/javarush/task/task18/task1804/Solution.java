package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(br.readLine());
        int a = inputStream.available();
        int min;
        int nums[] = new int[256];
        for(int i = 1; i<a;i++){

            nums[inputStream.read()]++;
        }
        int index=0;
        for(int i = 1 ; i<256; i++) {
            //System.out.println(nums[i] + " ");
            if ((nums[index] == 0) && (nums[i] > 0))
                index = i;
            if ((nums[i] < nums[index])&&(nums[i]>0))
                index = i;
        }
        for(int i = 0 ; i<256; i++)
            if((nums[index] == nums[i])&&(nums[i]>0))System.out.print(i + " ");
        inputStream.close();
    }
}
