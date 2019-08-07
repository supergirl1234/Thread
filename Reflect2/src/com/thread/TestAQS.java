package com.thread;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;


/*自定义一个锁*/
class Mutex implements Lock {

    private Syn syn = new Syn();

    /*锁的实现依赖AQS*/
    /*静态内部类   自定义同步器*/
    static class Syn extends AbstractQueuedSynchronizer {

        //AQS的子类必须重写AQS的用propected修饰的用来改变同步状态的方法
        @Override
        protected boolean tryAcquire(int arg) {
            if (arg != 1) {
                throw new RuntimeException("arg参数不为1");

            }
            if (compareAndSetState(0, 1)) {
//              1表示此时线程成功获取同步状态,拿到了这个锁，将持有线程设置为自己
                setExclusiveOwnerThread(Thread.currentThread());
                return true;

            }

            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if (getState() == 0) {
                throw new IllegalMonitorStateException();

            }
            /*释放时，将当前持有线程置为null*/
            setExclusiveOwnerThread(null);
            /*状态还原为0*/
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;//getState()的值为1时，表示获取成功
        }
    }

    @Override
    public void lock() {
        syn.acquire(1);

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

        syn.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return syn.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return syn.tryAcquireNanos(1, time);
    }

    @Override
    public void unlock() {
        syn.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}


public class TestAQS {

    public static void main(String[] args) {
        Lock lock = new Mutex();
        for (int i = 0; i < 10; i++) {

            Thread thread = new Thread(() -> {
                try {
                    lock.lock();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    lock.unlock();
                }
            });
            thread.start();
        }
    }
}
