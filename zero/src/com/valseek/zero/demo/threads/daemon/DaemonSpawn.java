package com.valseek.zero.demo.threads.daemon;

public class DaemonSpawn implements Runnable{
    @Override
    public void run() {
        while(true){
            Thread.yield();
        }
    }
}
