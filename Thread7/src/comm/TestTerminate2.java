package comm;

public class TestTerminate2  {
    public static void main(String[] args) throws InterruptedException {


        Runnable runnable=new MyRunnable();
        Thread thread=new Thread(runnable);
        thread.start();
        Thread.sleep(3000);
        thread.interrupt();
    }
}

class MyRunnable implements Runnable{
    int i=0;
    @Override
    public void run() {
        while(true){
            System.out.println(Thread.currentThread().getName() + "  循环执行第 " + ++i + " 次");
           try {

                //判断线程的中断情况
                boolean interruptedStatus = Thread.currentThread().isInterrupted();

                //非阻塞情况
                if (interruptedStatus) {

                    break;
                }
                Thread.sleep(1000);

           } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("阻塞中断：" + Thread.currentThread().isInterrupted());//false
                return;
            }

        }
    }
}
