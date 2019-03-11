package com;

/**
 *
 * Author:Fanleilei
 * Created:2019/3/11 0011
 */
public class TestThread1 {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());//main
        Runnable runnable=new MyThread();
        new Thread(runnable,"线程1").start();//Thread.currentThread().getName()为线程1
        new Thread(runnable,"线程2").start();//Thread.currentThread().getName()为线程2
        new Thread(runnable,"线程3").start();//Thread.currentThread().getName()为线程3

    }
}


class MyThread implements  Runnable{


    @Override
    public void run() {
        for(int i=0;i<3;i++)
        System.out.println(Thread.currentThread().getName()+" i="+i);
    }
}
