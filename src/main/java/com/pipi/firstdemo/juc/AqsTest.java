package com.pipi.firstdemo.juc;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class AqsTest {

    public static void main(String[] args) {
        HashMap<Strdent, Object> map = new HashMap<>();
        Strdent s = new Strdent("張三");

        Strdent s2 = new Strdent("Lis");
        map.put(s,"8");
        map.put(s2,"9");
        System.out.println(map.get(s));




      /*  MyLock lock = new MyLock();
        ReentrantLock lock1 = null;
        ExecutorService pool = Executors.newFixedThreadPool(11);
        lock1.lock();
        lock1.unlock();
        for (int i = 0; i < 10; i++) {
            pool.execute(() -> {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "获取到锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + "释放了锁");
            });
        }*/
    }
}


/**
 * 实现一个可重入锁
 */
class MyLock implements Lock {
    volatile AtomicInteger state = new AtomicInteger(0);
    //    AtomicReference<Thread> onwer = new AtomicReference<>(null);
    volatile Thread onwer = null;

    Queue<Thread> queue = new LinkedList<>();

    @Override
    public void lock() {
        if (tryLock()) {
            return;
        }
        queue.offer(Thread.currentThread());
        LockSupport.park();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        if (Thread.currentThread() == onwer) {
            return true;
        }
        if (state.compareAndSet(0, 1)) {
            onwer = Thread.currentThread();
            return true;
        }
        return false;
    }

    @Override
    public boolean tryLock(long time, @NotNull TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        if (onwer == Thread.currentThread()) {
            onwer = null;
            state.set(0);
            if (!queue.isEmpty()) {
                Thread thread = queue.poll();
                onwer = thread;
                LockSupport.unpark(onwer);
            }
        }
    }

    @NotNull
    @Override
    public Condition newCondition() {
        return new Condition() {
            List<Thread> set = new Vector<>();

            @Override
            public void await() throws InterruptedException {
                LockSupport.park();
                set.add(Thread.currentThread());
            }

            @Override
            public void awaitUninterruptibly() {

            }

            @Override
            public long awaitNanos(long nanosTimeout) throws InterruptedException {
                return 0;
            }

            @Override
            public boolean await(long time, TimeUnit unit) throws InterruptedException {
                return false;
            }

            @Override
            public boolean awaitUntil(@NotNull Date deadline) throws InterruptedException {
                return false;
            }

            @Override
            public void signal() {
                if (set.size() == 0) {
                    return;
                }
                Thread thread = set.get(0);
                if (thread != null) {
                    set.remove(thread);
                    LockSupport.unpark(thread);
                }
            }

            @Override
            public void signalAll() {

            }
        };
    }
}