package Concurrrency.Threads;

public class FactorialCalculator {
    public static void main(String[] args) {
        int n = 10;
        long factorial = 1;
        for(int i = 1; i <= n; i++) factorial *= i;
        System.out.println(factorial);
    }
}
