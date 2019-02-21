package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        ArrayList<String> params = new ArrayList<>();
        String URL = new Scanner(System.in).nextLine();
        String sign = "?";
        int start=-1;
        int end=0;
        int end2=0;
        String s,p;
        while(true) {
            if(start < (URL.length() - 1)) {
                start = URL.indexOf(sign, start + 1);
                if (start == -1) break;
                sign = "&";
                end = URL.indexOf("=", start + 1);
                end2 = URL.indexOf("&", start + 1);
                if(end == -1 && end2 == -1) {
                    if (end == -1) end = URL.length() - 1;
                }else if(end != -1 && end2 != -1 && end2<end)end = end2;
                else if(end == -1)end = end2;
                s = URL.substring(start + 1, end);
                System.out.print(s + " ");
                if(s.equals("obj")){
                    start = end;
                    end = URL.indexOf("=", start + 1);
                    end2 = URL.indexOf("&", start + 1);
                    if(end == -1 && end2 == -1) {
                        if (end == -1) end = URL.length() - 1;
                    }else if(end != -1 && end2 != -1 && end2<end)end = end2;
                    else if(end == -1)end = end2;
                    params.add(URL.substring(start + 1, end));
                }
            }
            else
            {
                break;
            }

        }
        System.out.print("\n");
        for(String o : params) {
            try {
                alert(Double.parseDouble(o));
            }
            catch (Exception e)
            {
                alert(o);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
