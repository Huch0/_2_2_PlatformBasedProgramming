package kr.pnu.cse.edit;

public class Circle {
    private Point center;
    private int radius;
    private double area;

    public Circle (Point inputCenter, int inputRadius) {
        center = inputCenter;
        radius = inputRadius;
        area = Math.PI * (double) radius * radius;
    }
    @Override
    public String toString() {
        return "[ Circle " + center.toString() +
                " " + radius +
                " " + String.format("%.6f", area) +
                ']';
    }
}

