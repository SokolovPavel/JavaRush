package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;
/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException{
        String path = args[0];
        String resultFileAbsolutePath = args[1];

        File result = new File(resultFileAbsolutePath);
        List<File> list = new LinkedList<File>();
        List<File> filesQuee = new LinkedList<>();
        File file = new File(path);
        //System.out.println(file.listFiles());
        //for(File f :file.listFiles())
        //    filesQuee.add(f);
        //for(File f : filesQuee){
        //    if(f.isDirectory())
        //        filesQuee.add(f);
        //    if((f.isFile())&&(file.length()<=50L)){
         //       list.add(file);
        //        System.out.println("Added");
        //    }
        //}

        Stack<File> stack = new Stack<>();
        stack.push(file);
        while(!stack.isEmpty()){
            File f = stack.pop();
            if (f.isDirectory()) {
                for (File fi : f.listFiles()) stack.push(fi);
            }
            else if (f.isFile()) {
                if (f.length() <= 50) {list.add(f);} //System.out.println("Added");}
            }
        }

        System.out.println(list.size());
        list.sort(Comparator.comparing(File::getName));
        File newResultFile = new File(result.getParent() + "\\allFilesContent.txt");
        FileUtils.renameFile(result,newResultFile);
        FileOutputStream fileOutputStream = new FileOutputStream(newResultFile, true);
        //BufferedWriter bufferedWriter = new BufferedWriter(new FilfileOutputStream);
        FileWriter writer = new FileWriter(newResultFile);
        for(File f : list){
            FileReader reader = new FileReader(f);
            char[] buffer = new char[50];
            int count = reader.read(buffer);
            writer.write(buffer,0,count);
            //String s = "\n".to;
            writer.write("\n");
            reader.close();
        }
        fileOutputStream.close();
    }
}
