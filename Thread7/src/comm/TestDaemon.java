package comm;

import sun.management.snmp.jvmmib.EnumJvmThreadCpuTimeMonitoring;

public class TestDaemon implements  Runnable {
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName());

        }


    }

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().isDaemon());//false
        /*主线程不是守护线程*/

        Runnable runnable=new TestDaemon();
        Thread thread1=new Thread(runnable,"线程1");
        System.out.println(thread1.isDaemon());//false

        Thread thread2=new Thread(runnable,"线程2");
        thread2.setDaemon(true);//将thread2设为守护线程

        thread1.start();
        thread2.start();
        try {
            thread2.interrupt();
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
