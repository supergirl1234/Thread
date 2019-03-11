package com;

/**
 *
 *
 * 实际上，synchronized(this)以及非static的synchronized方法，只能防止多个线程同时执行同一个对象的同步
 * 代码段。即synchronized锁住的是括号里的对象，而不是代码。对于非static的synchronized方法，锁的就是对
 * 象本身也就是this。
 * Author:Fanleilei
 * Created:2019/3/11 0011
 */


//通过上述代码以及运行结果我们可以发现，没有看到synchronized起到作用，三个线程同时运行run方法
//这是因为synchronized(this)以及非static的synchronized方法，只能防止多个线程同时执行同一个对象的同步
//代码段；而Runnable对象有多个
public class TestSThread4 {

    public static void main(String[] args) {


            Runnable runnable1=new TicketRunnable4();
            Runnable runnable2=new TicketRunnable4();
            Runnable runnable3=new TicketRunnable4();

            Thread thread1=new Thread(runnable1,"黄牛1");
            Thread thread2=new Thread(runnable2,"黄牛2");
            Thread thread3=new Thread(runnable3,"黄牛3");

            thread1.start();
            thread2.start();
            thread3.start();
    }
}
class TicketRunnable4 implements Runnable {


    //默认有10张票
    private int ticket = 10;
     @Override
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
    }
}