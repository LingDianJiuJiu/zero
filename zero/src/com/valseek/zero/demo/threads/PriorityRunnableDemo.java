package com.valseek.zero.demo.threads;

import javax.xml.stream.events.ProcessingInstruction;

public class PriorityRunnableDemo implements Runnable {

    private int countDown = 5;

    private static int taskCount = 0;

    private int id;

    private volatile double s = 0;

    private int priority;

    public PriorityRunnableDemo() {
        this.id = taskCount++;
        this.priority = 10 > taskCount ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
    }

    public PriorityRunnableDemo(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }

    public void run() {
        Thread.currentThread().setPriority(this.priority);
        while(countDown > 0 ){
            for(int i = 0 ; i < 10000000 ; i ++) {
                s += (Math.PI + Math.E )/(double)(i+1) ;
                if(s > 1000000) {
                    s/=2;
                }
                if(i % 1000 == 0 ) {
                    Thread.yield();
                }
            }
            System.out.println("this priority : " + this.priority + "\trun thread " + id + "\tthe sum is " + s + "\t and the count is:" +this.countDown);
            countDown -- ;
        }
    }

}
