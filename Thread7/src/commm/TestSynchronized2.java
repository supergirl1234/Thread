package commm;

public class TestSynchronized2 implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        synchronized (this) {//Runnable对象
            while (ticket > 0) {
                try {
                    Thread.sleep(1000);//sleep不会释放对象锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "还剩" + ticket-- + "张票");
            }
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new TestSynchronized();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
