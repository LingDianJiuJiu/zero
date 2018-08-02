package com.valseek.zero.demo.threads.daemon;

import java.util.concurrent.TimeUnit;

public class ADaemon implements Runnable{

    @Override
    public void run() {
        try{
            System.out.println("Start ADaemon");
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException ie){

        }finally {
            System.out.println("call finally");
        }
    }
}
