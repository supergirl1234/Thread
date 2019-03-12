package com;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author:Fanleilei
 * Created:2019/3/11 0011
 */
public class ProducerCustomer {

    public static void main(String[] args) {

        Queue<Goods> goods=new LinkedList<>();
        AtomicInteger goodsName=new AtomicInteger(1);
        Object monitor=new Object();


        Producer producer1=new Producer(goods,monitor,goodsName);
        Producer producer2=new Producer(goods,monitor,goodsName);
        Customer customer=new Customer(goods,monitor);

        new Thread(producer1,"生产者1").start();
        new Thread(producer2,"生产者2").start();
        new Thread(customer,"消费者").start();




    }
}

//商品类
class Goods{

    private final String name;

    public Goods(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                '}';
    }
}
//生产者
class Producer implements Runnable{

    private final Queue<Goods> goods;//队列
    private final Object monitor;
    private final AtomicInteger atomicInteger;

    public Producer(Queue<Goods> goods, Object monitor, AtomicInteger atomicInteger) {
        this.goods = goods;
        this.monitor = monitor;
        this.atomicInteger = atomicInteger;
    }

    @Override
    public void run() {

        while(true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (monitor){
                if(goods.size()==10){
                    //队列满了
                    try {
                        this.monitor.wait();//等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {

                    //队列未满
                    Goods goods = new Goods(String.valueOf(atomicInteger.getAndAdd(1)));
                    this.goods.add(goods);
                    System.out.println(Thread.currentThread().getName() + "生产" + goods);
                }
            }



        }

    }
}

//消费者
class Customer implements Runnable{

    private final Queue<Goods> goods;
    private final Object monitor;

    public Customer(Queue<Goods> goods, Object monitor) {
        this.goods = goods;
        this.monitor = monitor;
    }

    @Override
    public void run() {



            while(true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (monitor){
                    if (this.goods.isEmpty()) {
                        //队列空了，则唤醒生产线程
                        this.monitor.notify();
                    } else {
                        //消费商品
                        Goods goods = this.goods.poll();
                        System.out.println("消费者消费：" + goods);

                    }
                }
            }


    }
}
