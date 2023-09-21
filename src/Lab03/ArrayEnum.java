package Lab03;

import java.util.Scanner;

enum Command {
    // Your code here
    ADD, LIST, SUM, INVALID, QUIT
};
public class ArrayEnum {
    public static void main(String[] args) {
        // Your code here
        // Integer[] for checking null element
        Integer[] values = new Integer[100];
        int index = 0;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            Command command = getCommand(scanner); // Command is enum
            if (command == Command.QUIT) {
                System.out.println("Bye!");
                break;
            }
            switch (command) {
                case ADD:
                    int newValue = getValue(scanner);
                    values[index] = newValue;
                    index++;
                    break;
                case LIST:
                    printList(values, index);
                    break;
                case SUM:
                    System.out.println(getSum(values, index));
                    break;
                case INVALID:
                    System.out.println("Invalid Command");
                default:
                    break;
            }
        }
        scanner.close();
    }
    // Your code here
    public static Command getCommand(Scanner scanner) {
        String inputCommand = scanner.next();
        final Command command;

        try {
             command = Command.valueOf(inputCommand.toUpperCase());
        } catch(Exception e) {
            // if valueOf("SOMETHING") failed, it is not valid element of ENUM
            return Command.INVALID;
        }

        return command;
    }

    public static int getValue(Scanner scanner) {
        int inputValue = scanner.nextInt();

        return inputValue;
    }

    public static void printList(Integer[] values, int index) {
        for (Integer value : values) {
            if (value == null) break;
            System.out.printf("%d ", value);
        }

        System.out.println();
        return;
    }

    public static int getSum(Integer[] values, int index) {
        int sum = 0;
        for (Integer value : values) {
            if (value == null) break;
            sum += value;
        }

        return sum;
    }
}