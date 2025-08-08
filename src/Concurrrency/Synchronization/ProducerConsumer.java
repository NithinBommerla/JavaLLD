package Concurrrency.Synchronization;

import Inheritance1.C;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

    static final Object lock = new Object();
    static final Queue<Integer> queue = new LinkedList<>();
    static final int CAPACITY = 5;

    public static void main(String[] args) throws InterruptedException {
        Thread producer = new Thread(() -> {
            for(int i = 0; i < CAPACITY; i++) {
                synchronized (lock) {
                    while(queue.size() == CAPACITY) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    queue.add(i);
                    System.out.println("Produced: "+i);
                    lock.notify();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for(int i = 0; i < CAPACITY; i++) {
                synchronized (lock) {
                    while(queue.isEmpty()) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    int item = queue.poll();
                    System.out.println("Consumed: "+item);
                    lock.notify();
                }
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}
