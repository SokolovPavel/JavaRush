package com.javarush.task.task26.task2613;

import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations;

    private boolean hasmoney = false;
    public boolean hasMoney(){
        return hasmoney;
    }

    public void addAmount(int denomination, int count){
        hasmoney = true;
        if(denominations.containsKey(denomination)){
            int prev_count = denominations.get(denomination);
            denominations.put(denomination,count + prev_count);
        }
        else{
            denominations.put(denomination,count);
        }
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
        denominations = new HashMap<>();
    }

    public int getTotalAmount(){
        int totalAmount=0;
        for(Map.Entry<Integer, Integer> entry : denominations.entrySet()){
            totalAmount += entry.getKey()*entry.getValue();
        }
        return totalAmount;
    }
}
