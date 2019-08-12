package comm;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TestThreadPool {
    public static void run1() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 2, TimeUnit.SECONDS, new ArrayBlockingQueue<>(20), new ThreadPoolExecutor.DiscardPolicy());
        final AtomicInteger count = new AtomicInteger(0);
        for (int i = 10; i >= 0; i--) {
            executor.execute(new Runnable() {//execute提交没有返回值的任务
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "_" + count.getAndAdd(1));
                }
            });
        }
    }

    public static void run2() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 2, TimeUnit.SECONDS, new ArrayBlockingQueue<>(20), new ThreadPoolExecutor.DiscardPolicy());
        final AtomicInteger count = new AtomicInteger(0);
        for (int i = 10; i >= 0; i--) {
            Future futureTask = executor.submit(new Callable<Object>() {//submit提交有返回值的任务
                @Override
                public Object call() {
                    return Thread.currentThread().getName() + "-" + count.getAndAdd(1);
                }
            });
            System.out.println(futureTask.get());
        }
    }

    public static void run3() {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 2, TimeUnit.SECONDS, new ArrayBlockingQueue<>(20), new ThreadPoolExecutor.DiscardPolicy());
        final AtomicInteger count = new AtomicInteger(0);
        for (int i = 10; i >= 0; i--) {
            Future<Object> submit = executor.submit((Callable<Object>) new Callable<Object>() {
                @Override
                public Object call() {
                    if (count.getAndAdd(1) > 5) {
                        System.out.println(Thread.currentThread().getName() + "-" + count.getAndAdd(1));
                    }

                    return -1;

                }

            });

        }
    }

    public static void run4() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,
                10,
                2,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(15),
                new ThreadFactory() {
                    private  AtomicInteger Id = new AtomicInteger(0);

                    @Override
                    public Thread newThread(Runnable r) {

                        Thread thread = new Thread(r);
                        thread.setName("线程-" + String.valueOf(Id.getAndAdd(1)));

                        return thread;

                    }

                });

        executor.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName());
                }
            }
        });
        executor.shutdown();
      /*  System.out.println(executor.isShutdown());//true*/
        System.out.println(executor.isTerminated());//false


      /*  executor.shutdownNow();
        System.out.println(executor.isShutdown());//true
        System.out.println(executor.isTerminated());//false*/

      /*shutdownNow首先将线程池的状态设置成STOP，然后尝试停止所有的正在执行或暂停任务的线程，并返回等待执
行任务的列表。
shutdown只是将线程池的状态设置成SHUTDOWN状态，然后中断所有没有正在执行任务的线程。*/
      /*只要调用了这两个关闭方法中的任意一个， isShutdown方法就会返回true。当所有的任务都已关闭后，才表示线
程池关闭成功，这时调用isTerminaed方法会返回true。*/
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //run1();
        // run2();
        // run3();
        run4();

    }
}
