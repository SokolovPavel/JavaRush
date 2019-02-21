package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int count=0;
        for(int y=0;y<a.length;y++)
            for(int x=0; x<a[0].length;x++){
                if (a[y][x]==1){
                    count++;
                    int x1=0,y1=0;
                    while(a[y+y1][x+x1]==1) {

                        while (a[y + y1][x + x1] == 1) {
                            a[y + y1][x + x1] = 0;
                            if ((x + x1 + 1) < a.length) x1++;
                            else break;
                        }
                        x1=0;
                        if ((y + y1 + 1) < a.length) y1++;
                        else break;
                    }


                }
            }
        return count;
    }
}
