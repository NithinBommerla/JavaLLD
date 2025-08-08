package Polymorphism.test;

public class Test {

    public static void main(String args[]) {
        for(int i = 1; i <= 10; i++) {
            fizzbuzz(i);
        }
    }

    public static void fizzbuzz(int num) {
        if(num % 3 == 0 ) System.out.println(num +" foo bar");
        else if(num % 2 == 0) System.out.println(num +" bar");
        else System.out.println(num +" foo");
    }
    // if num % 3 print num + foo + bar
    // if even print  num + bar
    // if odd print Num + foo
}
