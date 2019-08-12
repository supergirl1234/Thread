package comm;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TestTimer {

    public static void run1(){
        Timer timer=new Timer();
        final AtomicInteger  num=new AtomicInteger();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"-"+num.getAndAdd(1));
            }
        },1000,10);

    }

    public static void run2(){
        Timer timer=new Timer();
        final AtomicInteger  num=new AtomicInteger();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"-"+num.getAndAdd(1));
            }
        },1000,10);

    }
    public static void main(String[] args) {
        //run1();
        run2();
    }
}
