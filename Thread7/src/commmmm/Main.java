package commmmm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        Queue<Goods> queue=new LinkedList<>();
        Object monitor=new Object();
        AtomicInteger count=new AtomicInteger(0);
        Runnable consumer1=new Consumer(queue,monitor);
        Runnable consumer2=new Consumer(queue,monitor);
        Runnable consumer3=new Consumer(queue,monitor);
        Runnable producer1=new Producer(queue,monitor,count);
        Runnable producer2=new Producer(queue,monitor,count);

        Thread thread1=new Thread(consumer1,"消费者1");
        Thread thread2=new Thread(consumer2,"消费者2");
        Thread thread3=new Thread(consumer3,"消费者3");
        Thread thread4=new Thread(producer1,"生产者1");
        Thread thread5=new Thread(producer1,"生产者2");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
