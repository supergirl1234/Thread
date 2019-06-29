package ThreadOperation;

/**
 * Author:Fanleilei
 * Created:2019/6/29 0029
 */
class MyTest implements Runnable {


    private boolean flag = true;
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            try {
                Thread.sleep(200);
                boolean bool=Thread.currentThread().isInterrupted();

                if(bool){

                    System.out.println("线程已被置为中断状态");
                    return;
                }
                System.out.println("当前线程状态为："+bool);
                System.out.println(Thread.currentThread().getName() + ",i=" + i);
                i++;
            } catch (InterruptedException e) {
                /*boolean bool=Thread.currentThread().isInterrupted();

                if(bool){

                    System.out.println("线程已被置为中断状态");
                    return;
                }
                System.out.println("当前线程状态为："+bool);
                System.out.println(Thread.currentThread().getName() + ",i=" + i);
                i++;
                e.printStackTrace();*/

                //再catch中return
                System.out.println("抛出中断异常");
                return;
            }

        }
        System.out.println("线程停止");
    }
}

public class Test5 {

    public static void main(String[] args) {
        MyTest runnable=new MyTest();
        Thread thread=new Thread(runnable);
        thread.start();
        try {
            Thread.sleep(1000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

