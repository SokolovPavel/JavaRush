package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file1 = new BufferedReader(new FileReader(bufferedReader.readLine()));
        BufferedReader file2 = new BufferedReader(new FileReader(bufferedReader.readLine()));
        bufferedReader.close();

        String s1 = file1.readLine();
        String s2 = file2.readLine();
        String s3=file1.readLine(),s4=file2.readLine();
        boolean cycle=true;


        while(cycle){
            if(s1.equals(s2)){
                //System.out.println("1");
                    lines.add(new LineItem(Type.SAME, s1));
                    s1 = s3;
                    if (file1.ready())
                        s3 = file1.readLine();
                    else s3 = "";

                    s2 = s4;
                    if (file2.ready())
                        s4 = file2.readLine();
                    else s4 = "";
            }else if(s1.equals(s4)){
                //System.out.println("2");
                lines.add(new LineItem(Type.ADDED, s2));
                lines.add(new LineItem(Type.SAME,s1));
                s1 = s3;

                if(file1.ready())
                    s3 = file1.readLine();
                else s3 = "";

                if(file2.ready())
                    s2 = file2.readLine();
                else
                    s2 = "";
                if(file2.ready())
                    s4 = file2.readLine();
                else
                    s4 = "";
            }else if(s2.equals(s3)){
                //System.out.println("3");
                lines.add(new LineItem(Type.REMOVED, s1));
                lines.add(new LineItem(Type.SAME,s2));
                s2 = s4;

                if(file1.ready())
                    s1 = file1.readLine();
                else s1 = "";
                if(file1.ready())
                    s3 = file1.readLine();
                else s3 = "";

                if(file2.ready())
                    s4 = file2.readLine();
                else
                    s4 = "";
            }
            if((s1.length()==0) && (s2.length()==0)){
                //System.out.println("4");
                cycle = false;
            }else if(s1.length()==0) {
                //System.out.println("5");
                lines.add(new LineItem(Type.ADDED, s2));
                cycle = false;
            }else if(s2.length()==0) {
                //System.out.println("6");
                lines.add(new LineItem(Type.REMOVED, s1));
                cycle = false;
            }
        }
        file1.close();
        file2.close();
        for (LineItem i : lines)
            System.out.println(i.type.toString() + " " + i.line);

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
