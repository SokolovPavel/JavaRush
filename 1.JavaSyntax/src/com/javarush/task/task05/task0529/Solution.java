package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/
import java.util.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        while (true)
        {
            String s = scanner.nextLine();
            if (s.equals("сумма"))
                break;
            int num = Integer.parseInt(s);
            sum += num;
        }
        System.out.println(sum);
    }
}
