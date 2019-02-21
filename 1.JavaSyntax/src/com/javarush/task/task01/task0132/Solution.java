package com.javarush.task.task01.task0132;
import java.util.Scanner;
/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {

        int nNum = number;
        int a = nNum/100;
        nNum = nNum - 100*a;
        int b = nNum/10;
        int c = nNum%10;
        return a+b+c;
    }
}