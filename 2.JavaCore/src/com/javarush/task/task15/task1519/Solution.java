package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        Double d;
        while (true) {
            String s = scanner.nextLine();
            if (s.equals("exit")) break;
            else list.add(s);
        }
        for (String s : list) {
            if (s.contains(".")) {
                d = Double.parseDouble(s);
                if (d != null) print(d);
            }
            else
                try {
                    int a;
                    a = Integer.parseInt(s);
                    if (a < 1 || a > 127) print(a);
                    else print((short) a);
                }
                catch(Exception e)
                {
                    print(s);
                }
        }

    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
