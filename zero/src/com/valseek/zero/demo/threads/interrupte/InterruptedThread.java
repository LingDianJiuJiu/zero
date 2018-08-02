package com.valseek.zero.demo.threads.interrupte;

public class InterruptedThread extends Thread{

    public InterruptedThread(String name){
        super(name);
    }

    @Override
    public void run() {
        while(true){
            if(isInterrupted()){
                System.out.println("thread " + getName() + " interrupted !");
                return ;
            }
            yield();
        }
    }
}
