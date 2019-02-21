package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Dish;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class StatisticManager {
    private static StatisticManager instance;
    private StatisticManager(){
        cooks.add(new Cook("Drugo"));
    }
    public static StatisticManager getInstance(){
        if(instance==null)instance = new StatisticManager();
        return instance;
    }
    private Set<Cook> cooks = new HashSet<>();
    public void register(Cook cook){
        cooks.add(cook);
    }
    public void register(EventDataRow data){
        statisticStorage.put(data);
    }
    private StatisticStorage statisticStorage = new StatisticStorage();

    public Map<Date,Double> getAdvStatistic(){
        Map<Date,Double> map = new TreeMap<>(Collections.reverseOrder());
        List<EventDataRow> videos = statisticStorage.getStorage().get(EventType.SELECTED_VIDEOS);
        for(EventDataRow event : videos){
            VideoSelectedEventDataRow videoEvent = (VideoSelectedEventDataRow)event;
            if(map.containsKey(videoEvent.getDate())){
                map.put(videoEvent.getDate(),  map.get(videoEvent.getDate()) + 0.01d * (double)videoEvent.getAmount());
            }
            else{
                map.put(videoEvent.getDate(),  0.01d * (double)videoEvent.getAmount());
            }
        }

        return map;
    }

    public Map<Date,Map<String,Integer>> getCookStat(){
        List<EventDataRow> events = statisticStorage.getStorage().get(EventType.COOKED_ORDER);
        Map<Date,Map<String,Integer>> cookStat = new TreeMap<>(Collections.reverseOrder());
        for(EventDataRow event : events){
            CookedOrderEventDataRow cookEvent = (CookedOrderEventDataRow)event;
            Date date = cookEvent.getDate();
            if(!cookStat.containsKey(date))cookStat.put(date,new TreeMap<>());
            Map<String,Integer> dayCookStat = cookStat.get(date);
            String cookName = cookEvent.getCookName();
            if(!dayCookStat.containsKey(cookName))dayCookStat.put(cookName,0);
            dayCookStat.put(cookName,dayCookStat.get(cookName) + (int)Math.ceil(cookEvent.getTime()/60.0));
        }
        return cookStat;

    }
    private class StatisticStorage{
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();
        public StatisticStorage() {
            storage.put(EventType.COOKED_ORDER, new ArrayList<EventDataRow>());
            storage.put(EventType.SELECTED_VIDEOS, new ArrayList<EventDataRow>());
            storage.put(EventType.NO_AVAILABLE_VIDEO, new ArrayList<EventDataRow>());

/*

            List<EventDataRow> list = new ArrayList<>();


            list.add(new VideoSelectedEventDataRow(new ArrayList<Advertisement>(), 501, 104));
            list.add(new VideoSelectedEventDataRow(new ArrayList<Advertisement>(),  801, 1027));
            list.add(new VideoSelectedEventDataRow(new ArrayList<Advertisement>(), 10, 15));
            list.add(new VideoSelectedEventDataRow(new ArrayList<Advertisement>(), 5600, 1034));
            list.add(new VideoSelectedEventDataRow(new ArrayList<Advertisement>(), 860, 101));
            int n = 9;
            for (int i = 0; i < list.size(); i++){
                if(i%2==0)
                    ++n;
                VideoSelectedEventDataRow vs = (VideoSelectedEventDataRow)list.get(i);
                vs.setCurrentDate(new Date(
                        new Date().getYear(),
                        new Date().getMonth(),
                        n));
            }
            for (EventDataRow eventDataRow : list)
                put(eventDataRow);
/*
            //Для статистики по работе повара
            list.clear();
            list.add(new CookedOrderEventDataRow("Tablet", "Ivanov", 1160, new ArrayList<Dish>()));
            list.add(new CookedOrderEventDataRow("Tablet", "Sokolov", 1, new ArrayList<Dish>()));
            list.add(new CookedOrderEventDataRow("Tablet", "Petrov", 985, new ArrayList<Dish>()));
            list.add(new CookedOrderEventDataRow("Tablet", "Sidorov", 820, new ArrayList<Dish>()));
            list.add(new CookedOrderEventDataRow("Tablet", "Ershov", 253, new ArrayList<Dish>()));
            list.add(new CookedOrderEventDataRow("Tablet", "Ivanov", 360, new ArrayList<Dish>()));
            list.add(new CookedOrderEventDataRow("Tablet", "Ivanov", 1160, new ArrayList<Dish>()));
            list.add(new CookedOrderEventDataRow("Tablet", "Petrov", 985, new ArrayList<Dish>()));
            list.add(new CookedOrderEventDataRow("Tablet", "Sidorov", 820, new ArrayList<Dish>()));
            list.add(new CookedOrderEventDataRow("Tablet", "Ershov", 253, new ArrayList<Dish>()));
            list.add(new CookedOrderEventDataRow("Tablet", "Ivanov", 360, new ArrayList<Dish>()));
            list.add(new CookedOrderEventDataRow("Tablet", "Ivanov", 1160, new ArrayList<Dish>()));
            list.add(new CookedOrderEventDataRow("Tablet", "Petrov", 985, new ArrayList<Dish>()));
            list.add(new CookedOrderEventDataRow("Tablet", "Sidorov", 820, new ArrayList<Dish>()));
            list.add(new CookedOrderEventDataRow("Tablet", "Ershov", 253, new ArrayList<Dish>()));
            list.add(new CookedOrderEventDataRow("Tablet", "Ivanov", 360, new ArrayList<Dish>()));
            n = 9;
            for (int i = 0; i < list.size(); i++){
                if(i%5==0)
                    ++n;
                CookedOrderEventDataRow co = (CookedOrderEventDataRow) list.get(i);

                co.setCurrentDate(new Date(
                        new Date().getYear(),
                        new Date().getMonth(),
                        n));
            }
            for (EventDataRow event : list)
                put(event);
                */
            //Конец тестовых данных
        }

        private void put(EventDataRow data){
            storage.get(data.getType()).add(data);
        }

        public Map<EventType, List<EventDataRow>> getStorage() {
            return storage;
        }
    }
}
