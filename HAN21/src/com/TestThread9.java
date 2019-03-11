package com;

/**
 *
 * 线程优先级
 * Author:Fanleilei
 * Created:2019/3/11 0011
 */
//线程的优先级指的是，线程的优先级越高越有可能先执行，但仅仅是有可能而已。
public class TestThread9 {

    public static void main(String[] args) {
        //主线程的优先级
        System.out.println("主线程的优先级："+Thread.currentThread().getPriority());//5


        ////在主线程中创建一个线程，并且不指定优先级
        Thread thread=new Thread(() -> System.out.println(Thread.currentThread().getName()+"优先级是："+Thread.currentThread().getPriority()));//优先级默认也是5
         //给线程设置优先级
        //thread.setPriority(7);
        thread.start();


        Runnable runnable = new PriorityRunnable();
        Thread threadA = new Thread(runnable, "Thread-A");
        threadA.setPriority(Thread.MAX_PRIORITY);//最大优先级 10

        Thread threadB = new Thread(runnable, "Thread-B");
        threadB.setPriority(Thread.NORM_PRIORITY);//中等优先级 5

        Thread threadC = new Thread(runnable, "Thread-C");
        threadC.setPriority(Thread.MIN_PRIORITY);//最小优先级 1

        threadA.start();
        threadB.start();
        threadC.start();

    }



}

class PriorityRunnable implements Runnable{


    @Override
    public void run() {
        Thread thread=new Thread();
        System.out.println(thread.getName()+"优先级是："+thread.getPriority());
    }
}
