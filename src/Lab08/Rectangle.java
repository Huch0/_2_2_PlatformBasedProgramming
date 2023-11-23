package Lab08;

public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) throws InvalidRectangleException {
        super((double)width * height);
        this.width = width;
        this.height = height;

        if (width <= 0 || height <= 0) {
            throw new InvalidRectangleException(width, height, this.getArea());
        }
    }

    @Override
    public String toString() {
        return String.format("Rectangle %d %d %.6f", this.width, this.height, this.getArea());
    }
}
