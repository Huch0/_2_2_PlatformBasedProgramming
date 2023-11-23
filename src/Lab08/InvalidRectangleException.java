package Lab08;

public class InvalidRectangleException extends InvalidShapeException {
    private int width;
    private int height;

    public InvalidRectangleException(int width, int height, double area) {
        super(area);
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nwidth : " + this.width
                + ", height : " + this.height
                + "\nwidth, height should be positive integer.";
    }
}
