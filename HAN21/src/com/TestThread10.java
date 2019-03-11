package com;

/**
 *
 *
 * 守护线程与非守护线程
 * Author:Fanleilei
 * Created:2019/3/11 0011
 */
//典型的守护线程就是垃圾回收线程。只要当前JVM进程中存在任何一个非守护线程没有结束，守护线程就在工作；只有当
//最后一个非守护线程结束时，守护线程才会随着JVM一同停止工作。
public class TestThread10 {

    public static void main(String[] args) {
        //主线程不是守护线程
        System.out.println("主线程是否是守护线程："+Thread.currentThread().isDaemon());//false

        Runnable runnable1=new DaemonRunnable();
        Thread thread1=new Thread(runnable1,"线程1");
        //将线程设置为守护线程，该方法必须在start方法前调用
        thread1.setDaemon(true);

        Runnable runnable2=new DaemonRunnable();
        Thread thread2=new Thread(runnable2,"线程2");

        thread1.start();
        thread2.start();

        //主线程
        try {
            Thread.sleep(3000);
            thread2.interrupt();//thread2线程中断后，还在运行，因为它是守护线程，还有其他用户线程(主线程)还在运行
            //说明是所有的用户线程结束之后守护线程才会结束

            Thread.sleep(3000);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

class DaemonRunnable implements Runnable{
    @Override
    public void run() {
        int i=0;
        while(true){
            System.out.println(Thread.currentThread().getName()+"调用第"+ ++i +"次");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+" 中断");
            }
        }
    }
}