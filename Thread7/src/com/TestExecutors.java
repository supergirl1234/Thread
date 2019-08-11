package com;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TestExecutors {


    public static void Run1(){

        /*newFixedThreadPool*/

        ExecutorService executorService=Executors.newFixedThreadPool(20);
        final AtomicInteger num=new AtomicInteger(0);
        for(int i=0;i<100;i++){

            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"="+num.getAndAdd(1));
                }
            });
        }
        executorService.shutdown();
    }

    public static void Run2(){

        /*newSingleThreadExecutor*/

        ExecutorService executorService=Executors.newSingleThreadExecutor();
        final AtomicInteger num=new AtomicInteger(0);
        for(int i=0;i<100;i++){

            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"="+num.getAndAdd(1));
                }
            });
        }
        executorService.shutdown();
    }

    public static void Run3(){

        /*newCachedThreadPool*/

        ExecutorService executorService=Executors.newCachedThreadPool();
        final AtomicInteger num=new AtomicInteger(0);
        for(int i=0;i<1000;i++){

            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"="+num.getAndAdd(1));
                }
            });
        }
        executorService.shutdown();
    }

    public static void Run4(){

        /*newScheduledThreadPool*/

        ScheduledExecutorService executorService=Executors.newScheduledThreadPool(5, new ThreadFactory() {
            int i=0;
            @Override
            public Thread newThread(Runnable r) {

                Thread thread=new Thread(r);
                thread.setName("Thread-"+i);
                i++;
                return thread;
            }
        });

       executorService.schedule( //只调用一次
               new Runnable() {
                   @Override
                   public void run() {
                       System.out.println(Thread.currentThread().getName());
                   }
               },1, TimeUnit.SECONDS);//1秒之后再调用


    }

    public static void Run5() {

        /*newScheduledThreadPool*/

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(4, new ThreadFactory() {
            int i = 0;

            @Override
            public Thread newThread(Runnable r) {

                Thread thread = new Thread(r);
                thread.setName("Thread-" + i);
                i++;
                return thread;
            }
        });


        executorService.scheduleAtFixedRate(//一个周期型任务

                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName());
                    }
                }, 1, 2, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        //Run1();
        //Run2();
        // Run3();
        //Run4();
        Run5();

    }



}
