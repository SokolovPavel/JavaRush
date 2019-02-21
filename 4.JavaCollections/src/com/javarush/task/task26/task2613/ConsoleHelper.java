package com.javarush.task.task26.task2613;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString(){
        try {
            return bis.readLine();
        }
        catch (Exception e){return "";}
    }
    public static Operation askOperation() {
        writeMessage("Введите код операции");
        while(true) {
            try {
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
            } catch (Exception e) {
                writeMessage("Повторите ввод");
            }
        }
    }

    public static String askCurrencyCode(){
        while(true){
            writeMessage("Введите код валюты: ***");
            String s = readString();
            if(s.length()==3){
                s = s.toUpperCase();
                return s;
            }
            else{
                writeMessage("Неверные данные. Повторите ввод");
            }
        }
    }

    public static String[] getValidTwoDigits(String currencyCode){
        while(true){
            writeMessage("Введите номинал купюр и их количество через пробел.");
            String[] s = readString().split(" ");
            if(s.length==2){
                try{
                    Integer.parseInt(s[0]);
                    Integer.parseInt(s[1]);
                    return s;
                }
                catch (Exception e){
                    writeMessage("Неверные данные. Повторите ввод");
                }
            }
            else{
                writeMessage("Неверные данные. Повторите ввод");
            }
        }
    }
}
