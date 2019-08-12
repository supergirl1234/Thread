package commm;

class Test3 {

    public void test() {
        synchronized (this) {
            for (int i = 0; i <10; i++) {

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

class MyRunnable3 extends Thread {

    public Test3 p;

    public MyRunnable3(Test3 test) {//这样确保只有一个Test对象产生
        this.p = test;
    }
    @Override
    public void run() {

        p.test();
    }
}

public class TestSynchronized5 {

    public static void main(String[] args) {

        Runnable runnable = new MyRunnable3(new Test3());
        Thread thread1= new Thread(runnable,"线程1");
        Thread thread2 = new Thread(runnable,"线程2");
        thread1.start();
        thread2.start();


    }

}


