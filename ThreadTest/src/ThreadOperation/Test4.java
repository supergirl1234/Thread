package ThreadOperation;

/**
 * Author:Fanleilei
 * Created:2019/6/29 0029
 */

class MyThread implements Runnable {


    private boolean flag = true;
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        int i = 0;
        while (flag) {

            boolean bool=Thread.currentThread().isInterrupted();//取得线程的状态

            if(bool){
                //一旦线程的状态有false变为true，就return结束该线程
                System.out.println("线程已被置为中断状态");
                return;
            }
            System.out.println("当前线程状态为："+bool);
            System.out.println(Thread.currentThread().getName() + ",i=" + i);
            i++;


        }
        System.out.println("线程停止");
    }
}

public class Test4 {

    public static void main(String[] args) {
        MyThread runnable=new MyThread();
        Thread thread=new Thread(runnable);
        thread.start();
        try {
            Thread.sleep(1000);
            thread.interrupt();//若线程中没有使用类似sleep、wait、join时，只是改变线程的状态，改为true
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
