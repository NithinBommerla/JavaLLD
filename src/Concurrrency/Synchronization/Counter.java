package Concurrrency.Synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    int value;
    public Counter() {
        this.value = 0;
    }
    // Method 2: Using synchronized methods instead of synchronized block
    public synchronized void increment() {
        value++;
    }

    public synchronized void decrement() {
        value--;
    }

    public static void main(String[] args) throws Exception{
        Counter counter = new Counter();
//        Lock lock = new ReentrantLock();
//        Adder adder = new Adder(counter, lock);
//        Subtractor subtractor = new Subtractor(counter, lock);
        Adder adder = new Adder(counter);
        Subtractor subtractor = new Subtractor(counter);
        Thread t1 = new Thread(adder);
        Thread t2 = new Thread(subtractor);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.value);
    }
}
