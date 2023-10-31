package kr.pnu.cse.mid.calculator;

import java.util.Scanner;

enum Operator {
    // Your code
    SUM, PRODUCT, COMPARE, QUIT, S, P, C, Q, INVALID
}

public class MyCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Operator op;
        int a, b;

        printUsage();
        while (sc.hasNext()) {
            op = getCommand(sc);
            if (op == Operator.Q || op == Operator.QUIT) {
                // Your code
                break;
            }
            if (op == Operator.INVALID) {
                printUsage();
                // Your code
                continue;
            }

            System.out.print("Enter two integers: ");
            a = sc.nextInt();
            b = sc.nextInt();

            switch (op.name()) {
                case "SUM":
                case "S":
                    printSumBetween(a, b);
                    break;
                case "PRODUCT":
                case "P":
                    printProductBetween(a, b);
                    break;
                case "COMPARE":
                case "C":
                    printCompareBetween(a, b);
                    break;
                default:
                    break;
            }
        }
        sc.close();
    }

    private static void printUsage() {
        System.out.println("[Usage] Select one command.\n" +
                "Sum (or S)\n" +
                "Product (or P)\n" +
                "Compare (or C)\n" +
                "Quit (or Q)");
    }

    private static Operator getCommand(Scanner sc) {
        try {
            // Your code
            return Operator.valueOf(sc.next().toUpperCase());

        } catch (IllegalArgumentException e) {
            return Operator.INVALID;
        }
    }

    //Your code
    private static void printSumBetween(int a, int b) {
        int sum = a;
        System.out.print(a);

        for (int i = a + 1; i <= b; i++) {
            sum += i;
            System.out.print("+" + i);
        }
        System.out.println("=" + sum);
    }

    private static void printProductBetween(int a, int b) {
        int product = a;
        System.out.print(a);

        for (int i = a + 1; i <= b; i++) {
            product *= i;
            System.out.print("*" + i);
        }
        System.out.println(String.format("=%,d", product));
    }

    private static void printCompareBetween(int a, int b) {
        if (a > b) {
            System.out.println(a + " is greater than " + b + ".");
        } else if (a == b) {
            System.out.println("There is equal");
        } else {
            System.out.println(b + " is greater than " + a + ".");
        }
    }
}