package comm;

public class TestYield2  implements  Runnable{
    @Override
    public synchronized void run() {

        for(int i=0;i<5;i++) {
            Thread.yield();
            System.out.println(Thread.currentThread().getName()+"="+i);
        }

    }
    public static void main(String[] args) {

        Runnable runnable=new TestYield2();

        Thread thread1=new Thread(runnable,"线程1");
        Thread thread2=new Thread(runnable,"线程2");
        Thread thread3=new Thread(runnable,"线程3");
        thread1.start();
        thread2.start();
        thread3.start();
    }

}
