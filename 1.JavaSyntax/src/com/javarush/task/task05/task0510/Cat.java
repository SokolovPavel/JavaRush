package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    //напишите тут ваш код
    String name;
    int weight, age;
    String address;
    String color;
    public static void main(String[] args) {

    }
    public void initialize(String name){
        this.name = name;
        weight = 1;
        age =1;
        color = "";
    }
    public void initialize(String name, int weight, int age){
        this.name = name;
        this.weight = weight;
        this.age = age;
        color = "";
    }

    public void initialize(String name, int age){
        this.name = name;
        this.weight = 1;
        this.age = age;
        color = "";
    }
    public void initialize(int weight, String color){
        this.weight = weight;
        this.age = 1;
        this.color = color;
    }
    public void initialize(int weight, String color,String address){
        this.weight = weight;
        this.age = 1;
        this.address = address;
        this.color = color;
    }
}
