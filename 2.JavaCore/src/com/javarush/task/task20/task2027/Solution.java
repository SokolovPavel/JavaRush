package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word>list = detectAllWords(crossword, "home", "same");
        for(Word w:list)
            System.out.println(w);
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();
        for(int index=0;index<words.length;index++)
        for(int y=0; y<crossword.length; y++)
            for(int x=0; x<crossword[0].length; x++)
                if(words[index].substring(0,1).equals(Character.toString((char)crossword[y][x]))){
                    //System.out.println("catch first!." + words[index].substring(0,1));
                    if((y+1)>=words[index].length()){
                        if(words[index].substring(1,2).equals(Character.toString((char)crossword[y-1][x]))) {
                            Word word = new Word(words[index]);
                            word.setStartPoint(x,y);
                            word.setEndPoint(x,y-words[index].length()+1);
                            list.add(word);
                            break;
                        }
                        if(((x+1)>=words[index].length())&&(words[index].substring(1,2).equals(Character.toString((char)crossword[y-1][x-1])))){
                            Word word = new Word(words[index]);
                            word.setStartPoint(x,y);
                            word.setEndPoint(x-words[index].length()+1,y-words[index].length()+1);
                            list.add(word);
                            break;
                        }
                        if(((crossword[0].length - x) >= words[index].length())&&(words[index].substring(1,2).equals(Character.toString((char)crossword[y-1][x+1])))){
                            Word word = new Word(words[index]);
                            word.setStartPoint(x,y);
                            word.setEndPoint(x+words[index].length()-1,y+words[index].length()-1);
                            list.add(word);
                            break;
                        }

                    }
                    if(((x + 1)>=words[index].length())&&(words[index].substring(1,2).equals(Character.toString((char)crossword[y][x-1])))){
                        Word word = new Word(words[index]);
                        word.setStartPoint(x,y);
                        word.setEndPoint(x-words[index].length()+1,y);
                        list.add(word);
                        break;
                    }
                    if(((crossword[0].length - x) >= words[index].length())&&(words[index].substring(1,2).equals(Character.toString((char)crossword[y][x+1])))){
                        Word word = new Word(words[index]);
                        word.setStartPoint(x,y);
                        word.setEndPoint(x+words[index].length()-1,y);
                        list.add(word);
                        break;
                    }

                    if((crossword.length - y) >= words[index].length()){
                        if(words[index].substring(1,2).equals(Character.toString((char)crossword[y+1][x]))){
                            Word word = new Word(words[index]);
                            word.setStartPoint(x,y);
                            word.setEndPoint(x,y-words[index].length()+1);
                            list.add(word);
                            break;
                        }
                        if(((x+1)>=words[index].length())&&(words[index].substring(1,2).equals(Character.toString((char)crossword[y+1][x-1])))){
                            Word word = new Word(words[index]);
                            word.setStartPoint(x,y);
                            word.setEndPoint(x-words[index].length()+1,y+words[index].length()-1);
                            list.add(word);
                            break;
                        }
                        if(((crossword[0].length - x) >= words[index].length())&&(words[index].substring(1,2).equals(Character.toString((char)crossword[y+1][x+1])))){
                            Word word = new Word(words[index]);
                            word.setStartPoint(x,y);
                            word.setEndPoint(x+words[index].length()-1,y+words[index].length()-1);
                            list.add(word);
                            break;
                        }

                    }
                }

        return list;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
