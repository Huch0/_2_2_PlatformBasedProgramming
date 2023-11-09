package Lab07;

import org.w3c.dom.css.Rect;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class RectangleManager {
    private static List<Rectangle> rectangles = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Enter a command: [create width height, zoom id ratio or quit]");
            String command = scanner.next();
            if (command.equalsIgnoreCase("create")) {
                // TODO
                try {
                    int width = scanner.nextInt();
                    int height = scanner.nextInt();

                    if (width <= 0 || height <= 0) {
                        throw new InvalidRectangleException(width, height);
                    }

                    createRectangle(width, height);
                } catch(InputMismatchException e) {
                    System.out.println("입력된 인자의 형식이 맞지 않습니다.");
                } catch(InvalidRectangleException e) {
                    System.out.println(e.toString());
                }
            } else if (command.equalsIgnoreCase("zoom")) {
                // TODO
                int id = scanner.nextInt();
                int ratio = scanner.nextInt();
                zoomRectangle(id, ratio);
            } else if (command.equalsIgnoreCase("showAll")) {
                // TODO
                showAllRectangle();
            } else if (command.equalsIgnoreCase("quit")) {
                System.out.println("Bye");
                break;
            }
        }
        scanner.close();
    }
    private static void createRectangle(int width, int height) {
        Rectangle newRectangle = new Rectangle(width, height);
        System.out.println(newRectangle.toString() + " is added at " + rectangles.size());
        rectangles.add(newRectangle);
    }

    private static void zoomRectangle(int id, int ratio) {
        try {
            Rectangle zoomedRectangle = rectangles.get(id);

            System.out.println("Before: " + zoomedRectangle.toString());

            zoomedRectangle.scale(ratio);

            System.out.println("After: " + zoomedRectangle.toString());
        } catch(IndexOutOfBoundsException e) {
            System.out.println(
                    "존재하지 않는 배열의 원소를 접근했습니다." +
                            "java.lang.IndexOutOfBoundsException: Index: " +
                            id +
                            ", Size: " +
                            rectangles.size());
        }
    }

    private static void showAllRectangle() {
        for (Rectangle Rec : rectangles) {
            System.out.println(Rec.toString());
        }
    }
}

