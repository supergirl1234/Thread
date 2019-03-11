package com;

/**
 * Author:Fanleilei
 * Created:2019/3/11 0011
 */

//synchronized(this)以及非static的synchronized方法，只能防止多个线程同时执行同一个对象的同步
//代码段。
public class TestSThread5 {

    public static void main(String[] args) {
        Thread thread1=new thread5();
        Thread thread2=new thread5();
        thread1.start();
        thread2.start();
//通过上述代码以及运行结果我们可以发现，没有看到synchronized起到作用，三个线程同时运行test()方法
    }
}

class Syn{


    public  synchronized void test(){


            System.out.println("Syn对象的Test方法执行开始：" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Syn对象的Test方法执行结束：" + Thread.currentThread().getName());
    }

}

class thread5 extends Thread{


  //这种情况下，会创建多个对象
    @Override
    public void run() {
        //多个对象，线程每start一次调用该方法，就创建一个Syn对象
        Syn syn=new Syn();
        syn.test();
    }

}