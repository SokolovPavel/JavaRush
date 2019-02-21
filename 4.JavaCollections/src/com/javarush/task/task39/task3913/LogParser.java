package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    private Path logDir;
    private List<List<String>> strings = new LinkedList<>();
    SimpleDateFormat parser = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    BufferedReader reader;
    public LogParser(Path logDir){
        for(File path : logDir.toFile().listFiles()){
            if(path.getName().endsWith(".log")){
                try {
                    reader = new BufferedReader(new FileReader(path.toString()));

                    String s = reader.readLine();
                    while(s != null || s.length()>0) {
                        String[] ss = s.split("\t");
                        List list = new LinkedList<String>();
                        for(int i=0;i<ss.length;i++) {
                            list.add(ss[i]);
                        }
                        strings.add(list);
                        s = reader.readLine();
                    }
                }
                catch(Exception e){

                }
            }
        }
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        Set set = new HashSet();
        for(List<String> list : strings){

            try {
                Date date = parser.parse(list.get(2));
                if( (after == null || after.compareTo(date) < 0) && (before == null || before.compareTo(date) > 0))
                    set.add(list.get(0));
            }
            catch (Exception e){}

        }
        return set.size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set set = new HashSet();
        for(List<String> list : strings){

            try {
                Date date = parser.parse(list.get(2));
                if( (after == null || after.compareTo(date) < 0) && (before == null || before.compareTo(date) > 0))
                    set.add(list.get(0));
            }
            catch (Exception e){}

        }
        return set;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set set = new HashSet();
        for(List<String> list : strings){

            try {
                Date date = parser.parse(list.get(2));
                if( (after == null || after.compareTo(date) < 0) && (before == null || before.compareTo(date) > 0) && list.get(1).equals(user))
                    set.add(list.get(0));
            }
            catch (Exception e){}

        }
        return set;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set set = new HashSet();
        for(List<String> list : strings){

            try {
                Date date = parser.parse(list.get(2));
                if( (after == null || after.compareTo(date) < 0) && (before == null || before.compareTo(date) > 0) && list.get(3).split(" ")[0].equalsIgnoreCase(event.name()))
                    set.add(list.get(0));
            }
            catch (Exception e){}

        }
        return set;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set set = new HashSet();
        for(List<String> list : strings){

            try {
                Date date = parser.parse(list.get(2));
                if( (after == null || after.compareTo(date) < 0) && (before == null || before.compareTo(date) > 0) && list.get(list.size()-1).equalsIgnoreCase(status.name()))
                    set.add(list.get(0));
            }
            catch (Exception e){}

        }
        return set;
    }

    @Override
    public Set<String> getAllUsers() {
        Set set = new HashSet();
        for(List<String> list : strings){
                    set.add(list.get(1));
        }
        return set;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        Set set = new HashSet();
        for(List<String> list : strings){
            try {
                Date date = parser.parse(list.get(2));
                if ((after == null || after.compareTo(date) < 0) && (before == null || before.compareTo(date) > 0))
                set.add(list.get(1));
            }
            catch (Exception e){}
        }
        return set.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        Set set = new HashSet();
        for(List<String> list : strings){
            try {
                Date date = parser.parse(list.get(2));
                if ((after == null || after.compareTo(date) < 0) && (before == null || before.compareTo(date) > 0) && (list.get(1).equals(user)))
                    set.add(list.get(3).split(" ")[0]);
            }
            catch (Exception e){}
        }
        return set.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set set = new HashSet();
        for(List<String> list : strings){

            try {
                Date date = parser.parse(list.get(2));
                if( (after == null || after.compareTo(date) < 0) && (before == null || before.compareTo(date) > 0) && list.get(0).equals(ip))
                    set.add(list.get(1));
            }
            catch (Exception e){}

        }
        return set;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        Set set = new HashSet();
        for(List<String> list : strings){

            try {
                Date date = parser.parse(list.get(2));
                if( (after == null || after.compareTo(date) < 0) && (before == null || before.compareTo(date) > 0) && list.get(3).split(" ")[0].equalsIgnoreCase(Event.LOGIN.name()))
                    set.add(list.get(1));
            }
            catch (Exception e){}

        }
        return set;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        Set set = new HashSet();
        for(List<String> list : strings){

            try {
                Date date = parser.parse(list.get(2));
                if( (after == null || after.compareTo(date) < 0) && (before == null || before.compareTo(date) > 0) && list.get(3).split(" ")[0].equalsIgnoreCase(Event.DOWNLOAD_PLUGIN.name()))
                    set.add(list.get(1));
            }
            catch (Exception e){}

        }
        return set;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        Set set = new HashSet();
        for(List<String> list : strings){

            try {
                Date date = parser.parse(list.get(2));
                if( (after == null || after.compareTo(date) < 0) && (before == null || before.compareTo(date) > 0) && list.get(3).split(" ")[0].equalsIgnoreCase(Event.WRITE_MESSAGE.name()))
                    set.add(list.get(1));
            }
            catch (Exception e){}

        }
        return set;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        Set set = new HashSet();
        for(List<String> list : strings){

            try {
                Date date = parser.parse(list.get(2));
                if( (after == null || after.compareTo(date) < 0) && (before == null || before.compareTo(date) > 0) && list.get(3).split(" ")[0].equalsIgnoreCase(Event.SOLVE_TASK.name()))
                    set.add(list.get(1));
            }
            catch (Exception e){}

        }
        return set;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        Set set = new HashSet();
        for(List<String> list : strings){

            try {
                Date date = parser.parse(list.get(2));
                if( (after == null || after.compareTo(date) < 0) && (before == null || before.compareTo(date) > 0) && Integer.parseInt(list.get(3).split(" ")[1])==task  && list.get(3).split(" ")[0].equalsIgnoreCase(Event.SOLVE_TASK.name()))
                    set.add(list.get(1));
            }
            catch (Exception e){}

        }
        return set;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        Set set = new HashSet();
        for(List<String> list : strings){

            try {
                Date date = parser.parse(list.get(2));
                if( (after == null || after.compareTo(date) < 0) && (before == null || before.compareTo(date) > 0) && list.get(3).split(" ")[0].equalsIgnoreCase(Event.DONE_TASK.name()))
                    set.add(list.get(1));
            }
            catch (Exception e){}

        }
        return set;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        Set set = new HashSet();
        for(List<String> list : strings){

            try {
                Date date = parser.parse(list.get(2));
                if( (after == null || after.compareTo(date) < 0) && (before == null || before.compareTo(date) > 0) && list.get(3).split(" ")[0].equalsIgnoreCase(Event.DONE_TASK.name()) && Integer.parseInt(list.get(3).split(" ")[1])==task )
                    set.add(list.get(1));
            }
            catch (Exception e){}

        }
        return set;


    }
    private List<List<String>> CutDate(List<List<String>> list,Date after, Date before){
        List<List<String>> result = new LinkedList<>();
        for(List<String> string : list){

            try {
                Date date = parser.parse(string.get(2));
                if( (after == null || after.compareTo(date) < 0) && (before == null || before.compareTo(date) > 0) || after.compareTo(before) == 0){
                    result.add(string);
                }
            }
            catch (Exception e){}
        }
        return result;
    }

    private List<List<String>> CutDate(List<List<String>> list,Date dateIn){
        List<List<String>> result = new LinkedList<>();
        for(List<String> string : list){

            try {
                Date date = parser.parse(string.get(2));
                if( date.equals(dateIn) ){
                    result.add(string);
                }
            }
            catch (Exception e){}
        }
        return result;
    }

    private List<List<String>> CutUser(List<List<String>> list,String user){
        List<List<String>> result = new LinkedList<>();
        for(List<String> string : list){
            if(string.get(1).equals(user))
                    result.add(string);
        }
        return result;
    }

    private List<List<String>> CutIp(List<List<String>> list,String Ip){
        List<List<String>> result = new LinkedList<>();
        for(List<String> string : list){
            if(string.get(0).equals(Ip))
                result.add(string);
        }
        return result;
    }

    private List<List<String>> CutEvent(List<List<String>> list,Event event){
        List<List<String>> result = new LinkedList<>();
        for(List<String> string : list){
            if(string.get(3).split(" ")[0].equalsIgnoreCase(event.name()))
                result.add(string);
        }
        return result;
    }

    private List<List<String>> CutTask(List<List<String>> list,int task){
        List<List<String>> result = new LinkedList<>();
        for(List<String> string : list){
            if(Integer.parseInt(string.get(3).split(" ")[1])==task)
                result.add(string);
        }
        return result;
    }

    private List<List<String>> CutStatus(List<List<String>> list,Status status){
        List<List<String>> result = new LinkedList<>();
        for(List<String> string : list){
            if(string.get(string.size()-1).equalsIgnoreCase(status.name()))
                result.add(string);
        }
        return result;
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        List<List<String>> result = CutDate(CutEvent(CutUser(strings,user), event), after, before);
        Set set = new HashSet();
        for(List<String> string : result){
            try {
                set.add(parser.parse(string.get(2)));
            }
            catch (Exception e){}
        }
        return set;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        List<List<String>> result = CutDate(CutStatus(strings, Status.FAILED), after, before);
        Set set = new HashSet();
        for(List<String> string : result){
            try {
                set.add(parser.parse(string.get(2)));
            }
            catch (Exception e){}
        }
        return set;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        List<List<String>> result = CutDate(CutStatus(strings, Status.ERROR), after, before);
        Set set = new HashSet();
        for(List<String> string : result){
            try {
                set.add(parser.parse(string.get(2)));
            }
            catch (Exception e){}
        }
        return set;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        List<List<String>> result = CutStatus(CutUser(CutDate(CutEvent(strings, Event.LOGIN), after, before),user), Status.OK);
        if(result.size()==0)return null;
        Date mindate = new Date(Long.MAX_VALUE);
        for(List<String> string : result){
            try {
                Date date = parser.parse(string.get(2));
                if(date.compareTo(mindate)<0)mindate=date;
            }
            catch (Exception e){}
        }
        return mindate;
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        List<List<String>> result = CutTask(CutUser(CutDate(CutEvent(strings, Event.SOLVE_TASK), after, before),user),task);
        if(result.size()==0)return null;
        Date mindate = new Date(Long.MAX_VALUE);
        for(List<String> string : result){
            try {
                Date date = parser.parse(string.get(2));
                if(date.compareTo(mindate)<0)mindate=date;
            }
            catch (Exception e){}
        }
        return mindate;
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        List<List<String>> result = CutTask(CutUser(CutDate(CutEvent(strings, Event.DONE_TASK), after, before),user),task);
        if(result.size()==0)return null;
        Date mindate = new Date(Long.MAX_VALUE);
        for(List<String> string : result){
            try {
                Date date = parser.parse(string.get(2));
                if(date.compareTo(mindate)<0)mindate=date;
            }
            catch (Exception e){}
        }
        return mindate;
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        List<List<String>> result = CutEvent(CutUser(CutDate(CutStatus(strings, Status.OK), after, before),user),Event.WRITE_MESSAGE);
        Set set = new HashSet();
        for(List<String> string : result){
            try {
                set.add(parser.parse(string.get(2)));
            }
            catch (Exception e){}
        }
        return set;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        List<List<String>> result = CutEvent(CutUser(CutDate(CutStatus(strings, Status.OK), after, before),user),Event.DOWNLOAD_PLUGIN);
        Set set = new HashSet();
        for(List<String> string : result){
            try {
                set.add(parser.parse(string.get(2)));
            }
            catch (Exception e){}
        }
        return set;
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        List<List<String>> result = CutDate(strings,after, before);
        Set set = new HashSet();
        for(List<String> string : result)
            set.add(Event.valueOf(string.get(3).split(" ")[0]));
       return set.size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        List<List<String>> result = CutDate(strings,after, before);
        Set set = new HashSet();
        for(List<String> string : result)
            set.add(Event.valueOf(string.get(3).split(" ")[0]));
        return set;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        List<List<String>> result = CutIp(CutDate(strings,after, before),ip);
        Set set = new HashSet();
        for(List<String> string : result)
            set.add(Event.valueOf(string.get(3).split(" ")[0]));
        return set;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        List<List<String>> result = CutUser(CutDate(strings,after, before),user);
        Set set = new HashSet();
        for(List<String> string : result)
            set.add(Event.valueOf(string.get(3).split(" ")[0]));
        return set;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        List<List<String>> result = CutStatus(CutDate(strings,after, before),Status.FAILED);
        Set set = new HashSet();
        for(List<String> string : result)
            set.add(Event.valueOf(string.get(3).split(" ")[0]));
        return set;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        List<List<String>> result = CutStatus(CutDate(strings,after, before),Status.ERROR);
        Set set = new HashSet();
        for(List<String> string : result)
            set.add(Event.valueOf(string.get(3).split(" ")[0]));
        return set;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        List<List<String>> result = CutTask(CutEvent(CutDate(strings,after, before),Event.SOLVE_TASK),task);

        return result.size();
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        List<List<String>> result = CutTask(CutEvent(CutDate(strings,after, before),Event.DONE_TASK),task);//,Status.OK);
        return result.size();
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        List<List<String>> result = CutEvent(CutDate(strings,after, before),Event.SOLVE_TASK);
        Map<Integer, Integer> map = new HashMap<>();
        for(List<String> string : result){
            int task = Integer.parseInt(string.get(3).split(" ")[1]);
            int count = map.containsKey(task) ? map.get(task) : 0;
            map.put(task, count + 1);
        }

        return map;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        List<List<String>> result = CutEvent(CutDate(strings,after, before),Event.DONE_TASK);
        Map<Integer, Integer> map = new HashMap<>();
        for(List<String> string : result){
            int task = Integer.parseInt(string.get(3).split(" ")[1]);
            int count = map.containsKey(task) ? map.get(task) : 0;
            map.put(task, count + 1);
        }

        return map;
    }

    @Override
    public Set<Object> execute(String query) {
        Set set = new HashSet();
        String[] params = query.split(" ");

        List<List<String>> result = strings;


        int[]indexes = new int[6];
        if(query.contains("and date between")){
            indexes[2] = query.indexOf("\"",query.indexOf("and date between"));
            indexes[3] = query.indexOf("\"",indexes[2]+1);
            indexes[4] = query.indexOf("\"",indexes[3]+1);
            indexes[5] = query.indexOf("\"",indexes[4]+1);

            params[6] = query.substring(indexes[2]+1,indexes[3]);
            params[7] = query.substring(indexes[4]+1,indexes[5]);
            try{
                result = CutDate(result,parser.parse(params[6]),parser.parse(params[7]));
            }
            catch (Exception e){}
        }

        if(query.contains("for")){
            indexes[0] = query.indexOf("\"");
            indexes[1] = query.indexOf("\"",indexes[0]+1);
            params[5] = query.substring(indexes[0]+1,indexes[1]);

            switch (params[3]){
                case "ip":
                    result = CutIp(result,params[5]);
                    break;
                case "user":
                    result = CutUser(result,params[5]);
                    break;
                case "date":
                    try {
                        Date date = parser.parse(params[5]);
                        result = CutDate(result, date);
                    }
                    catch (Exception e){}
                    break;
                case "event":
                    result = CutEvent(result,Event.valueOf(params[5]));
                    break;
                case "status":
                    result = CutStatus(result,Status.valueOf(params[5]));
                    break;
                default:
                    result = null;
            }
        }

        switch (params[1]){
            case "ip":
                for(List<String> string : result)
                    set.add(string.get(0));
                return set;
            case "user":
                for(List<String> string : result)
                    set.add(string.get(1));
                return set;
            case "date":
                for(List<String> string : result)
                    try {
                        set.add(parser.parse(string.get(2)));
                    }
                    catch (Exception e){}
                return set;
            case "event":
                for(List<String> string : result)
                    set.add(Event.valueOf(string.get(3).split(" ")[0]));
                return set;
            case "status":
                for(List<String> string : result)
                    set.add(Status.valueOf(string.get(string.size() - 1)));
                return set;
            default:
                return null;
        }
    }
}