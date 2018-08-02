package com.valseek.zero.demo.equals;

import com.valseek.zero.demo.Base;
import com.valseek.zero.unit.StringTools;

import java.lang.reflect.Method;

public class EqualDemo extends Base {


    private void testEqualitySign(){
        System.out.println(" simple new object sign compare : ");

        TObjectA a = new TObjectA();

        TObjectA b = new TObjectA();

        System.out.println(StringTools.stringifyBool(a==b));
        System.out.println();
    }

    private void testSimpleEqualMethod(){
        System.out.println("simple new object equal method");
        TObjectA a = new TObjectA();
        TObjectA b = new TObjectA();

        System.out.println(StringTools.stringifyBool(a.equals(b)));
        System.out.println();
    }

    private void testStringEqual(){
        System.out.println("test String simple equal");

        String a = "abc";
        String b = "a" + "b" + "c";
        String c = "ab";
        String d= c + "c";
        System.out.println(StringTools.stringifyBool(a==b));
        System.out.println(StringTools.stringifyBool(a.equals(b)));


        System.out.println(StringTools.stringifyBool(a==d));
        System.out.println(StringTools.stringifyBool(a.equals(d)));


    }

    @Override
    public String run(String[] argv) {

        StringTools.outputBegin();

        testEqualitySign();
        testSimpleEqualMethod();
        testStringEqual();

        return null;
    }


}
