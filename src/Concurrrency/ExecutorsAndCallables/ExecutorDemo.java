package Concurrrency.ExecutorsAndCallables;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService fixedThreads = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 10; i++) {
            fixedThreads.execute(new NumberPrinter(i));
        }
        fixedThreads.shutdown();

        ExecutorService cachedThreads = Executors.newCachedThreadPool();
        for(int i = 10; i < 23; i++) {
            cachedThreads.execute(new NumberPrinter(i));
        }
        cachedThreads.shutdown();

        ExecutorService singleThread = Executors.newSingleThreadExecutor();
        for(int i = 23; i < 30; i++) {
            singleThread.execute(new NumberPrinter(i));
        }
        singleThread.shutdown();

//        ExecutorService scheduledThreads = Executors.newScheduledThreadPool(4);
//        ExecutorService workStealers = Executors.newWorkStealingPool();
    }
}

class NumberPrinter implements Runnable{
    int number;
    public NumberPrinter(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Printing Number "+number+" from Thread "+Thread.currentThread().getName());
    }

}

