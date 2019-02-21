package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        float average=0;
        int count=0;
        while (true)
        {
            int a = scanner.nextInt();

            if (a == -1)
                break;
            average = ((average*count)+a)/(count+1);
            count++;
        }
        System.out.println(average);
    }
}

