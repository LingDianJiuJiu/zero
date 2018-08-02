package com.valseek.zero.demo.threads.join;

public class Joiner extends Thread{

    private Sleeper sleeper;

    public Joiner(String name , Sleeper sleeper){
        super(name);
        this.sleeper = sleeper;
        start();
    }

    public void run(){
        try {
            sleeper.join();
        }catch (InterruptedException ie){
            System.err.println("Joiner "+getName() + " Interrupted");
        }
        System.out.println(getName() + " join completed!");
    }

}
