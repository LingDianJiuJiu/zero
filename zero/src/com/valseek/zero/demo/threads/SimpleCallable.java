package com.valseek.zero.demo.threads;

import com.valseek.zero.demo.Base;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SimpleCallable extends Base{

    private String simpleCallable(){
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> result = new ArrayList<>();

        int[] flag = new int[10];

        for(int i = 0 ; i < 10 ; i ++ ) {
            flag[i] = 0 ;
            result.add(exec.submit(new CallableDemo(i)));
        }
        int taskCount = 10;
        while(taskCount > 0 ) {
            for(int i = 0 ; i < result.size() ; i ++ ){
                Future<String> fs = result.get(i);
                try {
                    if(flag[i] == 0 && fs.isDone()){
                        String res = fs.get();
                        System.out.println(res);
                        taskCount -= 1;
                        flag[i] = 1 ;
                    }
                } catch (InterruptedException ie) {
                    System.out.println("\ninterrupted exception.\n");
                } catch (ExecutionException ee) {
                    System.out.println("\nexecution exception.\n");
                } finally {
                }
            }
        }
        exec.shutdown();
        return null;
    }

    @Override
    public String run(String[] argv) {
        if(argv.length == 1 ){
            if(argv[0].equals("simple")){
                this.simpleCallable();
            }
        }
        return null;
    }
}
