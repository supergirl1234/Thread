package com;

/**
 * Author:Fanleilei
 * Created:2019/3/11 0011
 */


//所谓的同步指的是所有的线程不是一起进入到方法中执行，而是按照顺序一个一个进来
//同步虽然可以保证数据的完整性（线程安全操作），但是其执行的速度会很慢
public class TestSThread2 {

    public static void main(String[] args) {
        //共享业务逻辑
        Runnable runnable=new TicketRunnable2();

        Thread thread1=new Thread(runnable,"黄牛1");
        Thread thread2=new Thread(runnable,"黄牛2");
        Thread thread3=new Thread(runnable,"黄牛3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class TicketRunnable2 implements Runnable{


    //默认有10张票
   private int ticket=10;
    /*@Override
    public void run() {
        for(int i=0;i<10;i++) {
            //使用同步代码块 : 如果要使用同步代码块必须设置一个要锁定的对象，所以一般可以锁定当前对象:this
            // 在同一时刻，只允许一个线程进入代码块处理
            synchronized (this) {//Runnable对象
                if (ticket > 0) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + "还剩" + ticket-- + "张票");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
        System.out.println(Thread.currentThread().getName()+"票已经卖完了");
    }*/

    /*@Override
    public void run() {
        for(int i=0;i<10;i++) {
            System.out.println("------------------------");
            // 在同一时刻，只允许一个线程进入代码块处理
            synchronized (this) {//Runnable对象
                if (ticket > 0) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + "还剩" + ticket-- + "张票");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
        System.out.println(Thread.currentThread().getName()+"票已经卖完了");
    }*/


    //同步方法
    /*@Override
    public synchronized void run() {
        for(int i=0;i<10;i++) {
            // 在同一时刻，只允许一个线程进入代码块处理

                if (ticket > 0) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + "还剩" + ticket-- + "张票");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

        }
        System.out.println(Thread.currentThread().getName()+"票已经卖完了");
    }*/

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){

            System.out.println("----------------------");
            sale();
        }

    }
    private  synchronized void sale(){

        while(ticket>0){
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "还剩" + ticket-- + "张票");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println(Thread.currentThread().getName()+"票已经卖完了");


    }

}
