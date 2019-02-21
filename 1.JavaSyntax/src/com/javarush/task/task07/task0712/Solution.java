package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        int min=0,max=0;
        for (int i = 0; i < 10; i++){
            list.add(scanner.nextLine());
            if(i==0){
                min = list.get(i).length();
                max = list.get(i).length();
            }
            else if(list.get(i).length()<min)min = list.get(i).length();
            else if(list.get(i).length()>max)max = list.get(i).length();
        }
        for (int i = 0; i < 10; i++){
            if((min == list.get(i).length()) || (max == list.get(i).length())){
                System.out.println(list.get(i));
                break;
            }

        }
    }
}
