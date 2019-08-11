package com;

public class TestThread5 implements Runnable {
    @Override
    public void run() {
        System.out.println("12345");
    }

    public static void main(String[] args) {
       /* Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };*/

        Runnable runnable= () -> System.out.println(Thread.currentThread().getName());

        Thread thread1=new Thread(runnable);
        thread1.start();//执行的是    Runnable runnable= () -> System.out.println(Thread.currentThread().getName());这行语句

        Thread thread2=new Thread(runnable);
        thread2.start();//执行的是    Runnable runnable= () -> System.out.println(Thread.currentThread().getName());这行语句
    }
}
