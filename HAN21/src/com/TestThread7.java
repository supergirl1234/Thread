package com;

/**
 * Author:Fanleilei
 * Created:2019/3/11 0011
 */
public class TestThread7 {
    public static void main(String[] args) {

        Runnable runnable=new my();
        Thread thread=new Thread(runnable,"线程1");
        thread.start();
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(4000);
            //thread.sleep(4000);
            System.out.println(Thread.currentThread().getName()+" 1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }





}

class my implements Runnable{


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"  0");
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+" 00");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
