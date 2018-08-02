package com.valseek.zero.demo.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SyncTest {

    static class Account {
        private volatile String name;
        private volatile double balance;
        ReentrantLock lock = new ReentrantLock();

        public Lock getLock() {
            return lock;
        }

        public void set(String name, double balance) {
            System.out.println("set before lock " + Thread.currentThread().getName() + " lock hold count " + lock.getHoldCount());
            lock.lock();
            System.out.println("set before lock " + Thread.currentThread().getName() + " lock hold count " + lock.getHoldCount());
            this.name = name;
            try {
                Thread.sleep(1);
            } catch (Exception e) {
                // TODO: handle exception
            }
            this.balance = balance;
            lock.unlock();
            System.out.println("set after lock " + Thread.currentThread().getName() + " lock hold count " + lock.getHoldCount());
        }

        public double getBalance() {
            try {
                System.out.println("get before lock " + Thread.currentThread().getName() + " lock hold count " + lock.getHoldCount());
                lock.lock();
                System.out.println("get after lock " + Thread.currentThread().getName() + " lock hold count " + lock.getHoldCount());
                return this.balance;
            } finally {
                lock.unlock();
                System.out.println("get after unlock " + Thread.currentThread().getName() + " lock hold count " + lock.getHoldCount());
            }
        }
    }

    static class MyRunnable implements Runnable {

        private SyncTest.Account a;

        public MyRunnable(SyncTest.Account account) {
            this.a = account;
        }

        @Override
        public void run() {
            a.set("zhangsan", 100.0);
        }
    }


    public static void test() {
        SyncTest.Account a = new SyncTest.Account();

//        new Thread(() -> {
//            a.set("zhangsan", 100.0);
//        }).start();

        new Thread(new SyncTest.MyRunnable(a)).start();

        /*
         * bug 代码，还不知道原因
         * */

        System.out.println(" || " + a.getBalance()+"\n");

        System.out.println("In main !!\n");

//		try {
//			TimeUnit.MILLISECONDS.sleep(1500);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
        /*
         * bug 代码，还不知道原因
         * */
        System.out.println("Main thread : " + a.getBalance()+"\n");
        new Thread(() -> System.out.println(Thread.currentThread().getName() + " " + a.getBalance()+"\n")).start();
        try {
            Thread.sleep(1);
        } catch (Exception e) {
            // TODO: handle exception
        }

        System.out.println(Thread.currentThread().getName() + " " + a.getBalance()+"\n");
    }

}
