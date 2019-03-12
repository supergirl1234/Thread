package com;

/**
 * Author:Fanleilei
 * Created:2019/3/12 0012
 */
public class Testwaitnotify {

    public static void main(String[] args) {

        Object object=new Object();
        new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (object){

                    System.out.println("线程1启动");
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程1结束");
                }

            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (object){

                    System.out.println("线程2启动");

                        object.notify();

                    System.out.println("线程2结束");
                }

            }
        }).start();
    }
}


//运行结果为：
//线程1启动
//线程2启动
//线程2结束
//线程1结束
//且说明了在notify()方法后，当前线程不会马上释放该对象锁，要等到执行notify()方法的线程将程序执行完，也就是退
//出同步代码块之后才会释放对象锁
