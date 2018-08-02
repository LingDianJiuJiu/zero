package com.valseek.zero.demo.threads.critical;

abstract public class IntGenerator {

    private volatile boolean canceled = false;

    public abstract int next();

    public boolean isCanceled(){return canceled;}

    public void canceled(){this.canceled = true;}


}
