package com;

/**
 * Author:Fanleilei
 * Created:2019/6/29 0029
 */

class MyThread extends Thread{

     private String name;

    public MyThread(String name) {
        this.name = name;
    }

    //此方法为每个线程都需要执行的任务
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("当前线程为："+name+","+i);

        }
    }
}
public class Thread1 {

    public static void main(String[] args) {
        //创建线程
        MyThread thread1=new MyThread("子线程1");
        MyThread thread2=new MyThread("子线程2");
        MyThread thread3=new MyThread("子线程3");

       /* thread1.run();
        thread2.run();
        thread3.run();*/


       //启动线程一律使用Thread提供的start()，run()方法不能通过用户直接用！
       thread1.start();  //start方法将线程由创建状态转化为就绪状态，线程到底被不被运行，取决于CPU
       thread2.start();
       thread3.start();

       //thread1.start();

    }
}
