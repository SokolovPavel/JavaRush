package com.javarush.task.task34.task3410.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static com.javarush.task.task34.task3410.model.Model.FIELD_CELL_SIZE;

public class LevelLoader {
    private Path path;
    public LevelLoader(Path levels) {
        path = levels;
    }
    public GameObjects getLevel(int level){
        while(level>60)level -= 60;
        //level=1;
        int curLevel = 0;
        Set<Wall> walls = new HashSet<Wall>();
        Set<Box> boxes = new HashSet<Box>();
        Set<Home> homes = new HashSet<Home>();
        Player player = null;
        try(BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))){



            while(true){
                String s = reader.readLine();
                if(s.contains("Maze"))curLevel++;

                if(curLevel == level){
                    reader.readLine();
                    reader.readLine();
                    reader.readLine();
                    reader.readLine();
                    reader.readLine();
                    reader.readLine();
                    //if(level==1)reader.readLine();
                    int y0 = FIELD_CELL_SIZE / 2;
                    int x0 = FIELD_CELL_SIZE / 2;
                    s = reader.readLine();
                    while(!s.contains("*****************")){
                        for(int i=0; i< s.length(); i++){
                            switch (s.charAt(i)){
                                case '*' : boxes.add(new Box(i*FIELD_CELL_SIZE + x0,y0)); break;
                                case 'X' : walls.add(new Wall(i*FIELD_CELL_SIZE + x0,y0)); break;
                                case '.' : homes.add(new Home(i*FIELD_CELL_SIZE + x0,y0)); break;
                                case '&' : boxes.add(new Box(i*FIELD_CELL_SIZE + x0,y0)); homes.add(new Home(i*FIELD_CELL_SIZE + x0,y0)); break;
                                case '@' : player = new Player(i*FIELD_CELL_SIZE + x0,y0); break;
                            }
                        }
                        s = reader.readLine();
                        y0+=FIELD_CELL_SIZE;
                    }
                    GameObjects gameObjects = new GameObjects(walls, boxes, homes, player);
                    return gameObjects;
                    //break;
                }
            }


        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
