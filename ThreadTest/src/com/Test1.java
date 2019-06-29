package com;



/**
 * Author:Fanleilei
 * Created:2019/6/29 0029
 */

class MyTest implements Runnable {


    @Override
    public void run() {
        for(int i=0;i<10;i++) {
            System.out.println(Thread.currentThread().getName()+",i="+i);
        }
    }
}
public class Test1 {

    public static void main(String[] args) {

        //给线程命名
        /*Runnable runnable1=new MyTest();
        Thread thread1=new Thread(runnable1,"线程1");
        Thread thread2=new Thread(runnable1);
        thread2.setName("线程2");
        thread1.start();
        thread2.start();*/


        //如果没有给线程命名，则JVM会自己给线程编号，从0开始
        Runnable runnable1=new MyTest();
        Thread thread1=new Thread(runnable1);
        Thread thread2=new Thread(runnable1);

        thread1.start();
        thread2.start();
    }
}
