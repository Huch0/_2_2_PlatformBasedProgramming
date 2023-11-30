package Lab09;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum OperationKind {
    ADDL, ADDC, SORTA, SORTD, CLEAR, LIST, QUIT, INVALID
}

enum SortKind {
    ASCENDING, DESCENDING
}

public class SortInterfaceTest {

    private static Scanner scanner = new Scanner(System.in);
    private static List<MyComparable> comparableList = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.print("Enter Operation String! ");
            OperationKind op = getOperation(scanner);
            if (op == OperationKind.QUIT) {
                System.out.println("Bye");
                break;
            }
            if (op == OperationKind.INVALID) {
                System.out.println("Invalid Operation!");
                continue;
            }
            switch (op) {
                case ADDL: {
                    Line newLine = createLine(scanner);
                    comparableList.add(newLine);
                    System.out.println(newLine);
                    break;
                }
                case ADDC: {
                    Circle newCircle = createCircle(scanner);
                    comparableList.add(newCircle);
                    System.out.println(newCircle);
                    break;
                }
                case SORTA:
                    sortList(comparableList, SortKind.ASCENDING);
                    break;
                case SORTD:
                    sortList(comparableList, SortKind.DESCENDING);
                    break;
                case CLEAR:
                    comparableList.clear();
                    break;
                case LIST:
                    System.out.println(comparableList);
                    break;
                default:
                    break;
            }
        }

        scanner.close();
    }

    private static OperationKind getOperation(Scanner scanner) {
        String inputString = scanner.next().toUpperCase();

        try {
            return OperationKind.valueOf(inputString);
        } catch (Exception e) {
            return OperationKind.INVALID;
        }
    }

    private static Line createLine(Scanner scanner) {
        // Consume the newline character left in the buffer
        scanner.nextLine();
        Line newLine = null;

        while (true) {
            try {
                String[] nextLine = scanner.nextLine().split(" ");
                int x1 = Integer.parseInt(nextLine[0]);
                int y1 = Integer.parseInt(nextLine[1]);
                int x2 = Integer.parseInt(nextLine[2]);
                int y2 = Integer.parseInt(nextLine[3]);

                newLine = new Line(x1, y1, x2, y2);
                break;
            } catch (IndexOutOfBoundsException e) {
                System.err.println(e);
                continue;
            } catch (NumberFormatException e) {
                System.err.println(new InvalidPointException());
                continue;
            }
        }

        return newLine;
    }

    private static Circle createCircle(Scanner scanner) {
        // Consume the newline character left in the buffer
        scanner.nextLine();
        Circle newCircle = null;

        while (true) {
            try {
                String[] nextLine = scanner.nextLine().split(" ");
                int x = Integer.parseInt(nextLine[0]);
                int y = Integer.parseInt(nextLine[1]);
                int radius = Integer.parseInt(nextLine[2]);

                newCircle = new Circle(x, y, radius);

                if (radius <= 0) {
                    throw new InvalidCircleException(radius);
                }
                break;
            } catch (IndexOutOfBoundsException e) {
                System.err.println(e);
                continue;
            } catch (NumberFormatException e) {
                System.err.println(new InvalidPointException());
                continue;
            } catch (InvalidCircleException e) {
                System.err.println(e);
                continue;
            }
        }
        return newCircle;
    }

    private static void sortList(List<MyComparable> comparableList, SortKind sortKind) {
        int n = comparableList.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (compare(comparableList.get(j), comparableList.get(j + 1), sortKind) > 0) {
                    // Swap elements if they are in the wrong order
                    swap(comparableList, j, j + 1);
                }
            }
        }
    }

    private static void swap(List<MyComparable> list, int i, int j) {
        MyComparable temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private static int compare(MyComparable obj1, MyComparable obj2, SortKind sortKind) {
        int result = obj1.compareTo(obj2);

        if (sortKind == SortKind.DESCENDING) {
            result = -result; // Reverse the result for descending order
        }

        return result;
    }
}
