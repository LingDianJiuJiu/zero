package com.valseek.zero.demo.threads.exception;

public class ExceptionThread2 implements Runnable{
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("Run by " + t);
        System.out.println("Error handler is " + t.getUncaughtExceptionHandler());
        throw  new RuntimeException("Inner Exception Thread 2 's RuntimeException");

    }
}
