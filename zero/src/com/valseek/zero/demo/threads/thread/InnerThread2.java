package com.valseek.zero.demo.threads.thread;

public class InnerThread2 {

    private int countDown = 5 ;

    public InnerThread2(String name){

        Thread t = new Thread(name){

            @Override
            public void run() {

                while (countDown > 0) {
                    try {
                        System.out.println(this);
                        Thread.sleep(300);
                    } catch (InterruptedException ie) {
                    }
                    countDown--;
                }
            }

            @Override
            public String toString() {
                return this.getName() + ": " + countDown;
            }
        };
        t.start();

    }


}
