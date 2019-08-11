package com;

public class TestThread1 extends  Thread {

    @Override
    public void run() {
        for(int i=0;i<20;i++){
            System.out.println(Thread.currentThread().getName()+"="+i);
        }
    }

    public static void main(String[] args) {

        TestThread1 thread1=new TestThread1();
        TestThread1 thread2=new TestThread1();
        thread1.start();
        thread2.start();
    }
}
