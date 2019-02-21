package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        try{
            String str = scanner.nextLine();
            Integer a = Integer.parseInt(str);
            if(a<=0)throw new NumberFormatException();
            str = scanner.nextLine();
            Integer b = Integer.parseInt(str);
            if(b<=0)throw new NumberFormatException();
            while (a!=0 && b!=0)
                if(a > b)
                    a = a % b;
                else
                    b = b % a;
                System.out.println(a+b);


        }
        catch (NumberFormatException e){
            System.out.println(e);
        }

    }
}
