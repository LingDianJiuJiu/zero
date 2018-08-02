package com.valseek.zero.demo.threads.critical;

public class SynchronizedEvenGenerator extends IntGenerator{
    private int currentEvenValue = 0;

    public synchronized int next(){
        ++currentEvenValue;
        ++currentEvenValue;
        return currentEvenValue;
    }
}
