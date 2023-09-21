package Lab01;

import java.util.Scanner;

public class MathMain {
    public static void main(String[] args) {
        System.out.print("Enter two numbers: ");
        final Scanner scanner = new Scanner(System.in);
        final int begin = scanner.nextInt();
        final int end = scanner.nextInt();
        scanner.close();

        final long sum = getSumBetween(begin, end);
        System.out.printf("Sum between %d and %d : %,d%n", begin, end, sum);

        final long product = getProductBetween(begin, end);
        System.out.printf("Product between %d and %d : %,d%n", begin, end, product);
    }

    public static long getSumBetween(int begin, int end) {
        long sum = 0L;
        for (int i = begin; i <= end; i++) {
            sum += i;
        }
        return sum;
    }
    public static long getProductBetween(int begin, int end) {
        long product = 1L;
        for (int i = begin; i <= end; i++) {
            product *= i;
        }
        return product;
    }
}
