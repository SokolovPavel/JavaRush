package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        try{
        for(int i=2;i<37;i++){
            try{
                new BigInteger(args[0],i);
                System.out.println(i);
                return;
            }
            catch (NumberFormatException e) {

            }
        }
        throw new IllegalArgumentException();}
        catch (Exception e){System.out.println("incorrect");}
    }
}