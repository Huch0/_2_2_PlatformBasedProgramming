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

            if (command == Command.QUIT) {
                System.out.println("Bye");
                break;
            }
            if (command == Command.INVALID) {
                System.out.println("Invalid Operation!");
                continue;
            }

            switch (command) {
                case ADD:
                    addShape(shapeList);
                    break;
                case PRINTALL:
                    printAll(shapeList);
                case PRINT:
                    print(shapeList);


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

                Rectangle newRectangle = new Rectangle(width, height);

                System.out.println(newRectangle);

                shapeList.add(newRectangle);
                break;
            }

            case T: {
                // Get width, height
                int width = scanner.nextInt();
                int height = scanner.nextInt();

                Triangle newTriangle = new Triangle(width, height);

                System.out.println(newTriangle);

                shapeList.add(newTriangle);
                break;
            }

            case C: {
                // Get centerX, centerY, radius
                int centerX = scanner.nextInt();
                int centerY = scanner.nextInt();
                int radius = scanner.nextInt();

                Circle newCircle = new Circle(centerX, centerY, radius);

                System.out.println(newCircle);

                shapeList.add(newCircle);
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

        switch (shapeToPrint) {
            case R: {
                for (Shape shape : shapeList) {
                    if (shape instanceof Rectangle) {
                        
                    }
                }
            }

        }

    }
}
