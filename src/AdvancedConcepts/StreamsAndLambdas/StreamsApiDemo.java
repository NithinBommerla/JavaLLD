package AdvancedConcepts.StreamsAndLambdas;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

// Write code to return the sum of square of even elements in a List using Streams API
public class StreamsApiDemo {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", " ", "Stream", " ", "API");
        // Concatenating strings
        String result = words.stream()
                .collect(Collectors.joining());

        System.out.println("Concatenated String: " + result); // Output: Concatenated String: Hello
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9);
        List<Long> EvenElementsInList = numbers.stream()
                .sorted((a,b) -> b-a)
                .filter((a) -> a%2 == 0)
                .map(a -> (long) a*100000000).collect(Collectors.toList()); // .toList(); can also be used directly
        System.out.println(EvenElementsInList);
        System.out.println("Count of Elements After filtering: "+EvenElementsInList.stream().count());
        long sumOfSquareOfEvenElementsInList = EvenElementsInList.stream()
                .reduce(0L, Long::sum); // (0, (num1, num2) -> num1 + num2);
        System.out.println(sumOfSquareOfEvenElementsInList);
        // int smallestSquare = EvenElementsInList.stream().min();

        int[] numbersArray = new int[]{1,2,3,4,5,6,7,8,9};
        int[] evenNumbersInArray = Arrays.stream(numbersArray).filter((a) -> a%2 == 0).toArray();
        Arrays.stream(evenNumbersInArray).forEach(n -> System.out.print(n+" "));

        // Arrays.stream(evenNumbersInArray).forEach(System.out::println);
        // int sumOfSquareOfEvenElementsInList = numbers.stream().reduce()
    }
}

/*
Lambda Functions & Streams
=> Lambda Expression Syntax
(List of parameters comma separated) -> {expression / statements}

=> Streams
-> Intermediate Operations (Lazy)
.filter(Predicate) Predicate returns true/false
.map(Function)
.sorted(Comparator)
.distinct()
.limit()
.skip()


-> Terminal Operations (Eager)
.forEach()
.reduce(offset, BinaryOperator) (0, (a,b) -> a+b)
.count()
.collect()
.anyMatch()
.allMatch()
.NoneMatch()
.min()
.max()

 */









