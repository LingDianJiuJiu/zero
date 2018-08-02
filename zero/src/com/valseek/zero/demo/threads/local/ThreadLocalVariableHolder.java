package com.valseek.zero.demo.threads.local;

import java.util.Random;

public class ThreadLocalVariableHolder {
    private static ThreadLocal<Integer> value = new ThreadLocal<Integer>(){
        private Random rand = new Random(47);

        @Override
        protected synchronized Integer initialValue() {
            return rand.nextInt(10000);
        }

    };

    public static int get(){
        return value.get();
    }

    public static void increment (){
        value.set(value.get() + 1);
    }

}
