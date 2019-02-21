package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    //напишите тут ваш код
    String name;
    int weight, age;
    String address;
    String color;
    public static void main(String[] args) {

    }
    public Cat(String name){
        this.name = name;
        weight = 1;
        age =1;
        color = "red";
    }
    public Cat(String name, int weight, int age){
        this.name = name;
        this.weight = weight;
        this.age = age;
        color = "";
    }

    public Cat(String name, int age){
        this.name = name;
        this.weight = 1;
        this.age = age;
        color = "";
    }
    public Cat(int weight, String color){
        this.weight = weight;
        this.age = 1;
        this.color = color;
    }
    public Cat(int weight, String color,String address){
        this.weight = weight;
        this.age = 1;
        this.address = address;
        this.color = color;
    }
}
