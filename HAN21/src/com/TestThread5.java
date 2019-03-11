package com;

/**
 *
 * 通过标记位的方式终止线程
 * Author:Fanleilei
 * Created:2019/3/11 0011
 */
public class TestThread5 {

    public static void main(String[] args){

        Runnable runnable=new MyRunnable();
        Thread thread = new Thread(runnable,"线程1");
        thread.start();
        try {
            //主线程休眠
            Thread.sleep(2000);
            //修改标记位
            ((MyRunnable) runnable).setFlag(false);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       /* //直接调用stop,但这种方法已经过时不用了
        thread.stop();*/


    }
}
class MyRunnable implements Runnable{


    private boolean flag=true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        int i=0;
        while(flag){

            System.out.println(Thread.currentThread().getName()+" 循环第" + ++i +"次");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}