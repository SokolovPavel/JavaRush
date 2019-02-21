package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        ArrayList<Person> arr = new ArrayList<>();
        //тут цикл по чтению ключей, пункт 1
        while(true){
            String s = reader.readLine();
            if(s.equals("user"))arr.add(new Person.User());
            else if(s.equals("loser"))arr.add(new Person.Loser());
            else if(s.equals("coder"))arr.add(new Person.Coder());
            else if(s.equals("proger"))arr.add(new Person.Proger());
            else break;
        }
        {
            //создаем объект, пункт 2
            for(Person p:arr){
                doWork(p);
            }

        }
    }

    public static void doWork(Person person) {
        // пункт 3
        if (person instanceof Person.User)((Person.User)person).live();
        else if(person instanceof Person.Loser)((Person.Loser)person).doNothing();
        else if(person instanceof Person.Coder)((Person.Coder)person).coding();
        else if(person instanceof Person.Proger)((Person.Proger)person).enjoy();
    }
}
