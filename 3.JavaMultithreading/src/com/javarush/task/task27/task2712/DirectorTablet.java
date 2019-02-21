package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class DirectorTablet {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
    public void printAdvertisementProfit(){
        Map<Date,Double> map = StatisticManager.getInstance().getAdvStatistic();
        double summ = 0.0;

        for(Map.Entry<Date,Double> entry : map.entrySet()){
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH,"%s - %.2f",dateFormat.format(entry.getKey()),entry.getValue()));
            summ += entry.getValue();
        }
        if(summ>0.0){ConsoleHelper.writeMessage("Total - " + String.format(Locale.ENGLISH,"%.2f",summ));}
    }
    public void printCookWorkloading(){
        //14-May-2013
        //Ivanov - 60 min
        //Petrov - 35 min
        Map<Date,Map<String,Integer>> map = StatisticManager.getInstance().getCookStat();
        for(Map.Entry<Date,Map<String,Integer>> dateEntry : map.entrySet()){
            ConsoleHelper.writeMessage(dateFormat.format(dateEntry.getKey()));
            for(Map.Entry<String,Integer> cookEntry : dateEntry.getValue().entrySet()){
                ConsoleHelper.writeMessage(String.format("%s - %d min",cookEntry.getKey(),cookEntry.getValue()));
            }
            ConsoleHelper.writeMessage("");
        }
    }
    public void printActiveVideoSet(){}
    public void printArchivedVideoSet(){}
}
