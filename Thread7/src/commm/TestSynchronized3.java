package commm;


class Test {

    public void test() {
        synchronized (this) {
            for (int i = 0; i < 3; i++) {

                System.out.println(Thread.currentThread().getName() + "-" + i);
            }
        }
    }


}

class MyRunnable extends Thread {

    @Override
    public void run() {
        Test p = new Test();
        p.test();
    }
}

public class TestSynchronized3 {

    public static void main(String[] args) {

        Runnable runnable = new MyRunnable();
        Thread thread1= new Thread(runnable,"线程1");
        Thread thread2 = new Thread(runnable,"线程2");
        thread1.start();
        thread2.start();
        /*可以发现，这两个线程是同时进行的，同时进到了for循环中*/

    }

}




