package commmm;

public class TestWaitNotify3 implements Runnable {

    private  Object object;
    private boolean flag;

    public TestWaitNotify3(Object object, boolean flag) {
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
            object.notifyAll();//唤醒全部的
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
        Runnable runnable11=new TestWaitNotify1(object,true);
        Runnable runnable12=new TestWaitNotify1(object,true);
        Runnable runnable2=new TestWaitNotify1(object,false);
        Thread thread1=new Thread(runnable1,"线程A");
        Thread thread11=new Thread(runnable11,"线程B");
        Thread thread12=new Thread(runnable12,"线程C");
        Thread thread2=new Thread(runnable2,"线程aaaaa");
        thread1.start();
        thread11.start();
        thread12.start();
        try {
            Thread.sleep(1000);//让主线程先休眠一下，确保让thread1线程先运行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();


    }
}
