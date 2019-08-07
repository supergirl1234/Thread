package com.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test1 {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        for (int i = 0; i < 10; i++) {

            Thread thread = new Thread(() -> {
                try {
                    lock.lock();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    lock.unlock();
                }
            });
            thread.start();
        }
    }
    }
