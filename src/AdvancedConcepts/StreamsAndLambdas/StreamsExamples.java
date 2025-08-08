package AdvancedConcepts.StreamsAndLambdas;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExamples {
    public static void main(String[] args) {
        // Convert a list of numbers into a comma-separated string
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        String numbersString = numbers.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(numbersString);

        /*
        // From a list of strings, return the longest one
        List<String> strings = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++) {
            sb.append((char) ('a'+i));
            strings.add(sb.toString());
        }

        System.out.println(strings);

        String longest = strings.stream().max(Comparator.comparingInt(String::length)).orElse(" ");
        System.out.println(longest);


        // Example 1: You are given a stream of integers. Please use the filter method
        // to return all odd numbers in the form of a list. Use only stream methods.
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> oddNumbers = numbers.stream().filter(num -> num%2 != 0).toList();
        System.out.println(oddNumbers);
        // Find sum of squares of odd numbers in a list
        int sumOfOddNumberSquares = numbers.stream()
                .filter(num -> num%2 != 0)
                .map(num -> num * num)
                .reduce(1, (a,b) -> a+b);
        System.out.println(sumOfOddNumberSquares);

        // Given a list of employees, extract emails of those with salary > 50K
        List<Employee> employees =  new ArrayList<>();
        for(int i = 1; i <= 10; i++) {
            employees.add(new Employee("e"+i, i*1000));
        }

        int maxSalary = employees.stream()
                .map(Employee::getSalary)
                .max(Integer::compare)
                .orElse(0);
        System.out.println(maxSalary);

         */
    }
}
