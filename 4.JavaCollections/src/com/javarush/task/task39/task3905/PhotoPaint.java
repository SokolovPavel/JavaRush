package com.javarush.task.task39.task3905;

import java.util.LinkedList;
import java.util.Queue;

public class PhotoPaint {
    class Point
    {
        public int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    Queue<Point> queue = new LinkedList<>();
    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {
        if(image[0].length <= x || image.length <= y || x < 0 || y < 0) return false;
        if(image[y][x] == desiredColor)return false;

        Color refillColor = image[y][x];
        queue.add(new Point(x,y));
        while(queue.peek() != null){
            Point p = queue.poll();
            if(checkColor(image,p.x,p.y - 1,refillColor)) queue.add(new Point(p.x,p.y-1));
            if(checkColor(image,p.x,p.y + 1,refillColor)) queue.add(new Point(p.x,p.y+1));
            if(checkColor(image,p.x - 1,p.y,refillColor)) queue.add(new Point(p.x - 1,p.y));
            if(checkColor(image,p.x + 1,p.y,refillColor)) queue.add(new Point(p.x + 1,p.y));
            image[p.y][p.x] = desiredColor;
        }
        return true;
    }
    private boolean checkColor(Color[][] image, int x, int y, Color refillColor){
        if(image[0].length <= x || image.length <= y || x < 0 || y < 0) return false;
        if(image[y][x] == refillColor)return true;
        return false;
    }
}
