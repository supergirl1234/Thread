package commmmmm;

import java.util.concurrent.locks.LockSupport;

public class TestLockSupport {

    public static void main(String[] args)  {



        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("++++++++++++start++++++++");
                //void park()：阻塞当前线程
                LockSupport.park();
                System.out.println("++++++++++++end++++++++");
            }
        });

        thread.start();
        try {
            Thread.sleep(10000);
            //void unpark(Thread thread):唤醒处于阻塞状态的指定线程
            LockSupport.unpark(thread);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
