package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandFName = reader.readLine();
        Cat catGrandF = new Cat(grandFName);

        String grandMName = reader.readLine();
        Cat catGrandM = new Cat(grandMName);

        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName,null,catGrandF);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName,catGrandM,null);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catMother,catFather);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catMother,catFather);

        System.out.println(catGrandF);
        System.out.println(catGrandM);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat parent_m,parent_f;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat parent_m, Cat parent_f) {
            this.name = name;
            this.parent_f = parent_f;
            this.parent_m = parent_m;

        }

        @Override
        public String toString() {
            String s = "The cat's name is " + name;
            if (parent_m == null)
                s += ", no mother ";
            else
                s +=", mother is " + parent_m.name;
            if (parent_f == null)
                s += ", no father";
            else
                s +=", father is " + parent_f.name;
            return s;
        }
    }

}
