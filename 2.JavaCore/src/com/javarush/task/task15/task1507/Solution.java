package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
    public static void printMatrix(int m, int n, Integer value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
public static void printMatrix(int m, int n, Short value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
public static void printMatrix(int m, int n, double value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
public static void printMatrix(int m, int n, int value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
public static void printMatrix(int m, int n, float value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
public static void printMatrix(int m, int n, ArrayList value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
public static void printMatrix(int m, int n, HashMap value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
public static void printMatrix(int m, int n, Time value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
}
