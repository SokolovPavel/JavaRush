package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    //1	I	лат. unus, unum
    //5	V	лат. quinque
    //10	X	лат. decem
    //50	L	лат. quinquaginta
    //100	C	лат. centum
    //500	D	лат. quingenti
    //1000	M	лат. mille
    public static int romanToInteger(String s) {
        int result;
        char[] chars = s.toCharArray();
        int length = s.length();
        int temp=0;
        char prevChar;
        for (int i = 0; i < length; i++){
            switch (chars[i]){
                case 'I':
                    temp = 1;
            }
        }
        return 0;
    }
}
