package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);
    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString(){
        Dish[] dishes = Dish.values();
        StringBuilder result = new StringBuilder();
        for(int i=0;i<dishes.length;i++){
            result.append(dishes[i]);
            if((i+1)!= dishes.length)result.append(", ");
        }
        return result.toString();
    }
}
