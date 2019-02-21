package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader file = new BufferedReader(new FileReader(args[0]));
        //BufferedReader file = new BufferedReader(new FileReader("C://PDF//1"));
        while(file.ready()){
            String[] data = file.readLine().split(" ");

            int day   = Integer.parseInt(data[data.length - 3]);
            int month = Integer.parseInt(data[data.length - 2]) - 1;
            int year  = Integer.parseInt(data[data.length - 1]) - 1900;
            Date bday = new Date(year,month,day);
            //Date bday = objSDF.parse( day + " " + month + " " + year);
            String name="";
            for(int i=0; i<=data.length-4; i++) {
                name += data[i];
                if(i!=(data.length-4))name += " ";
            }
            PEOPLE.add(new Person(name,bday));
        }
        //for(Person p : PEOPLE)System.out.println(p.getName() + "-" + p.getBirthday());
        file.close();
    }
}
