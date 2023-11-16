package Lab08;

public abstract class Shape {
    private double area;

    public Shape(double area) {
        this.area = area;
    }

    public double getArea() {
        return this.area;
    }

    @Override
    public String toString() {
        return String.valueOf(area);
    }
}
