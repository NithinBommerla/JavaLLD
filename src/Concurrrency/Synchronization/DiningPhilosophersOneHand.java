package Concurrrency.Synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophersOneHand {

    final ReentrantLock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();
    final int capacity = 5;
    final boolean[] forkInUse = new boolean[capacity];

    boolean canPickForks(int philosopher) {
        int left = philosopher;
        int right = (philosopher + 1) % capacity;
        return !forkInUse[left] && !forkInUse[right];
    }

    public void wantsToEat(int philosopher, Runnable pickLeftFork, Runnable pickRightFork,
                           Runnable eat, Runnable putLeftFork, Runnable putRightFork) throws InterruptedException {
        lock.lock();
        try {
            while(!canPickForks(philosopher)) {
                condition.await();
            }
            int left = philosopher;
            int right = (philosopher + 1) % capacity;
            forkInUse[left] = true;
            forkInUse[right] = true;
        } finally {
            lock.unlock();
        }

        // Picks fork with one-hand strategy
        if(philosopher % 2 == 0) {
            pickRightFork.run();
            pickLeftFork.run();
        } else {
            pickLeftFork.run();
            pickRightFork.run();
        }

        // Eat
        eat.run();

        // Put down forks in reverse order
        if(philosopher % 2 == 0) {
            putRightFork.run();
            putLeftFork.run();
        } else {
            putLeftFork.run();
            putRightFork.run();
        }

        lock.lock();
        try {
            int left = philosopher;
            int right = (philosopher + 1) % capacity;
            forkInUse[left] = false;
            forkInUse[right] = false;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        DiningPhilosophersOneHand table = new DiningPhilosophersOneHand();
        ExecutorService executor = Executors.newFixedThreadPool(table.capacity);

        for(int i = 0; i < table.capacity; i++) {
            int id = i;
            executor.submit(() -> {
               for(int j = 0; j < 3; j++) { // Simulating eating 3 times
                   try {
                       table.wantsToEat(id,
                               () -> System.out.println("Philosopher "+id+" picked up left fork"),
                               () -> System.out.println("Philosopher "+id+" picked up right fork"),
                               () -> {
                                   System.out.println("Philosopher "+id+" is eating.");
                                   try {
                                       // simulate eating
                                       Thread.sleep(5000);
                                   } catch (InterruptedException e) {
                                       Thread.currentThread().interrupt();
                                   }
                               },
                               () -> System.out.println("Philosopher "+id+" put down left fork"),
                               () -> System.out.println("Philosopher "+id+" put down right fork")
                       );
                   } catch (InterruptedException e) {
                       Thread.currentThread().interrupt();
                   }
               }
            });
        }
        executor.shutdown();
    }
}













