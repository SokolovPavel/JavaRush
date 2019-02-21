package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //Date d = new Date();
        Date d = df.parse(s);
        df.applyPattern("MMM d, yyyy");
        System.out.println(df.format((d)).toUpperCase());
    }
}
