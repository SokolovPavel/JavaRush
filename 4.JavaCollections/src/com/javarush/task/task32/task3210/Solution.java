package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException{
        RandomAccessFile raf = new RandomAccessFile(args[0],"r");
        byte[] buffer = new byte[args[2].length()];
        raf.seek(Integer.parseInt(args[1]));
        raf.read(buffer,0,args[2].length());
        String result = new String(buffer);
        raf.seek(raf.length());
        if(args[2].equals(result))raf.write("true".getBytes()); else raf.write("false".getBytes());
    }
}
