package Concurrrency.Deadlock;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLockExample {
    static ReentrantLock m1 = new ReentrantLock();
    static ReentrantLock m2 = new ReentrantLock();

    public static void main(String[] args) {
        Thread tA = new Thread(() -> {
            m1.lock();
            // m1.tryLock();
            try {
                System.out.println("Thread A locked m1");
                Thread.sleep(100);
                m2.lock();
                // m2.tryLock();
                try {
                    System.out.println("Thread A locked m2");
                } finally {
                    m2.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                m1.unlock();
            }
        });

        // Fix by Taking the locks in same order
        // Taking m1.tryLock() instead of m1.lock() can also help in avoiding deadlock

        Thread tB = new Thread(() -> {
           // m2.lock();
            m1.lock();
           // m2.tryLock();
           try {
               // System.out.println("Thread B locked m2");
                System.out.println("Thread B locked m1");
               Thread.sleep(100);
                m2.lock();
               // m1.lock();
               // m1.tryLock();
               try {
                   System.out.println("Thread B locked m1");
                   // System.out.println("Thread B locked m2");
               } finally {
                   m1.unlock();
               }
           } catch (InterruptedException e) {
               e.printStackTrace();
           } finally {
               m2.unlock();
           }
        });

        tA.start();
        tB.start();

        try {
            tA.join();
            tB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
