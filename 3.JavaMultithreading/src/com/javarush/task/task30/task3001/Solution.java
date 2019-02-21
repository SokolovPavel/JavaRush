package com.javarush.task.task30.task3001;

import java.math.BigInteger;

/*
Конвертер систем счислений
*/
public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumberSystemType._10, "6");
        Number result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumberSystemType._16, "6df");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._8);
        System.out.println(result);    //expected 3337

        number = new Number(NumberSystemType._16, "abcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);    //expected abcdefabcdef
    }

    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) {
        BigInteger bigInteger = new BigInteger(number.getDigit(), number.getNumberSystem().getNumberSystemIntValue());
        String str = bigInteger.toString(expectedNumberSystem.getNumberSystemIntValue());
        return new Number(expectedNumberSystem, str);

/*

        int base = number.getNumberSystem().getNumberSystemIntValue();
        String digit = number.getDigit();
        if(digit.contains("-") || digit.contains("."))throw new NumberFormatException();
        if(base<16 &&( digit.contains("c") || digit.contains("d") || digit.contains("e") || digit.contains("f") ) )throw new NumberFormatException();
        if(base<12 &&( digit.contains("a") || digit.contains("b")))throw new NumberFormatException();
        if(base<10 && digit.contains("9"))throw new NumberFormatException();
        if(base<9 && digit.contains("8"))throw new NumberFormatException();
        if(base<8 && digit.contains("7"))throw new NumberFormatException();
        if(base<7 && digit.contains("6"))throw new NumberFormatException();
        if(base<6 && digit.contains("5"))throw new NumberFormatException();
        if(base<5 && digit.contains("4"))throw new NumberFormatException();
        if(base<4 && digit.contains("3"))throw new NumberFormatException();
        if(base<3 && digit.contains("2"))throw new NumberFormatException();
        char[] array = number.getDigit().toCharArray();
        long result = 0L;
        long baseInPower = 1;

        for(int i= array.length-1;i>=0;i--){
            switch (array[i]){
                case '0' : break;
                case '1' : result +=     baseInPower; break;
                case '2' : result += 2 * baseInPower; break;
                case '3' : result += 3 * baseInPower; break;
                case '4' : result += 4 * baseInPower; break;
                case '5' : result += 5 * baseInPower; break;
                case '6' : result += 6 * baseInPower; break;
                case '7' : result += 7 * baseInPower; break;
                case '8' : result += 8 * baseInPower; break;
                case '9' : result += 9 * baseInPower; break;
                case 'a' : result += 10 * baseInPower; break;
                case 'b' : result += 11 * baseInPower; break;
                case 'c' : result += 12 * baseInPower; break;
                case 'd' : result += 13 * baseInPower; break;
                case 'e' : result += 14 * baseInPower; break;
                case 'f' : result += 15 * baseInPower; break;
            }
            baseInPower *= base;
        }
        StringBuilder builder = new StringBuilder();
        int expectedBase = expectedNumberSystem.getNumberSystemIntValue();
        int ostatok;
        while(result>0){
            ostatok = (int)(result % expectedBase);
            if(ostatok<10)builder.append(ostatok);
            else{
                switch (ostatok){
                    case 10: builder.append('a'); break;
                    case 11: builder.append('b'); break;
                    case 12: builder.append('c'); break;
                    case 13: builder.append('d'); break;
                    case 14: builder.append('e'); break;
                    case 15: builder.append('f'); break;
                }
            }
            result /= expectedBase;
        }
        builder.reverse();
        //напишите тут ваш код
        return new Number(expectedNumberSystem, builder.toString());
        */
    }
}
