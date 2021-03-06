package com.javarush.task.task34.task3410.model;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import static com.javarush.task.task34.task3410.model.Model.FIELD_CELL_SIZE;

public class Box extends CollisionObject implements Movable {
    public Box(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.ORANGE);
        graphics.fillRect(getX()-getWidth()/2, getY() - getHeight()/2, getWidth(), getHeight());
    }

    @Override
    public void move(int x, int y) {
        setX(getX() + x);
        setY(getY() + y);
    }
}
