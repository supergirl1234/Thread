package commmm;

public class TestWaitNotify1 implements Runnable {

    private  Object object;
    private boolean flag;

    public TestWaitNotify1(Object object, boolean flag) {
        this.object = object;
        this.flag = flag;
    }

    public void waitMethod(){

        synchronized (object){

            System.out.println(Thread.currentThread().getName()+"wait方法开始");
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(Thread.currentThread().getName()+"wait方法结束");

        }


    }

    public void notifyMethod(){
        synchronized (object){
            System.out.println(Thread.currentThread().getName()+"notify方法开始");
            object.notify();
            System.out.println(Thread.currentThread().getName()+"notify方法结束");

        }
    }
    @Override
    public void run() {
        if (flag) {
            this.waitMethod();
        } else {
            this.notifyMethod();
        }
    }

    public static void main(String[] args) {

        Object object=new Object();
        Runnable runnable1=new TestWaitNotify1(object,true);

        Runnable runnable2=new TestWaitNotify1(object,false);
        Thread thread1=new Thread(runnable1,"线程1");

        Thread thread2=new Thread(runnable2,"线程2");
        thread1.start();

        try {
            Thread.sleep(10000);//让主线程先休眠一下，确保让thread1线程先运行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();


    }
}
