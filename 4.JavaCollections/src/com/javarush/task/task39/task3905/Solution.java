package com.javarush.task.task39.task3905;

/* 
Залей меня полностью
*/

public class Solution {
    public static void main(String[] args) {
        Color[][] image = { {Color.RED, Color.BLUE,Color.BLUE,Color.BLUE,Color.BLUE,Color.BLUE,Color.RED,Color.RED},
                            {Color.RED, Color.RED, Color.BLUE,Color.BLUE,Color.BLUE,Color.RED, Color.RED, Color.BLUE},
                            {Color.BLUE,Color.RED, Color.RED, Color.BLUE,Color.RED, Color.RED, Color.BLUE,Color.BLUE},
                            {Color.BLUE,Color.BLUE,Color.RED, Color.RED, Color.RED, Color.BLUE,Color.BLUE,Color.BLUE}
        };
        PhotoPaint photoPaint = new PhotoPaint();
        for(int i= 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++)
                System.out.print(image[i][j].name() + " ");
            System.out.println();
        }
        System.out.println();
        photoPaint.paintFill(image,1,1,Color.GREEN);
        for(int i= 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++)
                System.out.print(image[i][j].name() + " ");
            System.out.println();
        }
    }
}
