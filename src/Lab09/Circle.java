package Lab09;

public class Circle extends Figure {
    private Point center;
    private int radius;

    Circle(int x, int y, int radius) {
        this.center = new Point(x, y);
        this.radius = radius;
        super.setSize((int) (Math.PI * Math.pow(radius, 2)));
    }

    @Override
    public int getSize() {
        return super.getSize();
    }

    @Override
    public int compareTo(MyComparable other) {
        return super.compareTo(other);
    }

    @Override
    public String toString() {
        return String.format("[[%d, %d] %d %d]", this.center.getX(), this.center.getY(), this.radius, this.getSize());
    }
}
