package com.valseek.zero.demo.threads.thread;

public class InnerThread1 {

    private int countDown = 5;

    private class Inner extends Thread{
        Inner(String name){
            super(name);
            start();
        }
        @Override
        public void run() {
            while(countDown > 0 ){
                try{
                    System.out.println(this);
                    Thread.sleep(300);
                }catch (InterruptedException ie){
                }
                countDown -- ;
            }
        }

        @Override
        public String toString() {
            return this.getName() + ": " + countDown;
        }
    }

    public InnerThread1(String name){
        new Inner(name);
    }


}
