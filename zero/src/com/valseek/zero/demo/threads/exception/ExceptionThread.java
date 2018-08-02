package com.valseek.zero.demo.threads.exception;

public class ExceptionThread implements Runnable{

    @Override
    public void run() {
        throw new RuntimeException("inner exception thread");
    }

}
