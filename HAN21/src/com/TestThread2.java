package com;

/**
 * Author:Fanleilei
 * Created:2019/3/11 0011
 */
public class TestThread2 {

    public static void main(String[] args) {

       System.out.println(Thread.currentThread().getName()+" 2");
        Runnable runnable=new MyThread1();
        Thread thread1=new Thread(runnable,"线程1");
        thread1.start();
        System.out.println(Thread.currentThread().getName()+" 3");
        try {
            Thread.sleep(4000);
            System.out.println(Thread.currentThread().getName()+" 4");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("-----------------------------");
       Runnable runnable1=new MyThread2();
       new Thread(runnable1,"线程2").start();
       new Thread(runnable1,"线程3").start();
       new Thread(runnable1,"线程4").start();
    }
}


class MyThread1 implements Runnable{


    @Override
    public void run() {

        try {
            System.out.println(Thread.currentThread().getName());
             //线程休眠会交出CPU，让CPU去执行其他的任务。
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " 1");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread2 implements Runnable {

    @Override
    public void run() {
        for(int i=0;i<3;i++){
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+" i="+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
