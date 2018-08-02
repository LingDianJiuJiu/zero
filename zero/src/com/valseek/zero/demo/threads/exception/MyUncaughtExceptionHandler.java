package com.valseek.zero.demo.threads.exception;

public class MyUncaughtExceptionHandler implements  Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught exception "+ e.getMessage());
    }
}
