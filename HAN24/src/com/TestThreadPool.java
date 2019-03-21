package com;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author:Fanleilei
 * Created:2019/3/16 0016F
 */
public class TestThreadPool {


    public static void main(String[] args) {

        //通过自定义的方式创建线程池执行器

        ThreadPoolExecutor threadPoolExecutor1=new ThreadPoolExecutor(5,10,1,TimeUnit.SECONDS,new ArrayBlockingQueue<>(15),new ThreadPoolExecutor.DiscardPolicy());


        ThreadPoolExecutor threadPoolExecutor2=new ThreadPoolExecutor(5, 10, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(15), new ThreadFactory() {
            private  final AtomicInteger threadId=new AtomicInteger(1);
            //把创建线程的逻辑交给用户
            @Override
            public Thread newThread(Runnable r) {
                Thread t=new Thread(r);
                t.setName("自定义线程"+String.valueOf(threadId.getAndAdd(1)));
                return t;
            }
        });

        //线程池执行器的任务提交方式
        //execute  提交不需要返回值的任务

        for(int i=0;i<10;i++){
            threadPoolExecutor1.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });


        }


        for(int i=0;i<10;i++){
            threadPoolExecutor2.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });


        }








       //submit  提交带有返回值的任务
        //通过这个future对象可以判断任务是否执行成功，并且可以通过future的get()方法来获取返回值
            Future<Integer> futureTask=threadPoolExecutor1.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return new Random().nextInt(100);
                }
            });

        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //shutdown :平滑关闭线程池
        //shutdownnow：非平滑关闭线程池，有可能正在执行的任务没有完成

        threadPoolExecutor2.shutdownNow();
        System.out.println(threadPoolExecutor2.isShutdown());//true
        System.out.println(threadPoolExecutor2.isTerminated());//true


        //获得当前设备的CPU个数
        System.out.println(Runtime.getRuntime().availableProcessors());


    }
}
