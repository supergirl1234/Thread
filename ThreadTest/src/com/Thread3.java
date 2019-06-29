package com;

/**
 * Author:Fanleilei
 * Created:2019/6/29 0029
 */

class MyThread3 extends Thread{

    private String name;
    private int ticket=20;

    public MyThread3(String name) {
        this.name = name;
    }

    //此方法为每个线程都需要执行的任务
    @Override
    public void run() {
        while(ticket>0){

            System.out.println("当前线程为："+name+",还剩下"+ticket--+"票");
        }
    }
}

class MyThread4 implements Runnable{


    private int ticket=20;

    public MyThread4() {

    }

    //此方法为每个线程都需要执行的任务
    @Override
    public void run() {
        while(ticket>0){

            System.out.println("当前线程为："+Thread.currentThread().getName()+",还剩下"+ticket--+"票");
        }
    }
}
public class Thread3 {

    public static void main(String[] args) {
       /* MyThread3 thread1=new MyThread3("黄牛1");
        MyThread3 thread2=new MyThread3("黄牛2");
        MyThread3 thread3=new MyThread3("黄牛3");
        thread1.start();//每一个线程在卖20张票
        thread2.start();
        thread3.start();
*/

        System.out.println("************************");
        MyThread4 thread4=new MyThread4();

        Thread thread41=new Thread(thread4);//三个线程共享，一共卖20张票
        Thread thread42=new Thread(thread4);
        Thread thread43=new Thread(thread4);
        thread41.start();
        thread42.start();
        thread43.start();


    }
}
