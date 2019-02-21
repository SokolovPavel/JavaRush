package com.javarush.task.task38.task3804;

public class ExFactory {
    public static <T extends Enum<T>> Throwable getEx(T e){
        try {
            String message = e.name().charAt(0) + e.name().replaceAll("_", " ").substring(1).toLowerCase();
            if (e instanceof ExceptionApplicationMessage) return new Exception(message);
            else if (e instanceof ExceptionDBMessage) return new RuntimeException(message);
            else if (e instanceof ExceptionUserMessage) return new Error(message);
            else return new IllegalArgumentException();
        }
        catch (NullPointerException ee){
            return new IllegalArgumentException();
        }
    }
}
