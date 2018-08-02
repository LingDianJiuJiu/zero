package com.valseek.zero;

import com.valseek.zero.demo.Base;
import com.valseek.zero.demo.Demos;

import java.util.Scanner;

public class Main {

    public static void main(String[] argv){
        Scanner sc = new Scanner(System.in);

        Demos.getInstance().outputDemoNames();

        System.out.println("please input the demo name:");

        String demoName = sc.nextLine();
//        String demoName = "test";

        Class<? extends Base> clz = Demos.getInstance().getDemo(demoName);

        System.out.println("please input the demo arguments : ");

        String arguments = sc.nextLine();
//        String arguments = "test";

        try{
            clz.newInstance().run(arguments.split(" "));
        }catch (IllegalAccessException exae){
        }catch (InstantiationException exie){
        }

    }

}
