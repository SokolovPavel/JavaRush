package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String dirName = bufferedReader.readLine();
        bufferedReader.close();
        Path path = Paths.get(dirName);
        //Path path = Paths.get(dirName);
        if (!Files.isDirectory(path)){
            System.out.println(dirName + " - не папка");
        return;
    }

        fileSearcher fileVisitor = new fileSearcher();
        Files.walkFileTree(path, fileVisitor);
        System.out.println("Всего папок - " + (fileVisitor.folderCount - 1));
        System.out.println("Всего файлов - " + fileVisitor.fileCount);
        System.out.println("Общий размер - " + fileVisitor.fullSize);
    }


}
