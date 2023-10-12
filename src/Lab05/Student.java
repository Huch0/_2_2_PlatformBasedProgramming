package Lab05;

public class Student {
    private final String name;
    private final int year;

    // other methods including constructor,
    // toString(), equals(), hashcode()
    public Student(String name, int year) {
        this.name = name;
        this.year = year;
    }

    @Override
    public boolean equals(Object objToCompare) {
        if (this == objToCompare) {
            return true; // Same reference, no need for further comparison.
        }
        if (objToCompare == null || this.getClass() != objToCompare.getClass()) {
            return false; // Different classes or null object.
        }
        Student toCompare = (Student) objToCompare;
        return this.name.equals(toCompare.name) && this.year == toCompare.year;
    }

    @Override
    public String toString() {
        // ex) [James, 1학년]
        return "[" + this.name + ", " + this.year + "학년]";
    }
}
