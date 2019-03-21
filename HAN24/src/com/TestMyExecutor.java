package com;

import java.util.concurrent.Executor;

/**
 * Author:Fanleilei
 * Created:2019/3/21 0021
 */
public class TestMyExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        new Thread(command).start();
    }

    public static void main(String[] args) {

        Executor executor=new TestMyExecutor();
        executor.execute(() -> System.out.println("hello"));
        executor.execute(() -> System.out.println("hello"));
        executor.execute(() -> System.out.println("hello"));
    }
}
