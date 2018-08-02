package com.valseek.zero.demo.threads.critical.serial;


class SerialNumberGenerator{
    private static volatile int serialNumber = 0 ;
    public static int nextSerialNumber(){
        return serialNumber ++;
    }
}
