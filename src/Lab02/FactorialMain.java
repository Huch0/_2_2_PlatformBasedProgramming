package Lab02;

public class FactorialMain {
    public static void main(String[] args) {
        for ( int i = 1; i <= 10; i ++ ) {
            final long fact = factorial(i);
            System.out.printf("Factorial of %d: %d%n", i, fact);
        }
    }
    private static long factorial(final int n) {
        long fact = 1L;

        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
