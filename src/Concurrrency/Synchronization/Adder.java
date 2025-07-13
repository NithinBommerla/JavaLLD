package Concurrrency.Synchronization;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {
    Counter counter;
    // Method 0 using Lock keyword
    Lock lock;

    public Adder(Counter counter, Lock lock) {
        this.counter = counter;
        this.lock = lock;
    }
    public Adder(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for(int i = 0; i < 10000; i++) {
//            // Method 0: Using Lock
//            lock.lock();
//            counter.value += 1;
//            lock.unlock();

//            // Method 1: Using synchronized block to avoid Data Synchronization Problem
//            synchronized (counter) {
//                counter.value += 1;
//            }

            // Method 2: Accessing synchronized method
            counter.increment();
        }
    }
}
