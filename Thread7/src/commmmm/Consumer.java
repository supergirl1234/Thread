package commmmm;

import java.util.List;
import java.util.Queue;

public class Consumer implements Runnable {

    private Queue<Goods> queue;
    private final Object monitor;

    public Consumer(Queue<Goods> queue, Object monitor) {
        this.queue = queue;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (monitor) {


                if (queue.size() == 0) {
                    this.monitor.notifyAll();
                } else {

                    Goods goods = queue.poll();
                    System.out.println(Thread.currentThread().getName() + "消费商品" + goods.getId());
                }
            }
        }
    }
}
