package com.javarush.task.task05.task0532;

import java.io.*;
import java.util.Scanner;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = 0;
        int N,cN;
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        maximum = scanner.nextInt();
        for(int x=1 ; x<N; x++){
            cN = scanner.nextInt();
            if(cN>maximum)maximum = cN;
        }

        //напишите тут ваш код

        System.out.println(maximum);
    }
}
