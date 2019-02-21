package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable{
    public static void main(String[] args) {
        System.out.println(new Solution(4));
        File file = new File("C://PDF//3");
        InputStream in;
        OutputStream out;
        try {
            in = new FileInputStream(file);
            out = new FileOutputStream(file);
            ObjectOutputStream objout = new ObjectOutputStream(out);
            ObjectInputStream objin = new ObjectInputStream(in);
            Solution savedObject = new Solution(-2);
            objout.writeObject(savedObject);
            System.out.println(" ");
            Solution loadedObject = (Solution)objin.readObject();
            System.out.println(savedObject.string.equals(loadedObject.string));
        }
        catch (IOException e){
            System.out.println(e);
        }
        catch (ClassNotFoundException e){
            System.out.println(e);
        }

    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
