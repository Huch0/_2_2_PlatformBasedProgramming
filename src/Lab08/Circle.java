package Lab08;

public class Circle extends Shape {
    private int centerX;
    private int centerY;
    private int radius;

    public Circle(int centerX, int centerY,int radius) throws InvalidCircleException {
        super(Math.PI * Math.pow(radius, 2));
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;

        if (centerX <= 0 || centerY <= 0 || radius <= 0) {
            throw new InvalidCircleException(centerX, centerY, radius, this.getArea());
        }
    }

    @Override
    public String toString() {
        return String.format("Circle %d %d %d %.6f", this.centerX, this.centerY, this.radius, this.getArea());
    }
}
