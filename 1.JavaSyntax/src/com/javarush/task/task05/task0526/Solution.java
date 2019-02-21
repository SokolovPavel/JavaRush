package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Man man1 = new Man("ff",10,"fdd");
        Man man2 = new Man("f4f",10,"fdd");
        Woman woman1 = new Woman("f666f",11,"fdd");
        Woman woman2 = new Woman("ff",13,"f88d");
        man1.print();
        man2.print();
        woman1.print();
        woman2.print();
    }

    //напишите тут ваш код
    public static class Man{
        String name;
        int age;
        String address;
        public Man(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }
        public void print(){
            System.out.println(name + " " + age + " " + address);
        }
    }

    public static class Woman{
        String name;
        int age;
        String address;
        public Woman(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public void print(){
            System.out.println(name + " " + age + " " + address);
        }
    }
}
