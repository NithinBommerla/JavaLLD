package Concurrrency.Synchronization;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionVariableExample {
    static ReentrantLock lock = new ReentrantLock();
    static Condition cv = lock.newCondition(); // Condition variable

    boolean ready = false;
    Thread worker = new Thread(() -> {
        lock.lock();
        try {
            System.out.println("Worker: waiting");
            while(!ready) {
                cv.await();
            }
            System.out.println("Worker: received notification");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    });

    Thread controller = new Thread(() -> {
        lock.lock();
        try {
            ready = true;
            System.out.println("Controller: ready and notifying");
            cv.signal();
        } finally {
            lock.unlock();
        }
    });

    public void start() {
        controller.start();
        worker.start();
    }

    public static void main(String[] args) {
        new ConditionVariableExample().start();
    }
}
