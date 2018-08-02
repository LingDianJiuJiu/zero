package com.valseek.zero.demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

abstract public class Base {

     public String run(String argv[]){
          String res = null;

          Class<?> clz = this.getClass();
          try {
               Method method = clz.getMethod(argv[0], null);
               res = (String)method.invoke(this,null);
          }catch (NoSuchMethodException nsme){
               System.err.println("NoSuchMethod " + nsme.getMessage());
          }catch (IllegalAccessException iae){
               System.err.println("IllegalAccess " + iae.getMessage());
          }catch (InvocationTargetException ite){
               System.err.println("Invocation Target " + ite.getMessage());
          }
          return res;
     }

}
