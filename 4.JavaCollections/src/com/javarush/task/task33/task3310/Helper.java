package com.javarush.task.task33.task3310;


import java.security.SecureRandom;
import java.math.BigInteger;
import java.util.Random;

public class Helper {
    public static String generateRandomString(){
        return new BigInteger(130, new SecureRandom()).toString(36);

    }
    public static void printMessage(String message){
        System.out.print(message);
    }
}
