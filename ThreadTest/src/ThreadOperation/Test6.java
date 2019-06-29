package ThreadOperation;

/**
 * Author:Fanleilei
 * Created:2019/6/29 0029
 */

class PriorityThread implements Runnable{


   /* @Override
    public void run() {
        for(int i=0;i<3;i++) {
            System.out.println(Thread.currentThread().getName() + ",i=" + i);
        }
    }*/

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+",优先级为："+Thread.currentThread().getPriority());
        new Thread(new PriorityThread(),"孙子线程B").start();
    }

}


public class Test6 {

    public static void main(String[] args) {
       // System.out.println(Thread.currentThread().getPriority());//5

        /*PriorityThread priorityThread=new PriorityThread();
        Thread thread1=new Thread(priorityThread);
        Thread thread2=new Thread(priorityThread);
        Thread thread3=new Thread(priorityThread);
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread3.setPriority(Thread.NORM_PRIORITY);
        thread1.start();
        thread2.start();
        thread3.start();*/


        PriorityThread priorityThread=new PriorityThread();
        Thread thread1=new Thread(priorityThread,"子线程A");
        thread1.setPriority(10);
        thread1.start();

    }
}
