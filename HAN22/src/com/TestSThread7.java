package com;

/**
 *
 * 全局锁
 * Author:Fanleilei
 * Created:2019/3/11 0011
 */
public class TestSThread7 {

    public static void main(String[] args) {

        Thread thread1=new MyThread7();
        thread1.setName("线程1");
        Thread thread2=new MyThread7();
        thread2.setName("线程2");
        Thread thread3=new MyThread7();
        thread3.setName("线程3");
        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class Syn7{
    public void test(){

        //synchronized(class) 全局锁
        //synchronized(this|obj) 对象锁

        synchronized (Syn7.class){//全局锁
            System.out.println("Sync对象的Test方法执行开始：" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Sync对象的Test方法执行结束：" + Thread.currentThread().getName());

        }
    }
}

class MyThread7 extends Thread{

    @Override
    public void run() {
        Syn7 syn=new Syn7();
        syn.test();
    }
}
