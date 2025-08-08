package Concurrrency.Synchronization;

public class CounterExample {
    static int counter = 0;

    static void incrementCounter() {
        for(int i = 0; i < 1000; ++i) {
            counter++;
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(CounterExample::incrementCounter);
        Thread t2 = new Thread(CounterExample::incrementCounter);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Counter: "+counter);

    }
}
