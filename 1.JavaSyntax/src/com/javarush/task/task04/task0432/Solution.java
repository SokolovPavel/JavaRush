package com.javarush.task.task04.task0432;



/* 
Хорошего много не бывает
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int i = scanner.nextInt();
        while (i-->0)
            System.out.println(line);
    }
}
