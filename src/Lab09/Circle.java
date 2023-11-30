package Lab09;

public class Circle extends Figure {
    private Point center;
    private int radius;

    Circle(int x, int y, int radius) throws InvalidCircleException {
        this.center = new Point(x, y);
        this.radius = radius;
        this.size = (int) (Math.PI * Math.pow(radius, 2));

        if (radius <= 0) {
            throw new InvalidCircleException(radius);
        }
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int compareTo(MyComparable other) {
        if (this.getSize() == other.getSize())
            return 0;
        else if (this.getSize() > other.getSize())
            return 1;
        else
            return -1;
    }

    @Override
    public String toString() {
        return String.format("[[%d, %d] %d %d]", this.center.getX(), this.center.getY(), this.radius, this.getSize());
    }
}
