package ThreadOperation;

/**
 * Author:Fanleilei
 * Created:2019/6/29 0029
 */

class MyDaemonThread implements Runnable{


    @Override
    public void run() {
        while(true){

            System.out.println("当前线程是否为守护线程"+Thread.currentThread().isDaemon());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("当前线程是否为守护线程"+Thread.currentThread().isDaemon());
                System.out.println("线程被终止");
                return;
            }

        }
    }
}
public class Test7 {

    public static void main(String[] args) {

        MyDaemonThread myDaemonThread=new MyDaemonThread();
        Thread thread1=new Thread(myDaemonThread);
        Thread thread2=new Thread(myDaemonThread);
        thread1.setDaemon(true);
        thread1.start();
        thread2.start();

        try {
            Thread.sleep(1000);

            //中断thread2
            thread2.interrupt();
            Thread.sleep(5000);
            System.out.println("代码结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
