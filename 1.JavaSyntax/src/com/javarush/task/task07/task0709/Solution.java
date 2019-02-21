package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        int min=0;
        for (int i = 0; i < 5; i++){

            list.add(scanner.nextLine());
            if(i==0)min = list.get(i).length();
            else if(list.get(i).length()<min)min = list.get(i).length();
        }
        for (int i = 0; i < 5; i++){
            if(min == list.get(i).length()) System.out.println(list.get(i));

        }
    }
}
