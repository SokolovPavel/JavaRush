package com.javarush.task.task31.task3109;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties props = new Properties();
        try {
            FileInputStream fin = new FileInputStream(fileName);
            int index = fileName.lastIndexOf(".");
            if((index>0)&&(fileName.substring(fileName.lastIndexOf("."),fileName.length()).equals(".xml")))
                props.loadFromXML(fin);
            else
                props.load(fin);
            //System.out.println(fileName.substring(fileName.lastIndexOf("."),fileName.length()));

        }catch (Exception e){

        }
        return props;
    }
}
