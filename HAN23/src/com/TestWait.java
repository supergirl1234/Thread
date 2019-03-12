package com;

/**
 *
 *
 * wait()用法
 * Author:Fanleilei
 * Created:2019/3/12 0012
 */
public class TestWait {
    public static void main(String[] args) {
        Object object=new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object){
                    object.notify();//唤醒线程
                }
            }
        }).start();



        synchronized (object) {
            System.out.println("等待中...");
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("等待已过...");
        }
        System.out.println("main方法结束...");

    }


}
