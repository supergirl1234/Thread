package ThreadOperation;

/**
 * Author:Fanleilei
 * Created:2019/6/29 0029
 */

class MySleepTest implements Runnable {


    @Override
    public void run() {
        for(int i=0;i<10;i++) {
           /*try {
               //System.out.println("***************");
                Thread.sleep(1000);//线程休眠1S  当前线程立即交出CPU

                System.out.println(Thread.currentThread().getName()+",i="+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

           //线程让步
            Thread.yield();//当前线程不会立即交出CPU
            System.out.println(Thread.currentThread().getName()+",i="+i);

        }
    }
}
public class Test1 {

    public static void main(String[] args) { //main是主线程
        System.out.println("主线程开始");//该句一定是最先执行的，因为此时子线程还没创建
        Runnable runnable=new MySleepTest();
        Thread thread1=new Thread(runnable);//这是三个子线程
        Thread thread2=new Thread(runnable);
        Thread thread3=new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println("主线程执行完毕");//此时，已经创建3个子线程了，所以主线程与子线程并发执行
    }


}
