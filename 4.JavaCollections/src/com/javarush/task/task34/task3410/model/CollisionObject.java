package com.javarush.task.task34.task3410.model;

import static com.javarush.task.task34.task3410.model.Model.FIELD_CELL_SIZE;

public abstract class CollisionObject extends GameObject{
    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction){
        int shiftx=getX(), shifty=getY();
        switch (direction){
            case UP : shifty = getY() - FIELD_CELL_SIZE; break;
            case DOWN : shifty = getY() + FIELD_CELL_SIZE; break;
            case LEFT : shiftx = getX() - FIELD_CELL_SIZE; break;
            case RIGHT : shiftx = getX() + FIELD_CELL_SIZE; break;
        }
        if(shiftx == gameObject.getX() && shifty == gameObject.getY())
            return true;
        else return false;
    }
}
