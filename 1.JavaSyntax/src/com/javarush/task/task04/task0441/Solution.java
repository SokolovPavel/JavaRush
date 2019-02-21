package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        if(a==b) System.out.println(a);
        else if (b==c) System.out.println(b);
        else if (a==c) System.out.println(c);
        else if( (a<b&&b<c) || (a>b&&b>c) ) System.out.println(b);
        else if((b<a&&a<c)||(b>a&&a>c)) System.out.println(a);
        else if((b<c&&c<a)||(b>c&&c>a)) System.out.println(c);
    }
}
