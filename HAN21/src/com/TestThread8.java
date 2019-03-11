package com;

import java.time.LocalDateTime;

/**
 *
 *
 * 深刻了解sleep的用法
 * Author:Fanleilei
 * Created:2019/3/11 0011
 */
public class TestThread8 {

    public static void main(String[] args) {
        Runnable runnable=new MyThread8();
        Thread thread=new Thread(runnable,"线程A");
        System.out.println("\n Thread is starting");
        thread.start();

        try {
            System.out.println("当前时间3："+LocalDateTime.now());
            Thread.sleep(1000);//主线程休眠1S
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前时间4："+LocalDateTime.now());
        System.out.println("主线程已经休眠2秒"+Thread.currentThread().getName());
    }
}

class MyThread8 implements Runnable{


    @Override
    public void run() {

        for(int i=0;i<4;i++){
            try {
                System.out.println("当前时间1："+LocalDateTime.now());
                System.out.println(Thread.currentThread().getName()+"休眠0.5秒");
                Thread.sleep(500);//子线程休眠0.5S
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前时间2："+LocalDateTime.now());
            System.out.println("当前运行的线程名称:"+Thread.currentThread().getName());

        }

    }
}
