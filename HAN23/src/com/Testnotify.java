package com;

/**
 * Author:Fanleilei
 * Created:2019/3/12 0012
 */
public class Testnotify {

    public static void main(String[] args) {
        Object object=new Object();//只有一个对象

        new Thread(new MyRunnable(true,object),"生产者A").start();
        new Thread(new MyRunnable(true,object),"生产者B").start();
        new Thread(new MyRunnable(true,object),"生产者C").start();


        new Thread(new MyRunnable(false,object),"消费者1").start();
        new Thread(new MyRunnable(false,object),"消费者2").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

class MyRunnable implements  Runnable{

    //如果true表示生产者
    //如果false表示消费者
    private final boolean flag;
    private Object object;

    public MyRunnable(boolean flag, Object object) {
        this.flag = flag;
        this.object = object;
    }

    @Override
    public void run() {
        if(flag){

          this.waitMethod();
        }else{
            this.notifyMethod();
        }



    }

    private void waitMethod(){
        synchronized (object){
            while(true){
                String name=Thread.currentThread().getName();
                System.out.println(name+"生产者开始");
                try {
                    Thread.sleep(1000);
                    //. wait()方法执行后，当前线程释放锁，线程与其它线程竞争重新获取锁
                    this.object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(name+"生产者结束");
            }


        }


    }

    private void notifyMethod(){
        synchronized (object){


                String name=Thread.currentThread().getName();
                System.out.println(name+"消费者开始");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.object.notifyAll();
                System.out.println(name+"消费者结束");



        }



    }
}
