package com.javarush.task.task27.task2712.ad;


import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }
    private long totalAmount;
    public void processVideos(){
            List<Advertisement> advertisementList = new ArrayList<>();
            long advertismentAmount = 0;
            int advertismentDuration = 0;

            Collections.sort(storage.list(), new Comparator<Advertisement>() {
                @Override
                public int compare(Advertisement o1, Advertisement o2) {
                    int result = Long.compare(o1.getAmountPerOneDisplaying(), o2.getAmountPerOneDisplaying());
                    if (result != 0)
                        return -result;

                    long oneSecondCost1 = o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration();
                    long oneSecondCost2 = o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration();

                    return Long.compare(oneSecondCost1, oneSecondCost2);
                }
            });

            int timeLeft = timeSeconds;

            for (Advertisement advertisement : storage.list()) {
                if (timeLeft < advertisement.getDuration()) {
                    continue;
                }

                advertisementList.add(advertisement);
                advertismentAmount += advertisement.getAmountPerOneDisplaying();
                advertismentDuration += advertisement.getDuration();

                totalAmount += advertismentAmount;

                timeLeft -= advertisement.getDuration();

            }

            StatisticManager.getInstance().register(new VideoSelectedEventDataRow(advertisementList, advertismentAmount, advertismentDuration));

            for (Advertisement advertisement : storage.list()) {
                if (timeLeft < advertisement.getDuration()) {
                    continue;
                }

                advertisement.revalidate();
            }

            if (timeLeft == timeSeconds) {
                throw new NoVideoAvailableException();
            }

            for (Advertisement advertisement : advertisementList) {
                ConsoleHelper.writeMessage(advertisement.getName() + " is displaying... "
                        + advertisement.getAmountPerOneDisplaying() + ", "
                        + advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration());
            }
            return;



        /*if(storage.list().size()==0)throw new NoVideoAvailableException();

        List<Advertisement> videos = storage.list();
        findBest(videos,timeSeconds,new LinkedList<>());
        Collections.sort(bestList,(o1,o2)->{
            if(o1.getAmountPerOneDisplaying() > o2.getAmountPerOneDisplaying())return -1;
            else if(o1.getAmountPerOneDisplaying() < o2.getAmountPerOneDisplaying())return 1;
            else {
                if( (o1.getAmountPerOneDisplaying()*1000/o1.getDuration()) < (o2.getAmountPerOneDisplaying()*1000/o2.getDuration()))return -1;
                else if( (o1.getAmountPerOneDisplaying()*1000/o1.getDuration()) == (o2.getAmountPerOneDisplaying()*1000/o2.getDuration()))return 0;
                else return 1;
            }
        });
        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(bestList,getAmount(bestList),getDuration(bestList)));

        for(Advertisement adv : bestList) {
            adv.revalidate();
            //First Video is displaying... 50, 277
            ConsoleHelper.writeMessage(adv.getName() + " is displaying... " + adv.getAmountPerOneDisplaying()+ ", "  + adv.getAmountPerOneDisplaying()*1000/adv.getDuration() );
        }*/

    }
    List<Advertisement> bestList = null;
    private void findBest(List<Advertisement> list, int remainingSpace, List<Advertisement> videosInPack){
        Boolean found = false;
        for(Advertisement adv : list) {
            if(adv.getHits() > 0 && adv.getDuration()<=remainingSpace) {
                List<Advertisement> outList = new LinkedList<>(list);
                List<Advertisement> outListPack = new LinkedList<>(videosInPack);
                outList.remove(adv);
                outListPack.add(adv);
                findBest(outList, remainingSpace - adv.getDuration(),outListPack);
                found = true;
            }
        }
        if(found)return;
        if(bestList == null){
            bestList = new LinkedList<>(videosInPack);
            return;
        }
        else if(getAmount(videosInPack) > getAmount(bestList)){
            bestList = new LinkedList<>(videosInPack);
            return;
        }else if(getAmount(videosInPack) ==  getAmount(bestList)){
            if(getDuration(videosInPack) > getDuration(bestList)){
                bestList = new LinkedList<>(videosInPack);
                return;
            }else if(getDuration(videosInPack) == getDuration(bestList)){
                if(videosInPack.size() < bestList.size()){
                    bestList = new LinkedList<>(videosInPack);
                    return;
                }
            }
        }
    }

    private int getDuration(List<Advertisement> list){
        int result=0;
        for(Advertisement adv : list)result += adv.getDuration();
        return result;
    }

    private int getAmount(List<Advertisement> list){
        int result=0;
        for(Advertisement adv : list)result += adv.getAmountPerOneDisplaying();
        return result;
    }
}
