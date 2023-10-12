package Lab05;

import java.util.Scanner;

enum OperationKind {
    ADD, FIND, CLEAR, LIST, QUIT, INVALID
}

public class SchoolTest {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        School pnu = new School("PNU", 100);
        while (true) {
            System.out.print("Enter Command String! ");

            final OperationKind op = getOperation() ;
            if (op == OperationKind.QUIT) {
                System.out.println("Bye");
                break;
            }
            if (op == OperationKind.INVALID) {
                System.out.println("Invalid Operation!");
                continue;
            }

            switch (op) {
                case ADD: {
                    Student newStudent = createStudent();
                    pnu.addStudent(newStudent);
                    break ;
                }
                case FIND: findStudent(pnu); break;
                case CLEAR: pnu.removeAllStudent(); break;
                case LIST: System.out.println(pnu); break;
                default: break;
            }
        }
    }

    private static void findStudent(final School school) {
        String studentName = scanner.next();
        int schoolYear = scanner.nextInt();
        Student foundStudent =
                school.findStudent(studentName, schoolYear);
        if (foundStudent != null) {
            System.out.println(foundStudent);
        } else {
            System.out.println("Student Not Found with name " + studentName +
                    " and year " + schoolYear);
        }
    }
    private static Student createStudent() {
        String studentName = scanner.next() ;
        int schoolYear = scanner.nextInt() ;
        return new Student(studentName, schoolYear) ;
    }

    // Get operation from stdin
    private static OperationKind getOperation() {
        String inputOp = scanner.next();
        inputOp = inputOp.toUpperCase();

        OperationKind op;

        try {
            op = OperationKind.valueOf(inputOp);
        } catch (Exception e) {
            // if inputOp is not in OperationKind
            return OperationKind.INVALID;
        }

        return op;
    }
}

