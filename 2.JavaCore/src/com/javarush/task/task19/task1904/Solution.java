package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;
        public PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner = fileScanner;
        }
        public Person read() throws IOException{
            String[] data = fileScanner.nextLine().split(" ");
            String middleName = data[2];
            String firstName = data[1];
            String lastName = data[0];
            Date birthDate = new Date();
            birthDate.setDate(Integer.parseInt(data[3]));
            birthDate.setMonth(Integer.parseInt(data[4])-1);
            birthDate.setYear(Integer.parseInt(data[5])-1900);
            return new Person(firstName,middleName,lastName,birthDate);
        }

        public void close() throws IOException{
            fileScanner.close();
        }

    }
}
