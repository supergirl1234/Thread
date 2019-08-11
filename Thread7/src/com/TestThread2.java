package com;

public class TestThread2  implements Runnable{


    @Override
    public void run() {

        for(int i=0;i<10;i++){

            System.out.println(Thread.currentThread().getName()+"="+i);
        }
    }

    public static void main(String[] args) {

        Runnable runnable=new TestThread2();
        Thread thread1=new Thread(runnable);
        Thread thread2=new Thread(runnable);
        thread1.start();
        thread2.start();
    }
}
