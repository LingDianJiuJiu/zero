package com.valseek.zero.demo.threads.critical;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable{

    private IntGenerator generator;

    private final int id;

    public EvenChecker(IntGenerator g ,int ident){
        this.generator = g;
        this.id = ident;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()){
            int val = generator.next();
            if(val % 2 != 0){
                System.out.println(val + " not even!");
                generator.canceled();
            }
        }
    }

    public static void test(IntGenerator gp , int count){
        System.out.println("press Control-c to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0 ; i < count ; i++){
            exec.execute(new EvenChecker(gp,i));
        }
        exec.shutdown();
    }

    public static void test(IntGenerator gp){
        System.out.println("press Control-c to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0 ; i < 10; i++){
            exec.execute(new EvenChecker(gp,i));
        }
        exec.shutdown();
    }

}
