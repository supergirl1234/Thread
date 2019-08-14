package comm;

public class TestJoin {

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                for(int i=10;i>0;i--){

                    System.out.println(Thread.currentThread().getName()+"="+i);
                }
            }
        };

        Thread thread1=new Thread(runnable,"线程1");
        Thread thread2=new Thread(runnable,"线程2");
        thread1.start();
        thread2.start();

        thread1.join();
        System.out.println("当前线程："+Thread.currentThread().getName());


    }
}
