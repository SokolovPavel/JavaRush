package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/
import java.util.Scanner;
public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        //1)
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list10 = new ArrayList<Integer>();
        //2)
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 20; i++)
            list.add(scanner.nextInt());

        for(Integer i: list){
            if(i%3==0)list3.add(i);
            if(i%2==0)list2.add(i);
            if(i%3!=0 && i%2!=0)list10.add(i);
        }

        printList(list3);
        printList(list2);
        printList(list10);

    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for(Integer i: list)
            System.out.println(i);
    }
}
