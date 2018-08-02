package com.valseek.zero.demo.threads;

import com.valseek.zero.demo.Base;
import com.valseek.zero.demo.threads.critical.*;
import com.valseek.zero.demo.threads.critical.serial.SerialNumberChecker;
import com.valseek.zero.demo.threads.local.Accessor;
import com.valseek.zero.demo.threads.syncblock.PairDemo;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimpleCritical extends Base{

    public void testEvenGenerator(){
        EvenChecker.test(new EvenGenerator());
    }

    public void testSyncEvenGenerator(){
        EvenChecker.test(new SynchronizedEvenGenerator());
    }

    public void testMutexEvenGenerator(){
        EvenChecker.test(new MutexEvenGenerator());
    }

    public void testAtomicityTest(){
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest atomTest = new AtomicityTest();
        exec.execute(atomTest);
        while(true){
            int val = atomTest.getValue();
            if(val % 2 != 0){
                System.out.println(val);
                System.exit(0);
            }
        }

    }

    public void testSerialNumber(){
        SerialNumberChecker.test();
    }

    public void testPair(){
        PairDemo.test();
    }

    public void testLocal(){
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0 ; i < 5 ; i ++ ){
            exec.execute(new Accessor(i));
        }
        try{
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException ignore){}
        exec.shutdownNow();
    }

}
