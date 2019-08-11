package com;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestThread4 implements Callable {

    int AllTotall=100;
    @Override
    public Object call() throws Exception {
        while(AllTotall>=0) {
            System.out.println(Thread.currentThread().getName()+"="+AllTotall);
            AllTotall--;
        }
        return "变为了负数";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable callable=new TestThread4();
        FutureTask futureTask=new FutureTask(callable);
        Thread thread=new Thread(futureTask);
        thread.start();

        Object object=futureTask.get();//接收返回值
        System.out.println(object);

        System.out.println(Thread.currentThread().getName());//main
    }
}
