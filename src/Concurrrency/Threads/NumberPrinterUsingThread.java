package Concurrrency.Threads;

public class NumberPrinterUsingThread extends Thread {
    int number;
    public NumberPrinterUsingThread (int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Current Number is "+number+" from Thread "+currentThread().getName());
    }

    public static void main(String[] args) {
        for(int i = 0; i < 100; i++) {
            Thread t = new Thread(new NumberPrinterUsingThread(i));
            t.start();
        }
    }

}
