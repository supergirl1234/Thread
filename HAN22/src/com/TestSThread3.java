package com;

/**
 * Author:Fanleilei
 * Created:2019/3/11 0011
 */
public class TestSThread3 {

    public static void main(String[] args) {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println("@#"+Thread.currentThread().getName());
            }
        };

        for(int i=0;i<5;i++){

            Thread thread=new Thread(runnable,"Thread-"+i);
            thread.start();
        }


    }
}
