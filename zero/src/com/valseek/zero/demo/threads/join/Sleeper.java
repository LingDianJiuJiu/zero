package com.valseek.zero.demo.threads.join;

public class Sleeper extends Thread{

    private int duration;

    public Sleeper(String name , int sleepTime){
        super(name);
        this.duration = sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        }catch (InterruptedException ie){
            System.err.println(getName() + " was interrupted. isInterrupted(): " + isInterrupted() );
            return ;
        }
        System.out.println(getName() + " has awakened!");
    }
}
