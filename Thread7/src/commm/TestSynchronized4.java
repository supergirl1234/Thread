package commm;

class Test2 {

        public void test() {
            synchronized (Test2.class) {//锁住这个类的Clss对象，一个类的Class对象只有一个   这样就能保证一次只有一个对象能进入该方法内
                for (int i = 0; i < 3; i++) {

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "-" + i);
                }
            }
        }


    }

    class MyRunnable2 extends Thread {

        @Override
        public void run() {
        Test2 p = new Test2();
        p.test();
    }
}

public class TestSynchronized4 {

    public static void main(String[] args) {

        Runnable runnable = new MyRunnable2();
        Thread thread1= new Thread(runnable,"线程1");
        Thread thread2 = new Thread(runnable,"线程2");
        thread1.start();
        thread2.start();

    }

}


