package com.valseek.zero.unit;

public class StringTools {

    public static String stringifyBool(boolean bool){
        return bool ? "true" : "false";
    }

    public static String stringifyBool(boolean bool , boolean upperCase){
        return upperCase ? bool ? "TRUE" : "FALSE" : bool ? "true" : "false";
    }

    public static void outputBegin(){
        System.out.println("\n\n ************************begin**************************\n\n");
    }

}
