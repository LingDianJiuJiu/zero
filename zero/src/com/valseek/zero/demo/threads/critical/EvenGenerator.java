package com.valseek.zero.demo.threads.critical;

public class EvenGenerator extends IntGenerator{

    private int currentEvenValue = 0;

    @Override
    public int next() {
        ++currentEvenValue;
        ++currentEvenValue;
        return currentEvenValue;
    }
}
