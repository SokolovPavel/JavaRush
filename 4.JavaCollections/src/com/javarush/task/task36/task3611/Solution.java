package com.javarush.task.task36.task3611;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/* 
Сколько у человека потенциальных друзей?
*/

public class Solution {
    private boolean[][] humansRelationships;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.humansRelationships = generateRelationships();

        Set<Integer> allFriendsAndPotentialFriends = solution.getAllFriendsAndPotentialFriends(4, 2);
        System.out.println(allFriendsAndPotentialFriends);                              //expected: [0, 1, 2, 3, 5, 7]
        Set<Integer> potentialFriends = solution.removeFriendsFromSet(allFriendsAndPotentialFriends, 4);
        System.out.println(potentialFriends);                                           //expected: [2, 5, 7]
    }

    public Set<Integer> getAllFriendsAndPotentialFriends(int index, int deep) {
        //напишите тут ваш код
        Queue<Integer> queue = new PriorityQueue<>();
        Set<Integer> searched = new HashSet<>();
        boolean[] checked = new boolean[humansRelationships.length];
        Set<Integer> result = new HashSet<>();
        if(deep == 0)return null;

        result.addAll(getFriends(index, checked));
        queue.addAll(result);
        checked[index] = true;

        for(int i= 1;i<deep;i++) {
            searched.clear();
            while(queue.peek() != null){
                Integer friend = queue.poll();
                searched.addAll(getFriends(friend,checked));
                checked[friend] = true;
            }
            queue.addAll(searched);
            result.addAll(searched);
        }
        return result;
    }
    public Set<Integer> getFriends(int index,boolean[] checked){
        Set<Integer> friends = new HashSet<>();
        for (int i = 0; i < humansRelationships.length; i++) {
            if(checked[i]==false) {
                if ((i < index) && (index < humansRelationships.length) && humansRelationships[index][i]) {
                    friends.add(i);
                } else if ((i > index) && humansRelationships[i][index]) {
                    friends.add(i);
                }
            }
        }
        return friends;
    }

    //remove people from set, with which you have already had relationship
    public Set<Integer> removeFriendsFromSet(Set<Integer> set, int index) {
        for (int i = 0; i < humansRelationships.length; i++) {
            if ((i < index) && (index < humansRelationships.length) && humansRelationships[index][i]) {
                set.remove(i);
            } else if ((i > index) && humansRelationships[i][index]) {
                set.remove(i);
            }
        }
        return set;
    }

    //return test data
    private static boolean[][] generateRelationships() {
        return new boolean[][]{
                {true},                                                                 //0
                {true, true},                                                           //1
                {false, true, true},                                                    //2
                {false, false, false, true},                                            //3
                {true, true, false, true, true},                                        //4
                {true, false, true, false, false, true},                                //5
                {false, false, false, false, false, true, true},                        //6
                {false, false, false, true, false, false, false, true}                  //7
        };
    }
}