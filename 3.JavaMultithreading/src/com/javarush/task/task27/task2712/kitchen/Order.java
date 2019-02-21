package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;

    public Tablet getTablet() {
        return tablet;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        //Your order: [Juice, Fish] of Tablet{number=5}
        if(dishes.size()==0)return "";
        StringBuilder builder = new StringBuilder("Your order: [");
        for(Dish dish : dishes)
            builder.append(dish.name() + ",");
        builder.deleteCharAt(builder.length()-1);
        builder.append("] of " + tablet.toString());
        return builder.toString();
    }
    public int getTotalCookingTime(){
        int cookingTime=0;
        for(Dish dish : dishes)
            cookingTime += dish.getDuration();
        return cookingTime;
    }
    public boolean isEmpty(){
        return dishes.isEmpty();
    }
}
