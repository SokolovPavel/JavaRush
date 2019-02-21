package com.javarush.task.task33.task3310.strategy;

import com.sun.corba.se.impl.orbutil.ObjectWriter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.Files.createFile;

public class FileBucket {
    Path path;
    FileBucket next;
    public FileBucket() {
        try {
            path = Files.createTempFile("fileBucket-", null);
            Files.deleteIfExists(path);
            Files.createFile(path);
        }
        catch (IOException e){

        }
        path.toFile().deleteOnExit();
    }

    public long getFileSize(){
        try {
            return Files.size(path);
        }
        catch (Exception e){return 0;}

    }

    public void putEntry(Entry entry){
        try {

            OutputStream fos = Files.newOutputStream(path);
            ObjectOutputStream stream = new ObjectOutputStream(fos);
            stream.writeObject(entry);
            stream.close();
        }
        catch (FileNotFoundException e){}
        catch (IOException e){}

    }

    public Entry getEntry() {
        if (getFileSize()<=0L) return null;
        try {
            InputStream fin = Files.newInputStream(path);
            ObjectInputStream stream = new ObjectInputStream(fin);

            return (Entry) stream.readObject();
        } catch (Exception e) {

        }
        return null;
    }
    public void remove() {
        //path.toFile().delete();
        try {
            Files.delete(path);
        }
        catch (Exception e){}
    }
}

