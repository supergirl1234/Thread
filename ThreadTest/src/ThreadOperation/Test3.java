package ThreadOperation;

/**
 * Author:Fanleilei
 * Created:2019/6/29 0029
 */
//线程停止
class MyStopThread implements Runnable{

   //设置标志位
    private  boolean flag=true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        int i=0;
        while(flag){
            System.out.println(Thread.currentThread().getName()+",i="+i);
            i++;


        }
        System.out.println("线程停止");
    }
}
public class Test3 {

    public static void main(String[] args) {
        MyStopThread runnable=new MyStopThread();
        Thread thread=new Thread(runnable);
        thread.start();
        /*//让线程启动1S以后关闭

        try {
            //让主线程休眠1S
            thread.sleep(1000);
            runnable.setFlag(false);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        try {
            thread.sleep(1000);
            //2.stop（）方法关闭
            thread.stop();//强行关闭线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
