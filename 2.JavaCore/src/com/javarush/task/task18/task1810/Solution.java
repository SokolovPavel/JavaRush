package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            try {
                FileInputStream is = new FileInputStream(reader.readLine());
                if (is.available() < 1000) {
                    is.close();
                    throw new DownloadException();
                }
                is.close();
            } catch (IOException e) {
            }
        }


    }

    public static class DownloadException extends Exception {



    }
}
