package kr.pnu.cse.shape;

import kr.pnu.cse.edit.*;
import java.util.Scanner;
enum OperationKind {ADDR, ADDC, LIST, CLEAR, QUIT, INVALID}
public class EditorTest {
    private static Editor editor = new Editor() ;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            OperationKind op = getOperation(scanner) ;
            if (op == OperationKind.QUIT) {
                System.out.println("Bye") ; break;
            }
            if (op == OperationKind.INVALID) {
                System.out.println("Invalid Operation!") ; continue ;
            }
            switch (op) {
                case ADDR: {
                    Rectangle newRectangle = createRectangle(scanner) ;
                    System.out.println(newRectangle) ;
                    editor.add(newRectangle) ; break ;
                }
                case ADDC: {
                    Circle newCircle = createCircle(scanner) ;
                    System.out.println(newCircle) ;
                    editor.add(newCircle) ; break ;
                }
                case CLEAR: editor.clear() ; break ;
                case LIST:  editor.list() ; break ;
                default: break;
            }
        }
        scanner.close();
    }

    private static Circle createCircle(Scanner scanner) {
        int x = scanner.nextInt() ;
        int y = scanner.nextInt() ;
        int radius = scanner.nextInt() ;

        return new Circle(new Point(x, y), radius) ;
    }

    private static Rectangle createRectangle(Scanner scanner) {
        int width = scanner.nextInt() ;
        int height = scanner.nextInt() ;

        return new Rectangle(width, height) ;
    }

    private static OperationKind getOperation(Scanner scanner) {
        System.out.print("Enter Operation String! ") ;
        String operation = scanner.next() ;

        OperationKind kind;
        try {
            kind = OperationKind.valueOf(operation.toUpperCase());
        }
        catch ( IllegalArgumentException e ) {
            kind = OperationKind.INVALID;
        }
        return kind;
    }
}

