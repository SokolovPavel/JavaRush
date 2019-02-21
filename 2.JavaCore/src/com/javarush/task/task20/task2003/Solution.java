package com.javarush.task.task20.task2003;

//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* 
Знакомство с properties
*/
public class Solution {

    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception{
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());
        load(file);
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties props = new Properties();
        //for(Map.Entry s : properties.entrySet()){
            props.putAll(properties);
            props.store(outputStream,"hello");
        //}
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties props = new Properties();
        props.load(inputStream);
        Set<String> set = props.stringPropertyNames();
        for(String s : set){
            properties.put(s,props.getProperty(s));
        }
    }

    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.load(new FileInputStream("C://PDF//1"));
        System.out.println(props.getProperty("line"));
    }
}
