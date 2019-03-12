package com;

import java.util.concurrent.locks.LockSupport;

/**
 * Author:Fanleilei
 * Created:2019/3/12 0012
 */
public class TestLockSupport {

    public static void main(String[] args) {

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程开始执行");
                // void park()：阻塞当前线程
                LockSupport.park();
                System.out.println("线程结束执行");
            }
        });
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //LockSupport.unpark(thread)可以指定线程对象唤醒指定的线程
        LockSupport.unpark(thread);
    }
}
