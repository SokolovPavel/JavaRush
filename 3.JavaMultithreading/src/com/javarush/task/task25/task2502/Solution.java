package com.javarush.task.task25.task2502;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here
            String[] ss = loadWheelNamesFromDB();
            wheels = new LinkedList<>();
            if(ss == null || ss.length == 0 || ss.length!=4)throw new IllegalArgumentException();
                for (String s : ss)
                    wheels.add(Wheel.valueOf(s));
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
    }
}
