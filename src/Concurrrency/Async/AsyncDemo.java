package Concurrrency.Async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

public class AsyncDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // CompletableFuture.runAsync(() -> System.out.println("Hello Async"));
        int number = 7;
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(() ->
                IntStream.rangeClosed(1, number).asLongStream()
                        .reduce(1, (a, b) -> a * b)
        );

        // future.thenAccept(System.out::println);

        int sum = IntStream.rangeClosed(1, 100).sum();
        while(!future.isDone()) System.out.println("Factorial in progress");
        System.out.println("Total is: "+sum);
        System.out.println(future.get());
    }
}
