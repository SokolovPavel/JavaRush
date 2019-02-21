package com.javarush.task.task34.task3410.model;

import java.util.HashSet;
import java.util.Set;

public class GameObjects {
   public Set<Wall> walls;
   public Set<Box> boxes;
   public Set<Home> homes;
   public Player player;

    public Set<Wall> getWalls() {
        return walls;
    }

    public Set<Box> getBoxes() {
        return boxes;
    }

    public Set<Home> getHomes() {
        return homes;
    }

    public GameObjects(Set<Wall> walls, Set<Box> boxes, Set<Home> homes, Player player) {
        this.walls = walls;
        this.boxes = boxes;
        this.homes = homes;
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
    public Set<GameObject> getAll(){
        Set<GameObject> set = new HashSet<>();
        set.addAll(walls);
        set.addAll(boxes);
        set.addAll(homes);
        set.add(player);
        return set;
    }
}
