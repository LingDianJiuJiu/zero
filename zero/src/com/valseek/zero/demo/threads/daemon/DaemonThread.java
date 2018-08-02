package com.valseek.zero.demo.threads.daemon;

import java.util.concurrent.TimeUnit;

public class DaemonThread implements Runnable{

    @Override
    public void run() {

        while(true){
            try{
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }catch (InterruptedException ie){
            }
        }
    }

}
