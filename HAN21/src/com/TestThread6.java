package com;

/**
 *
 * 使用Thread类中的一个 interrupt() 可以中断线程
 * Author:Fanleilei
 * Created:2019/3/11 0011
 */
public class TestThread6 {

    public static void main(String[] args) {

        Runnable runnable=new MyRunnable2();
        Thread thread=new Thread(runnable,"子线程");
        thread.start();
        try {

            //主线程休眠
            Thread.sleep(3000);
            //主动调用thread方法
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyRunnable2 implements Runnable{


    @Override
    public void run() {
        int i=0;
        while(true){
            System.out.println(Thread.currentThread().getName()+"循环执行第"+ ++i +"次");
            try{
                //判断线程的中断情况
                boolean interruptedStatus=Thread.currentThread().isInterrupted();
                //非阻塞情况
                if(interruptedStatus){
                    break;

                }
                //一个线程在运行状态中，其中断标志被设置为true之后，一旦线程调用了wait、
                //join、sleep方法中的一种，立马抛出一个InterruptedException，且中断标志被程序会自动清除，重新设置为
                //false。
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("阻塞中断："+Thread.currentThread().isInterrupted());
            }
        }
    }
}
