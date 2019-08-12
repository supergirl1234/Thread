package comm;

import com.ThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TestExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        Thread thread=new Thread(command);
        System.out.println(Thread.currentThread().getName());//main
        thread.start();
    }

    public static void main(String[] args) {

        TestExecutor p=new TestExecutor();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"hello");
            }
        };
        p.execute(runnable);
    }
}
