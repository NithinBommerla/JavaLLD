package AdvancedConcepts.StreamsAndLambdas;

public class LambdaDemo  {
    public static void main(String [] args) throws Exception {
        // Traditional way
        Runnable traditionalDemo =  new Runnable () {
            @Override
            public void run() {
                System.out.println("Here is a Traditional way to implement a functional interface");
            }
        };

        // Using Lambda Expression
        Runnable lambdaDemo = () -> System.out.println("This is lambda Approach");

        Thread thread1 = new Thread(traditionalDemo);
        Thread thread2 = new Thread(lambdaDemo);
        // thread1.sleep(10000);
        thread1.start();
        thread2.start();

    }
}
