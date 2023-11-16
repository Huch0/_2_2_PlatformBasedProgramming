package Lab08;

public class Circle extends Shape {
    private int centerX;
    private int centerY;
    private int radius;

    public Circle(int centerX, int centerY,int radius) {
        super(Math.PI * Math.pow(radius, 2));
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    @Override
    public String toString() {
        return String.format("Circle %d %d %.6f", this.centerX, this.centerY, this.radius, this.getArea());
    }
}
