package comm;

import java.util.concurrent.atomic.AtomicInteger;

public class TestTerminate implements Runnable {
   boolean flag=true;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        AtomicInteger num=new AtomicInteger(0);
        while(flag){

            System.out.println(Thread.currentThread().getName()+"-"+num.getAndAdd(1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {

        TestTerminate runnable=new TestTerminate();
        Thread thread1=new Thread(runnable,"线程1");
        Thread thread2=new Thread(runnable,"线程2");
        thread1.start();
        thread2.start();
        Thread.sleep(10000);//主线程休眠个10000毫秒后，将flag修改为false，就无法执行while语句内的内容了，就终止了
        runnable.setFlag(false);
    }
}
