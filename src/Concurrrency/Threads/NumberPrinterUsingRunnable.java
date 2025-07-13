package Concurrrency.Threads;

public class NumberPrinterUsingRunnable implements Runnable {
    int number;
    public NumberPrinterUsingRunnable(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Current Number is "+number+" from thread "+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        for(int i = 0; i < 100; i++) {
            Thread t = new Thread( new NumberPrinterUsingRunnable(i));
            t.start();
        }
    }

}
