package Concurrrency.ExecutorsAndCallables;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService fixedThreads = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 10; i++) {
            fixedThreads.execute(new NumberPrinter(i));
        }
        fixedThreads.shutdown();
        Thread.sleep(1000);
        fixedThreads = Executors.newFixedThreadPool(5);
        for(int i = 10; i < 20; i++) {
            fixedThreads.execute(new NumberPrinter(i));
        }
        fixedThreads.shutdown();
        Thread.sleep(1000);
        ExecutorService cachedThreads = Executors.newCachedThreadPool();
        for(int i = 20; i < 30; i++) {
            cachedThreads.execute(new NumberPrinter(i));
        }
        cachedThreads.shutdown();
        Thread.sleep(1000);
        ExecutorService singleThread = Executors.newSingleThreadExecutor();
        for(int i = 30; i < 40; i++) {
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

//
//public class ExecutorDemo {
//    public static void main(String args[]) throws InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        System.out.println("Trying to print using Fixed Thread Pool");
//        for(int i = 0; i < 10; i++) {
//            executorService.execute(new NumberPrinter(i));
//        }
//        executorService.shutdown();
//        Thread.sleep(500);
//        System.out.println("Trying to print using Cached Thread Pool");
//        executorService = Executors.newCachedThreadPool();
//        for(int i = 10; i < 20; i++) {
//            executorService.execute(new NumberPrinter(i));
//        }
//        executorService.shutdown();
//        Thread.sleep(500);
//        System.out.println("Trying to print using Single Thread Executor");
//        executorService = Executors.newSingleThreadExecutor();
//        for(int i = 20; i < 30; i++) {
//            executorService.execute(new NumberPrinter(i));
//        }
//        executorService.shutdown();
//    }
//}
//
//class NumberPrinter implements Runnable {
//    int num;
//    public NumberPrinter(int num) {
//        this.num = num;
//    }
//
//    @Override
//    public void run() {
//        System.out.println("Printing Number "+num+" from thread "+Thread.currentThread().getName());
//    }
//}
//
//














