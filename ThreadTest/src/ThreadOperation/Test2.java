package ThreadOperation;

/**
 * Author:Fanleilei
 * Created:2019/6/29 0029
 */
public class Test2 {

    public static void main(String[] args) {
        try {
            System.out.println("主线程开始");
            Runnable runnable=new MySleepTest();
            Thread thread1=new Thread(runnable);

            thread1.start();

            //线程等待，等子线程执行完毕之后，主线程再执行
            thread1.join();

            System.out.println("主线程执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
