package Lab07;

public class Rectangle {
    private int width, height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void scale(int ratio) {
        this.width *= ratio;
        this.height *= ratio;
    }

    @Override
    public String toString() {
        return "Rectangle: width " + width + ", height " + height;
    }
}
