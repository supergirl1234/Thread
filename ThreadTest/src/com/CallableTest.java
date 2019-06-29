package com;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

/**
 * Author:Fanleilei
 * Created:2019/6/29 0029
 */

class MyCallableTest implements Callable<String>{

    private int ticket=20;

    @Override
    //线程需要执行的任务
    public String call() throws Exception {
        while(ticket>0){

            System.out.println("当前线程为："+Thread.currentThread().getName()+",还剩下"+ticket--+"票");
        }
        return "票卖完了，请明天再来";
    }
}
public class CallableTest {

    public static void main(String[] args) {

        MyCallableTest myCallableTest=new  MyCallableTest();
        FutureTask<String> futureTask=new FutureTask<>(myCallableTest);
        Thread thread=new Thread(futureTask);
        thread.start();
        try {
            String result=futureTask.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
