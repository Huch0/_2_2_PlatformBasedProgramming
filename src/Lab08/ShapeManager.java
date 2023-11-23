package Lab08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum Command {
    ADD, PRINTALL, PRINT, REMOVEALL, TOTALAREA, QUIT, INVALID
}

enum ShapeCode {
    R, T, C, INVALID
}

public class ShapeManager {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Shape> shapeList = new ArrayList<Shape>();
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Enter a command: [ADD, PRINTALL, PRINT, REMOVEALL, TOTALAREA, QUIT, INVALID]");
            Command command = getCommand();

            switch (command) {
                case ADD:
                    addShape(shapeList);
                    break;
                case PRINTALL:
                    printAll(shapeList);
                    break;
                case PRINT:
                    print(shapeList);
                    break;
                case REMOVEALL:
                    removeAll(shapeList);
                    break;
                case TOTALAREA:
                    totalArea(shapeList);
                    break;
                case QUIT:
                    System.out.println("Bye");
                    isRunning = false;
                    break;
                case INVALID:
                    System.out.println("Invalid Operation!");
                    break;
                default:
                    break;
            }
        }
        scanner.close();
    }

    private static Command getCommand() {
        String inputCommand = scanner.next().toUpperCase();

        Command command;

        try {
            command = Command.valueOf(inputCommand);
        } catch (Exception e) {
            // if inputCommand is not in Command
            return Command.INVALID;
        }

        return command;
    }

    private static ShapeCode getShapeCode() {
        String inputShape = scanner.next().toUpperCase();

        try {
            return ShapeCode.valueOf(inputShape);
        } catch (Exception e) {
            System.err.println(e);
            return ShapeCode.INVALID;
        }
    }

    private static void addShape(List<Shape> shapeList) {
        ShapeCode shapeToAdd = getShapeCode();

        switch (shapeToAdd) {
            case R: {
                // Get width, height
                int width = scanner.nextInt();
                int height = scanner.nextInt();

                try {
                    Rectangle newRectangle = new Rectangle(width, height);

                    System.out.println(newRectangle);

                    shapeList.add(newRectangle);
                } catch (InvalidRectangleException e) {
                    System.err.println(e);
                }

                break;
            }

            case T: {
                // Get width, height
                int width = scanner.nextInt();
                int height = scanner.nextInt();

                try {
                    Triangle newTriangle = new Triangle(width, height);

                    System.out.println(newTriangle);

                    shapeList.add(newTriangle);
                } catch (InvalidTriangleException e) {
                    System.err.println(e);
                }
                break;
            }

            case C: {
                // Get centerX, centerY, radius
                int centerX = scanner.nextInt();
                int centerY = scanner.nextInt();
                int radius = scanner.nextInt();

                try {
                    Circle newCircle = new Circle(centerX, centerY, radius);

                    System.out.println(newCircle);

                    shapeList.add(newCircle);
                } catch (InvalidCircleException e) {
                    System.err.println(e);
                }
                break;
            }
        }
    }

    private static void printAll(List<Shape> shapeList) {
        if (shapeList.isEmpty()) {
            System.out.println("None");
            return;
        }
        for (Shape shape : shapeList) {
            System.out.println(shape);
        }
    }


    private static void print(List<Shape> shapeList) {
        ShapeCode shapeToPrint = getShapeCode();
        int numOfEntries = 0;

        switch (shapeToPrint) {
            case R: {
                for (Shape shape : shapeList) {
                    if (shape instanceof Rectangle) {
                        System.out.println(shape);

                        numOfEntries++;
                    }
                }
                if (numOfEntries == 0) System.out.println("None");

                break;
            }
            case T: {
                for (Shape shape : shapeList) {
                    if (shape instanceof Triangle) {
                        System.out.println(shape);

                        numOfEntries++;
                    }
                }
                if (numOfEntries == 0) System.out.println("None");

                break;
            }
            case C: {
                for (Shape shape : shapeList) {
                    if (shape instanceof Circle) {
                        System.out.println(shape);

                        numOfEntries++;
                    }
                }
                if (numOfEntries == 0) System.out.println("None");

                break;
            }
        }
    }

    private static void removeAll(List<Shape> shapeList) {
        int size = shapeList.size();

        System.out.println(size);

        shapeList.clear();
    }

    private static void totalArea(List<Shape> shapeList) {
        double totalArea = 0;

        for (Shape shape : shapeList) {
            totalArea += shape.getArea();
        }

        System.out.println(totalArea);
    }
}
