package com.valseek.zero.demo;

import com.valseek.zero.demo.config.ConfigDemo;
import com.valseek.zero.demo.equals.EqualDemo;
import com.valseek.zero.demo.gc.GCDemo;
import com.valseek.zero.demo.test.TestDemo;
import com.valseek.zero.demo.threads.SimpleCallable;
import com.valseek.zero.demo.threads.SimpleCritical;
import com.valseek.zero.demo.threads.SimpleHalt;
import com.valseek.zero.demo.threads.SimpleRunnable;

import java.util.HashMap;
import java.util.Map;

public class Demos {

    private static Demos instance;

    private Map<String,Class<? extends Base> > demos;

    public static Demos getInstance(){
        if(instance == null){
            instance = new Demos();
        }
        return instance;
    }

    private Demos(){
        this.demos = new HashMap<>();

        demos.put("equals", EqualDemo.class);
        demos.put("srunnable", SimpleRunnable.class);
        demos.put("callable", SimpleCallable.class);
        demos.put("critical", SimpleCritical.class);
        demos.put("halt", SimpleHalt.class);
        demos.put("gc", GCDemo.class);
        demos.put("config", ConfigDemo.class);
        demos.put("test", TestDemo.class);

    }

    public void outputDemoNames(){

        System.out.println();

        for (String name:demos.keySet()
             ) {
            System.out.println(name);
        }

        System.out.println();
    }

    public Class<? extends Base> getDemo(String demoName){
        return demos.get(demoName);
    }


}
