package com.thread;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class myThread implements Runnable {

    private int ticket = 500;
    /*创建锁*/
    Lock lock=new ReentrantLock();
    @Override
    public void run() {
         for(int i=0;i<500;i++){
             if(ticket>0){
                 lock.lock();
                 try {
                     try {
                         Thread.sleep(100);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     System.out.println(Thread.currentThread().getName() + "还剩" + ticket-- + "张票");
                 }finally{

                     lock.unlock();
                 }

             }
         }
    }
}

public class TestLock {


    public static void main(String[] args) {

        myThread myThread=new myThread();
        Thread thread1=new Thread(myThread,"黄牛A");
        Thread thread2=new Thread(myThread,"黄牛B");
        Thread thread3=new Thread(myThread,"黄牛C");
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
