package Lab08;

public class InvalidCircleException extends InvalidShapeException {
    private int centerX;
    private int centerY;
    private int radius;

    public InvalidCircleException(int centerX, int centerY, int radius, double area) {
        super(area);
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\ncenterX : " + this.centerX
                + ", centerY : " + this.centerY
                + ", radius : " + this.radius
                + "\ncenterX, centerY, radius should be positive integer.";
    }
}
