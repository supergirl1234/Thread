package com;

/**
 * Author:Fanleilei
 * Created:2019/3/11 0011
 */

//锁同一个对象
public class TestSThread6 {

    public static void main(String[] args) {
        //只要锁住同一个对象,只有一个Syn6对象
        Syn6 syn6=new Syn6();
        Thread thread1=new MyThread6(syn6);
        thread1.setName("线程1");
        Thread thread2=new MyThread6(syn6);
        thread2.setName("线程2");
        Thread thread3=new MyThread6(syn6);
        thread3.setName("线程3");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class Syn6{

    //该方法中，synchronized同步的是Syn6的对象的方法
   /* public synchronized void test() {
        System.out.println("Sync对象的Test方法执行开始：" + Thread.currentThread().getName());
        try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         System.out.println("Sync对象的Test方法执行结束：" + Thread.currentThread().getName());
     }
*/

   //在该方法中，synchronized(this)同步的是Syn6de1对象
    public void test() {
        synchronized(this) {
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
class MyThread6 extends Thread{

    private  Syn6 syn;

    public MyThread6(Syn6 syn) {
        this.syn = syn;
    }

    @Override
    public void run() {
        syn.test();
    }
}