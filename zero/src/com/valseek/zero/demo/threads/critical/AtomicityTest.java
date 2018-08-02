package com.valseek.zero.demo.threads.critical;

public class AtomicityTest implements Runnable{

    private int i = 0 ;

    private synchronized void evenIncrement(){
        i++;
        i++;
    }

    @Override
    public void run() {
        while (true){
            evenIncrement();
        }
    }

    public synchronized int getValue(){
        return  i;
    }

}
