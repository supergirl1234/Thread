package com;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Author:Fanleilei
 * Created:2019/3/11 0011
 */
public class TestThread4 {

    public static void main(String[] args) {

        Runnable runnable=new MyThread4();
        Thread thread=new Thread(runnable,"线程A");
        thread.start();
        //在主线程中调用线程对象昂的的join方法，会阻塞主线程
        //直到调用线程对象的run方法执行完毕，主线程才会继续执行
        try {
            System.out.println(Thread.currentThread().getName());
            System.out.println("主线程睡眠前的时间"+LocalDateTime.now());
            thread.join();
            System.out.println(Thread.currentThread().getName());
            System.out.println("主线程睡眠后的时间"+LocalDateTime.now());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class MyThread4 implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}