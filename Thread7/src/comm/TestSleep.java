package comm;

import com.ThreadPool;

public class TestSleep {

    public static void run1(){

        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Thread thread1=new Thread(runnable);
        Thread thread2=new Thread(runnable);
        thread1.start();
        thread2.start();
    }

    public static  void run2(){

        Runnable runnable=new Runnable() {
            @Override
            public synchronized void run() {
                try {
                    Thread.sleep(10000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Thread th1=new Thread(runnable);
        Thread th2=new Thread(runnable);
        th1.start();
        th2.start();
    }
    public static void main(String[] args) {

       // run1();
        run2();
        /*这两个效果是不一样的,因为run2中加锁了，sleep不会释放对象锁*/

    }
}
