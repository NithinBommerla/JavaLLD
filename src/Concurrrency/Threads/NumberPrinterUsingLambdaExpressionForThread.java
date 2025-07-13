package Concurrrency.Threads;

public class NumberPrinterUsingLambdaExpressionForThread {
    public static void main(String[] args) {
        for(int i = 0; i < 100; i++) {
            int j  = i;
            Thread t = new Thread(() -> System.out.println("Current Number is "+j+" from thread "+Thread.currentThread().getName()));
            t.start();
        }

    }
}
