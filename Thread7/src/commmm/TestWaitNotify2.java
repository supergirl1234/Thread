package commmm;

public class TestWaitNotify2 {

    public static void main(String[] args) {

        Object object = new Object();

        new Thread(() -> {
            synchronized(object) {
                System.out.println("notify开始");
                object.notify();
                System.out.println("notify结束");
            }
        }).start();

        synchronized(object) {
            System.out.println("wait开始");
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("wait结束");
        }
    }
}

/*运行结果：wait开始
            notify开始
            notify结束
            wait结束
*/

