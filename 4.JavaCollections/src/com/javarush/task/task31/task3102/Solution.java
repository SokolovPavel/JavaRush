package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File file = new File(root);
        List<String> result = new LinkedList<String>();
        Stack<File> stack = new Stack<>();
        stack.push(file);
        while(!stack.isEmpty()){
            File f = stack.pop();
            if (f.isDirectory()) {
                for (File fi : f.listFiles()) stack.push(fi);
            }
            else if (f.isFile()) {
                result.add(f.getAbsolutePath()); //System.out.println("Added");}
            }
        }
        return result;

    }

    public static void main(String[] args) {
        
    }
}
