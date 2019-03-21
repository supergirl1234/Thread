package com;

import java.time.LocalDateTime;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author:Fanleilei
 * Created:2019/3/16 0016
 */
public class TestExecutors {

    public static void code1() {

        //newFixedThreadPool  固定大小的线程池
        //适用于：服务器于负载比较重  对资源有限制

        ExecutorService executorService=Executors.newFixedThreadPool(5);
        final AtomicInteger count=new AtomicInteger(0);
        for(int i=0;i<100;i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"="+count.getAndAdd(1));
                }
            });

        }
        executorService.shutdown();
    }

    //newSingleThreadExecutor  单线程池
    //适用于：任务按照顺序执行
    public static void code2(){
        ExecutorService executorService=Executors.newSingleThreadExecutor();

        final AtomicInteger count = new AtomicInteger(0);
        for (int i = 0; i < 100; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " = " + count.getAndAdd(1));
                }
            });
        }
        executorService.shutdown();
    }

    //无限大小的线程池 newCachedThreadPoo
    // 适用于：任务多但执行时间短或者服务器负载比较小
    public static void code3() {
        ExecutorService executorService=Executors.newCachedThreadPool();
        final AtomicInteger count = new AtomicInteger(0);
        for (int i = 0; i < 10_0000; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " = " + count.getAndAdd(1));
                }
            });
        }
        executorService.shutdown();
    }


    //ScheduledThreadPoolExecutor
    //适用于：1.延迟执行任务（一次） 2.周期性执行任务（多次）
    public static void main(String[] args) {
        //任务调度
        ScheduledExecutorService service=Executors.newScheduledThreadPool(5, new ThreadFactory() {
           private final AtomicInteger threadId=new AtomicInteger(1);
            @Override
            public Thread newThread(Runnable r) {
                Thread thread=new Thread(r);
                thread.setName("任务调度线程："+threadId.getAndAdd(1));
                return thread;
            }
        });
        service.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("这是一个一次性任务"+Thread.currentThread().getName());
            }
        },1,TimeUnit.SECONDS);

        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("这是一个周期性任务A"+LocalDateTime.now().toString()+" "+Thread.currentThread().getName());
            }
        },1,2,TimeUnit.SECONDS);


        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("这是一个周期性任务B"+LocalDateTime.now().toString()+" "+Thread.currentThread().getName());
            }
        },1,5,TimeUnit.SECONDS);
    }
}
