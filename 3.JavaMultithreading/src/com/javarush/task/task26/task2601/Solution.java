package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static Integer[] sort(Integer[] array) {


        Integer[] result = array.clone();
        Arrays.sort(result);
        int med =  result.length % 2 != 0 ? result[result.length/2] : (result[result.length/2 - 1] + result[result.length/2 ]) / 2;
        Arrays.sort(result,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return  Math.abs(o1-med) - Math.abs(o2-med);
            }
        });
        return result;
    }
}
