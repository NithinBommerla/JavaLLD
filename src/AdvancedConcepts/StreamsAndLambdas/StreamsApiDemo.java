package AdvancedConcepts.StreamsAndLambdas;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;


public class StreamsApiDemo {
    public static void main(String[] args) {
        String sentence = "Streams make  it look very easy but it needs lot of practice.";
        String[] array = sentence.split("\\s+");
        List<String> words = Arrays.stream(array).collect(Collectors.toList());
        System.out.println(words);

        String result = String.join("", words); // String result = words.stream().collect(Collectors.joining());
        System.out.println(result);

        String correctResult = words.stream().map(word -> word+" ").collect(Collectors.joining()).trim();
        System.out.println(correctResult);

        String string = "abcdabcdelskea";

        List<Character> uniqueCharacters = string.chars().distinct()
                .mapToObj(c -> (char) c).collect(Collectors.toList());

        System.out.println(uniqueCharacters);

        Map<Character, Long> freqMap = string.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(freqMap);

        List<Character> exactlyTwice = freqMap.entrySet().stream()
            .filter(entry -> entry.getValue() == 2)
                .map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(exactlyTwice);

        List<Character> notUnique = string.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(e -> e.getKey())
                .collect(Collectors.toList());
        System.out.println(notUnique);

        int[] numbers = new int[] {9,2,1,7,5,6,4,8,3};

        int[] oddNumbers = Arrays.stream(numbers)
                .boxed().sorted(Comparator.reverseOrder()).filter(n -> n % 2 == 1)
                .mapToInt(Integer::valueOf).toArray();
        Arrays.stream(oddNumbers).forEach(n -> System.out.print(n+" "));
        System.out.println();

        Arrays.stream(numbers).boxed().sorted((a,b) -> b-a)
                .filter(n -> n % 2 == 0).forEach(n -> System.out.print(n+" "));
        System.out.println();

        int sumOfEvenSquares = Arrays.stream(numbers).filter(n -> (n&1) == 0)
                .map(n -> n*n).reduce(0, Integer::sum);
        System.out.println("Even squares sum: "+sumOfEvenSquares);

        int target = 10;

        List<List<Integer>> pairs = Arrays.stream(numbers)
                .boxed()
                .flatMap(i -> Arrays.stream(numbers)
                                            .boxed()
                                            .filter(j -> i < j && i + j == target)
                                            .map(j -> List.of(i, j)))
                .collect(Collectors.toList());
        System.out.println(pairs);

        OptionalInt maxOptional = Arrays.stream(numbers).max();
        System.out.println("Max: "+maxOptional.getAsInt());

        Optional<Integer> minInt = Arrays.stream(numbers).boxed()
                .min(Integer::compare);
        minInt.ifPresent(n -> System.out.println("Min is: "+n));

        List<String> names = List.of("Apple", "Banana", "Custard", "Dragon","Elephant");

        List<String> upperCase = names.stream().map(String::toUpperCase).toList();
        System.out.println(upperCase);

        List<String> namesWithA = names.stream().filter(n -> n.startsWith("A")).toList();
        System.out.println(namesWithA);

        List<String> namesGT5 = names.stream().filter(n -> n.length() > 5).toList();
        System.out.println(namesGT5);

        List<String> reverse = names.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(reverse);

        Map<Integer, List<String>> lenMap = names.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(lenMap);
        int targetLen = 6;
        int strOfLenTarget = (int) names.stream().filter(s -> s.length() == targetLen).count();
        System.out.println("Count of strings with length ="+targetLen+" is: "+strOfLenTarget);

        
    }
}

//// Write code to return the sum of square of even elements in a List using Streams API
//public class StreamsApiDemo {
//    public static void main(String[] args) {
//        List<String> words = Arrays.asList("Hello", " ", "Stream", " ", "API");
//        // Concatenating strings
//        String result = words.stream()
//                .collect(Collectors.joining());
//
//        System.out.println("Concatenated String: " + result); // Output: Concatenated String: Hello
//
//        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9);
//        List<Long> EvenElementsInList = numbers.stream()
//                .sorted((a,b) -> b-a)
//                .filter((a) -> a%2 == 0)
//                .map(a -> (long) a*100000000).collect(Collectors.toList()); // .toList(); can also be used directly
//        System.out.println(EvenElementsInList);
//        System.out.println("Count of Elements After filtering: "+EvenElementsInList.stream().count());
//        long sumOfSquareOfEvenElementsInList = EvenElementsInList.stream()
//                .reduce(0L, Long::sum); // (0, (num1, num2) -> num1 + num2);
//        System.out.println(sumOfSquareOfEvenElementsInList);
//        // int smallestSquare = EvenElementsInList.stream().min();
//
//        int[] numbersArray = new int[]{1,2,3,4,5,6,7,8,9};
//        int[] evenNumbersInArray = Arrays.stream(numbersArray).filter((a) -> a%2 == 0).toArray();
//        Arrays.stream(evenNumbersInArray).forEach(n -> System.out.print(n+" "));
//
//        // Arrays.stream(evenNumbersInArray).forEach(System.out::println);
//        // int sumOfSquareOfEvenElementsInList = numbers.stream().reduce()
//    }
//}

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









