package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;

    boolean minsizeFlag=false,maxsizeFlag=false;
    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
        minsizeFlag = true;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
        maxsizeFlag = true;
    }

    private List<Path> foundFiles = new LinkedList<>();

    public List<Path> getFoundFiles(){
        return foundFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String content = new String(Files.readAllBytes(file)); // размер файла: content.length
        boolean namePass = true;
        if(partOfName != null && !file.getFileName().toString().contains(partOfName))
            namePass = false;

        boolean contentPass = true;
        if(partOfContent != null && !content.contains(partOfContent))
            contentPass = false;

        boolean minSizePass = true;
        if(minsizeFlag && content.length()<minSize)
            minSizePass = false;

        boolean maxSizePass = true;
        if(maxsizeFlag && content.length()>maxSize)
            maxSizePass = false;
        if(namePass && minSizePass && contentPass && maxSizePass)
            foundFiles.add(file);
        return FileVisitResult.CONTINUE;//super.visitFile(file, attrs);
    }
}
