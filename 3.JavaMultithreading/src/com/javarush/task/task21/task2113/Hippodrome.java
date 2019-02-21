package com.javarush.task.task21.task2113;

import java.util.LinkedList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;
    public static void main(String ... args){
        List list = new LinkedList();
        list.add(new Horse("vas9",3,0));
        list.add(new Horse("lesha",3,0));
        list.add(new Horse("rex",3,0));
        game = new Hippodrome(list);
        game.run();
        game.printWinner();
    }
    public void run(){
        try {
            for(int i=0; i<100;i++) {
                move();
                print();
                Thread.sleep(200);
            }
        }
        catch (Exception e){}
    }
    public void move(){
        for(Horse horse : horses)
            horse.move();
    }
    public void print(){
        for(Horse horse : horses)
        horse.print();
        for(int i=0;i<10;i++)System.out.println();
    }
    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }
    public Horse getWinner(){
        Horse winner = null;
        for(Horse horse : horses) {
            double dist = horse.getDistance();
            if ((winner == null) || (winner.getDistance() < dist))winner = horse;
        }
        return winner;
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
    public List<Horse> getHorses() {
        return horses;
    }
}
