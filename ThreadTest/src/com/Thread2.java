package com;

/**
 * Author:Fanleilei
 * Created:2019/6/29 0029
 */

class MyThread2 implements Runnable{

    private String name;

    public MyThread2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("当前线程为："+name+","+i);

        }
    }
}
public class Thread2 {

    public static void main(String[] args) {

        MyThread2 myThread1 = new MyThread2("子线程1");
        MyThread2 myThread2 = new MyThread2("子线程2");
        MyThread2 myThread3 = new MyThread2("子线程3");


        Thread thread1 = new Thread(myThread1);
        Thread thread2 = new Thread(myThread2);
        Thread thread3 = new Thread(myThread3);
        thread1.start();
        thread2.start();
        thread3.start();
    }


}
