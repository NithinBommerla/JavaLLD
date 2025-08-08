package Concurrrency.Deadlock;

import java.util.concurrent.locks.ReentrantLock;

public class LiveLockExample {
    static ReentrantLock m1 = new ReentrantLock();
    static ReentrantLock m2 = new ReentrantLock();
    static volatile boolean done = false;

    public static void main(String[] args) throws InterruptedException {
        Thread tA = new Thread(() -> {
            while(!done) {
                m1.lock();
                try {
                    try {
                        System.out.println("Thread A locked m1");
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    if(m2.tryLock()) {
                        try {
                            System.out.println("Thread A acquired m2");
                            done = true;
                        } finally {
                            m2.unlock();
                        }
                    }
                } finally {
                    m1.unlock();
                    System.out.println("Thread A unlocked m1");
                }
            }
        });


        Thread tB = new Thread(() -> {
            while(!done) {
                m2.lock();
                try {
                    try {
                        System.out.println("Thread B locked m2");
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    if(m1.tryLock()) {
                        try {
                            System.out.println("Thread B acquired m1");
                            done = true;
                        } finally {
                            m1.unlock();
                        }
                    }
                } finally {
                    m2.unlock();
                    System.out.println("Thread B unlocked m2");
                }
            }
        });

        tA.start();
        tB.start();

        tA.join();
        tB.join();
    }
}
