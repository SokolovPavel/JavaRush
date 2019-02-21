package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String allLinesFileName = scanner.nextLine();
        String forRemoveLinesFileName = scanner.nextLine();
        scanner.close();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(allLinesFileName));
            String line;
            while ((line = reader.readLine()) != null)allLines.add(line);
            reader.close();
        }
        catch (FileNotFoundException e){

        }
        catch (IOException e){

        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(forRemoveLinesFileName));
            String line;
            while ((line = reader.readLine()) != null)forRemoveLines.add(line);
            reader.close();
        }
        catch (FileNotFoundException e){

        }
        catch (IOException e){

        }
        Solution sol = new Solution();
        try{
            sol.joinData();
        }
        catch (CorruptedDataException e){

        }
    }

    public void joinData () throws CorruptedDataException {
        boolean found;
        for(int i=0; i<forRemoveLines.size(); i++) {
            found = false;
            for (int j = 0; j < allLines.size(); j++) {
                if (allLines.get(j).equals(forRemoveLines.get(i))) {
                    found = true;
                    allLines.remove(j);
                    break;
                }
            }
            if(found == false){
                allLines.clear();
                throw new CorruptedDataException();
            }
        }
    }
}
