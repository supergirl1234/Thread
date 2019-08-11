package com;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


class RunnableTest implements Runnable {
    public Task task;

    public RunnableTest(Task task) {
        this.task = task;
    }

    List<String> list = new ArrayList<String>() {
        {
            add("java");
            add("门票");
            add("钱");
        }
    };

    @Override
    public void run() {
        this.task.print(Thread.currentThread().getName(),list);
    }


}

class Task {

    public void print(Object... args) {

        for (int i = 0; i < args.length; i++) {

            System.out.println(args[i]);
        }
    }
}
public class TestThread3 {
    public static void main(String[] args) {
        Task task=new Task();
        Runnable runnable=new RunnableTest(task);
        Thread thread1=new Thread(runnable);
        Thread thread2=new Thread(runnable);
        thread1.start();
        thread2.start();


        Thread thread3=new Thread(()->task.print("hello","my","world"));
        thread3.setName("Person");
        System.out.println(thread3.getName());
        thread3.start();
    }

}
