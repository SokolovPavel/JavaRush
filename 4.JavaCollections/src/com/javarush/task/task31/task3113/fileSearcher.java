package com.javarush.task.task31.task3113;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class fileSearcher extends SimpleFileVisitor<Path> {
    public int folderCount=0,fileCount=0;
    public long fullSize=0;


    @Override public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException{
        if(Files.isDirectory(dir))folderCount++;
        return FileVisitResult.CONTINUE;
    }
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {


        if(Files.isRegularFile(file)){
            fileCount++;
            String content = new String(Files.readAllBytes(file)); // размер файла: content.length
            fullSize += content.length();
        }

        return FileVisitResult.CONTINUE;//super.visitFile(file, attrs);
    }
}

