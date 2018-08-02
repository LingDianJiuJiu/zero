package com.valseek.zero.demo.threads;

import com.valseek.zero.demo.Base;
import com.valseek.zero.demo.threads.daemon.ADaemon;
import com.valseek.zero.demo.threads.daemon.Daemon;
import com.valseek.zero.demo.threads.daemon.DaemonThread;
import com.valseek.zero.demo.threads.daemon.DaemonThreadFactory;
import com.valseek.zero.demo.threads.exception.ExceptionThread;
import com.valseek.zero.demo.threads.exception.ExceptionThread2;
import com.valseek.zero.demo.threads.exception.HandlerThreadFactory;
import com.valseek.zero.demo.threads.exception.MyUncaughtExceptionHandler;
import com.valseek.zero.demo.threads.interrupte.InterruptedThread;
import com.valseek.zero.demo.threads.join.Joiner;
import com.valseek.zero.demo.threads.join.Sleeper;
import com.valseek.zero.demo.threads.thread.InnerThread1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleRunnable extends Base {

    private void liftOff() {
        for (int i = 0; i < 8; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Start lift off");
    }

    private void executor() {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            executor.execute(new LiftOff());
        }
        executor.shutdown();
        System.out.println("executor shutdown !");
    }

    private void fixedThreadPool() {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 7; i++) {
            executor.execute(new LiftOff());
        }
        executor.shutdown();
        System.out.println("executor shutdown !");
    }

    private void singleThreadPool() {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 3; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }

    private void priorityRunnable() {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            exec.execute(new PriorityRunnableDemo());
        }
        exec.shutdown();
    }

    private void daemonThread() {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new DaemonThread());
//            daemon.setDaemon(true);
            daemon.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
        }
    }

    private void daemonFactoryThread() {

        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());

        for (int i = 0; i < 10; i++) {
            exec.execute(new DaemonThread());
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
        }
    }

    private void daemons() {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        System.out.println("d.isDaemon() = " + d.isDaemon() + ", ");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
        }
    }

    private void aDaemon() {
        Thread t = new Thread(new ADaemon());
//        t.setDaemon(true);
        t.start();
    }

    private void innerThread1() {
        new InnerThread1("innerThread1");
    }

    private void innerThread2() {
        new InnerThread1("innerThread2");
    }

    public void threadJoin(){
        Sleeper sleepy = new Sleeper("Sleepy",1500);
        Sleeper grumpy = new Sleeper("Grumpy",1500);
        Joiner dopey = new Joiner("dopey",sleepy);
        Joiner doc = new Joiner("Doc" , grumpy);
        grumpy.interrupt();
    }

    public void testInterrupted(){
        Thread th = new InterruptedThread("Test Interrupted");
        th.start();
        try{
            Thread.sleep(1000);
            th.interrupt();
        }catch (InterruptedException ie){

        }
    }

    public void testExceptionThread(){
        Thread th = new Thread(new ExceptionThread());
        try{
            th.start();
        }catch (RuntimeException re){
            System.err.println("Exception Thread Runtime");
        }
    }

    public void testExceptionThreadPool(){
        ExecutorService exec = Executors.newCachedThreadPool();
        try {
            exec.execute(new ExceptionThread());
        }catch (RuntimeException re){
            System.err.println("Exception Thread Runtime");
        }
    }

    public void testExceptionCaught(){
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
        exec.shutdown();
    }

    public void setDefaultCaught(){
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
        exec.shutdown();
    }

    @Override
    public String run(String[] argv) {

        if (argv[0].equals("thread")) {
            this.liftOff();
        } else if (argv[0].equals("executor")) {
            this.executor();
        } else if (argv[0].equals("fixedPool")) {
            this.fixedThreadPool();
        } else if (argv[0].equals("singlePool")) {
            this.singleThreadPool();
        } else if (argv[0].equals("priority")) {
            this.priorityRunnable();
        } else if (argv[0].equals("daemon")) {
            this.daemonThread();
        } else if (argv[0].equals("daemonFactory")) {
            this.daemonFactoryThread();
        } else if (argv[0].equals("daemons")) {
            this.daemons();
        } else if (argv[0].equals("adaemon")) {
            this.aDaemon();
        } else if (argv[0].equals("innerThread1")) {
            this.innerThread1();
        } else if (argv[0].equals("innerThread2")) {
            this.innerThread2();
        }else{
            super.run(argv);
        }
        return null;
    }
}
