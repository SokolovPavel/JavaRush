package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }
    public static String readString() throws IOException {
            return reader.readLine();
    }
    public static List<Dish> getAllDishesForOrder() throws IOException{

        writeMessage(Dish.allDishesToString() + "Введите название блюда, exit, чтобы закончить заказ:");
        List<Dish> list = new LinkedList<>();
        String input = readString();
        while (!input.equals("exit")){
            try {
                list.add(Dish.valueOf(input));
            }
            catch (IllegalArgumentException e ){
                    ConsoleHelper.writeMessage(input + " is not detected");
            }
            input = readString();
        }
        return list;
    }
}
