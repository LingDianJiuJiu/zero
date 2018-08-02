package com.valseek.zero.demo.gc;

import java.util.LinkedList;
import java.util.List;

class PrintGCDemo {

    private List<byte[]> bytess;

    public PrintGCDemo(){
        bytess = new LinkedList<>();
    }

    public void newByte(){
        for(int i = 3 ; i < 2000000; i ++ ){
            bytess.add(new byte[(int)(Math.log(i))]);
        }
    }

    public static void test(){
        PrintGCDemo pgcd = new PrintGCDemo();
        pgcd.newByte();
    }

}
