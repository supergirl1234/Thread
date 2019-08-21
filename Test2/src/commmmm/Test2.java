package commmmm;

public class Test2 {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable("hello");
        Thread thread1 = new Thread(runnable, "线程1");
        Thread thread2 = new Thread(runnable, "线程2");
        thread1.start();
        thread2.start();
    }
}

class MyRunnable implements Runnable {

    String  str=new String();

    public MyRunnable(String str) {
        this.str = str;
    }

    @Override
    public void run() {

        synchronized (str) {
            System.out.println(Thread.currentThread().getName() + "执行开始");

            try {
                Thread.sleep(1000);//让线程休眠一下
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行结束");

        }
    }

}
