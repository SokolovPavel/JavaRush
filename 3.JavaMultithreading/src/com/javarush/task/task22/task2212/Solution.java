package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if(telNumber == null)return false;
        if(telNumber.matches("^\\+(.?[0-9].?){12}") || telNumber.matches("^[(](.?[0-9].?){10}") || telNumber.matches("^[0-9](.*[0-9].*){9}")){//1,2
            if(telNumber.matches("(.+[-].+){3,}"))return false;//3
            if(telNumber.matches(".+--.+"))return false;//3
            if(!telNumber.matches(".*[0-9]$"))return false;//7
            if( telNumber.matches(".+[^0-9,(,),-].+") )return false;//6
            if(telNumber.contains("(") && !telNumber.matches(".*(\\([0-9]{3}\\)){1}.*"))return false;//5
            if (telNumber.matches(".*-.*\\(")) return false;//4
            return true;
        }
        else return false;
    }

    public static boolean checkTelNumber2(String telNumber) {

         return true;
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("+380501234567"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("+38050123-45-67"));
        System.out.println(checkTelNumber("050123-4567"));
        System.out.println(checkTelNumber("+38)050(1234567"));
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println(checkTelNumber("050xxx4567"));
        System.out.println(checkTelNumber("050123456"));
        System.out.println(checkTelNumber("(0)501234567"));
        //System.out.println(checkTelNumber("(0)501234567xx"));
        //System.out.println(checkTelNumber("(0)50123--4567"));
    }
}
