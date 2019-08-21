package commmmmm;



public class Test3 {


    public static void main(String[] args) {

        MyRunnable runnable1 = new MyRunnable();
        MyRunnable runnable2 = new MyRunnable();
        Thread thread1 = new Thread(runnable1, "线程1");
        Thread thread2 = new Thread(runnable2, "线程2");
        thread1.start();
        thread2.start();

    }
}

class MyRunnable implements Runnable{

    public synchronized static void test(){

        System.out.println(Thread.currentThread().getName() + "执行开始");

        try {
            Thread.sleep(1000);//让线程休眠一下
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "执行结束");

    }

    @Override
    public void run() {
        MyRunnable.test();
    }

}


