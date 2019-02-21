package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Model {
    public static final int FIELD_CELL_SIZE = 20;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel=1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("D:\\projects\\java\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task34\\task3410\\res\\levels.txt"));
    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }
    public GameObjects getGameObjects(){
        return gameObjects;
    }
    public void restartLevel(int level){
        gameObjects = levelLoader.getLevel(level);
    }
    public void restart(){
        restartLevel(currentLevel);
    }
    public void startNextLevel(){
        currentLevel++;
        restart();
    }
    public boolean checkWallCollision(CollisionObject gameObject, Direction direction){
        for(GameObject obj : gameObjects.getWalls())
            if(gameObject.isCollision(obj,direction))return true;
        return false;
    }

    public boolean checkBoxCollisionAndMoveIfAvaliable(Direction direction){
        Player player = gameObjects.getPlayer();
        for(Box obj : gameObjects.getBoxes())
            if(player.isCollision(obj,direction)) {
                for (GameObject nextObj : gameObjects.getAll())
                    if ( obj.isCollision(nextObj, direction) && (nextObj instanceof Wall || nextObj instanceof Box))
                        return true;
                    switch (direction){
                        case LEFT : obj.move(-FIELD_CELL_SIZE, 0); break;
                        case RIGHT : obj.move(FIELD_CELL_SIZE, 0); break;
                        case UP : obj.move(0,-FIELD_CELL_SIZE); break;
                        case DOWN : obj.move( 0, FIELD_CELL_SIZE); break;
                    }
            }

        return false;
    }

    public void checkCompletion(){
        Boolean win = true;
        for(Box box : gameObjects.getBoxes()){
            boolean inHome = false;
            for(Home home : gameObjects.getHomes())
                if(box.getX() == home.getX() && box.getY() == home.getY()) {inHome = true; break;}
            if(!inHome)return;
        }
        eventListener.levelCompleted(currentLevel);
    }
    public void move(Direction direction) {
        Player player = gameObjects.getPlayer();
        if(checkWallCollision(player, direction))return;
        if(checkBoxCollisionAndMoveIfAvaliable(direction))return;
        switch (direction){
            case LEFT : player.move(-FIELD_CELL_SIZE, 0); break;
            case RIGHT : player.move(FIELD_CELL_SIZE, 0); break;
            case UP : player.move(0,-FIELD_CELL_SIZE); break;
            case DOWN : player.move( 0, FIELD_CELL_SIZE); break;
        }
        checkCompletion();
    }
}
