package com.valseek.zero.demo.threads;

import java.util.concurrent.Callable;

public class CallableDemo implements Callable<String>{

    private int id;

    public CallableDemo(){
        this.id = (int)(Math.random()*1000000);
    }

    public CallableDemo(int id){
        this.id = id;
    }

    public String call(){
        try{
            Thread.sleep((long)(Math.random()*2000));
        }catch (InterruptedException ie){
        }
        return "Callable Demo id : " + id;
    }

}
