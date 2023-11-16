package Lab08;

public class Triangle extends Shape {
    private int width;
    private int height;

    public Triangle(int width, int height) {
        super((double)width * height * 1/3);
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return String.format("Triangle %d %d %.6f", this.width, this.height, this.getArea());
    }
}
