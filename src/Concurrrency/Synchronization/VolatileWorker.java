package Concurrrency.Synchronization;

public class VolatileWorker extends Thread {
    volatile boolean running = true;

    public void run() {
        System.out.println("Worker Started");
        while(running) {
            // do something
        }
        System.out.println("Worker Stopped");
    }

    public void stopRun() {
        running = false;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileWorker worker = new VolatileWorker();
        worker.start();

        Thread.sleep(1000);

        System.out.println("Main: Requesting stop");
        worker.stopRun();

        worker.join();
        System.out.println("Main: Worker Stopped");
    }
}
