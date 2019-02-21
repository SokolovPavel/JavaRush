package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
import java.util.Scanner;
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<10;i++)
        {
            list.add(scanner.nextLine());
        }
        int length = list.get(0).length();
        for(int i=1;i<10;i++){
            if(length>list.get(i).length()){
                System.out.println(i);
                break;
            }
            else length = list.get(i).length();
        }
    }
}

