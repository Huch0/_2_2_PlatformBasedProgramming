package Lab08;

public class InvalidShapeException extends Exception {
    private double area;

    public InvalidShapeException(double area) {
        this.area = area;
    }

    public double getArea() {
        return this.area;
    }

    @Override
    public String toString() {
        return "Invalid Shape variables\n"
                + "area : " + this.area
                + "\nType of area should be double.";
    }
}
