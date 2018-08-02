package com.valseek.zero.demo.config;

import com.valseek.zero.demo.Base;

public class ConfigDemo extends Base{

    public void testHeapSize(){
        System.out.println("Xmx = "+Runtime.getRuntime().maxMemory()/1024/1024 + "M");
        System.out.println("free memory = "+Runtime.getRuntime().freeMemory()/1024/1024 +"M");
        System.out.println("total memory = " + Runtime.getRuntime().totalMemory()/1024/1024+"M");
    }

}
