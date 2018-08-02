package com.valseek.zero.demo.test;

import com.valseek.zero.demo.threads.local.Accessor;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyTest {

    static class Account {
        private volatile String name;
        private volatile double balance;

        private volatile boolean isWait = true;

        public synchronized void set(String name, double balance) {
            this.name = name;
            System.out.println("In set");
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                // TODO: handle exception
            }
            this.balance = balance;
            this.isWait = false;
            this.notifyAll();
        }

        public synchronized double getBalance() {
            return this.balance;
        }
    }

    static class MyRunnable implements Runnable {

        private MyTest.Account a;

        public MyRunnable(MyTest.Account account) {
            this.a = account;
        }

        @Override
        public void run() {
            a.set("zhangsan", 100.0);
        }
    }


    public static void test() {
        MyTest.Account a = new MyTest.Account();
        new Thread(new MyRunnable(a)).start();
        System.out.println("In main !!\n");
        synchronized (a) {
            try {
                if(a.isWait){
                    a.wait();
                }
                System.out.println(" || " + a.getBalance() + "\n");
                System.out.println("Main thread : " + a.getBalance() + "\n");
            } catch (InterruptedException ie) {
            }
        }

        new Thread(() -> System.out.println(Thread.currentThread().getName() + " " + a.getBalance() + "\n")).start();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            // TODO: handle exception
        }

        System.out.println(Thread.currentThread().getName() + " " + a.getBalance() + "\n");
    }

}


