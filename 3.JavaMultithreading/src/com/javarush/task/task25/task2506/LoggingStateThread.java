package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread target;
    private State state = null;
    public LoggingStateThread(Thread target) {
        super(target);
        this.target = target;
        setDaemon(true);
    }

    @Override
    public void run() {
        while(state != State.TERMINATED)
        if(state != target.getState()) {
            state = target.getState();
            System.out.println(target.getState());
        }
    }
}
