package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

import java.lang.reflect.Field;

public class Solution {
    public static void main(String[] args) {
        System.out.println(printFullyQualifiedNames(Solution.class));
        System.out.println(printFullyQualifiedNames(SomeTest.class));

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        PrepareMyTest mTest = (PrepareMyTest)c.getAnnotation(PrepareMyTest.class);
        if(mTest != null){
            for(int i=0;i<mTest.fullyQualifiedNames().length;i++)
                System.out.println(mTest.fullyQualifiedNames()[i]);
            return true;
        }
        return false;
    }

    public static boolean printValues(Class c) {
        PrepareMyTest mTest = (PrepareMyTest)c.getAnnotation(PrepareMyTest.class);
        if(mTest != null){
            for(int i=0;i<mTest.value().length;i++)
                System.out.println(mTest.value()[i].getSimpleName());
            return true;
        }
        return false;
    }
}
