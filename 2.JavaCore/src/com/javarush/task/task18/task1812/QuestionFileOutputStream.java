package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream aos;
    public QuestionFileOutputStream(AmigoOutputStream aos){
        this.aos = aos;
    }
    public void flush() throws IOException{
        aos.flush();
    }

    public void write(int b) throws IOException{
        aos.write(b);
    }

    public void write(byte[] b) throws IOException{
        aos.write(b);
    }

    public void write(byte[] b, int off, int len) throws IOException{
        aos.write(b,off,len);
    }

    public void close() throws IOException{
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        if(reader.readLine().equals("Д")){
            aos.close();
        }
        reader.close();
    }

}

