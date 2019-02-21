package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("D:\\projects\\java\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task39\\task3913\\logs"));
        //System.out.println(logParser.getNumberOfUniqueIPs(null, null));
        //System.out.println(logParser.getIPsForStatus(Status.OK, null, null));
        //System.out.println(Event.SOLVE_TASK);
        //System.out.println(logParser.getIPsForEvent(Event.SOLVE_TASK,null, null));
        //
        System.out.println(logParser.execute("get ip"));
        System.out.println(logParser.execute("get event for date = \"03.01.2014 03:45:23\""));
        System.out.println(logParser.execute("get ip for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\""));
        System.out.println(logParser.execute("get ip for event = \"SOLVE_TASK\" and date between \"11.12.1900 0:00:00\" and \"03.01.2030 23:59:59\""));
        System.out.println(logParser.execute("get date for event = \"WRITE_MESSAGE\" and date between \"11.12.1900 0:00:00\" and \"03.01.2030 23:59:59\""));

    }
}