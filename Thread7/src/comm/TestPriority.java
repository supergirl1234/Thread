package comm;

import static java.lang.Thread.MAX_PRIORITY;
import static java.lang.Thread.MIN_PRIORITY;
import static java.lang.Thread.NORM_PRIORITY;

public class TestPriority  implements Runnable{

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+"优先级是"+Thread.currentThread().getPriority());
    }
    public static void main(String[] args) {

        Runnable runnable=new TestPriority();
        Thread thread1=new Thread(runnable,"线程1");
        Thread thread2=new Thread(runnable,"线程2");

        Thread thread=new Thread();
        thread1.start();
        thread2.start();
        thread.start();
        System.out.println("thread的优先级是"+thread.getPriority());
        System.out.println("主线程的优先级："+Thread.currentThread().getPriority());

        System.out.println(MAX_PRIORITY);//10
        System.out.println(MIN_PRIORITY);//1
        System.out.println(NORM_PRIORITY);//5

    }


}
