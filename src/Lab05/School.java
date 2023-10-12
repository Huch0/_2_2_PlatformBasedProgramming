package Lab05;

public class School {
    private String name;
    private int limit;

    private Student[] students;
    private int studentCount;

    @Override
    public String toString() {
        String msg = "School Name: " + name + " Student Count: "
                + studentCount + "\n";

        for (int i = 0; i < studentCount; i++) {
            msg += "\t" + students[i] + "\n";
        }
        return msg;
    }

    // other methods including constructor, equals(), hashCode()
    public School(String name, int limit) {
        this.name = name;
        this.limit = limit;
        this.students = new Student[limit];
        this.studentCount = 0;
    }

    // Add new student to students
    public void addStudent(Student newStudent) {
        if (isFull())
            return;
        this.students[this.studentCount++] = newStudent;
    }

    // Remove all students in students
    public void removeAllStudent() {
        for (int i = 0; i < this.studentCount; i++) {
            this.students[i] = null;
        }
        this.studentCount = 0;
    }

    // Find a student by studentName and studentYear
    public Student findStudent(String studentName, int studentYear) {
        Student studentToFind = new Student(studentName, studentYear);

        for (int i = 0; i < this.studentCount; i++) {
            if (this.students[i].equals(studentToFind))
                return this.students[i];
        }
        return null;
    }

    // Return is students full
    private boolean isFull() {
        return this.studentCount == this.limit;
    }
}

