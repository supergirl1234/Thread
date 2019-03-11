package com;

/**
 * Author:Fanleilei
 * Created:2019/3/11 0011
 */

//下面这种卖票的方式是错误的
public class TestSthread1 {

    public static void main(String[] args) {
        //共享业务逻辑
        Runnable runnable=new TicketRunnable1();

        Thread thread1=new Thread(runnable,"黄牛A");
        Thread thread2=new Thread(runnable,"黄牛B");
        Thread thread3=new Thread(runnable,"黄牛C");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class TicketRunnable1 implements Runnable{

    //默认有10张票
    private int ticket=10;
    @Override
    public void run() {//这种情况下会出现负数

        while(ticket>0){
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+"还剩"+ticket-- +"张票");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println(Thread.currentThread().getName()+"票已经卖完了");
    }
}
