package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human grandF1 = new Human("s",true,80);
        Human grandF2 = new Human("s",true,70);

        Human grandM1 = new Human("g",false,15);
        Human grandM2 = new Human("g",false,90);

        Human father = new Human("g",true,10,grandF1,grandM1);
        Human mother = new Human("g",false,20,grandF2,grandM2);

        Human son1 = new Human("ggg",false,10,father,mother);
        Human son2 = new Human("ggg",false,20,father,mother);
        Human son3 = new Human("ggg",false,17,father,mother);

        System.out.println(grandF1);
        System.out.println(grandF2);
        System.out.println(grandM1);
        System.out.println(grandM2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(son1);
        System.out.println(son2);
        System.out.println(son3);
    }

    public static class Human {
        //напишите тут ваш код
        public String name;
        public boolean sex;
        public int age;
        public Human father,mother;

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father!=null?father:null;
            this.mother = mother!=null?mother:null;
        }
    }
}






















