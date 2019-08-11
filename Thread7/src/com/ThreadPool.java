package com;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPool implements  Runnable {

    private final AtomicInteger num=new AtomicInteger(0);

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-"+num.getAndAdd(1));
    }

    public static void main(String[] args) {
        //自定义的方式创建线程池执行器
        ThreadPoolExecutor executor=new ThreadPoolExecutor(5,10,1,TimeUnit.SECONDS,new ArrayBlockingQueue<>(10),new ThreadPoolExecutor.AbortPolicy());

        Runnable runnable=new ThreadPool();
        for(int i=0;i<10;i++){

         executor.execute(runnable);
        }

        executor.shutdown();

    }

}
