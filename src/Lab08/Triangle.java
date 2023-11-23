package Lab08;

public class Triangle extends Shape {
    private int width;
    private int height;

    public Triangle(int width, int height) throws InvalidTriangleException {
        super((double)width * height * 1/2);
        this.width = width;
        this.height = height;

        if (width <= 0 || height <= 0) {
            throw new InvalidTriangleException(width, height, this.getArea());
        }
    }

    @Override
    public String toString() {
        return String.format("Triangle %d %d %.6f", this.width, this.height, this.getArea());
    }
}
