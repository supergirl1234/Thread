package commmmm;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {

    private Queue<Goods> queue;
    private final Object monitor;
    private AtomicInteger count;

    public Producer(Queue<Goods> queue, Object monitor, AtomicInteger count) {
        this.queue = queue;
        this.monitor = monitor;
        this.count = count;
    }

    @Override
    public void run() {
        while (true) {

            synchronized (monitor) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (queue.size() == 20) {
                    try {

                        this.monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {

                    Goods goods = new Goods(count.getAndAdd(1));
                    queue.add(goods);
                    System.out.println(Thread.currentThread().getName() + "生产商品" + goods.getId());
                }
            }
        }


    }
}
