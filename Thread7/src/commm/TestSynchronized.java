package commm;

public class TestSynchronized  implements  Runnable {


    private  int ticket=100;
    @Override
    public synchronized void run() {

        while(ticket>0){

            System.out.println(Thread.currentThread().getName()+"还剩"+ticket--+"张票");
        }
    }

    public static void main(String[] args) {
        Runnable runnable=new TestSynchronized();
        Thread thread1=new Thread(runnable);
        Thread thread2=new Thread(runnable);
        Thread thread3=new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
