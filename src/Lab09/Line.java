package Lab09;

public class Line extends Figure {
    private Point point1, point2;

    Line(int x1, int y1, int x2, int y2) {
        this.point1 = new Point(x1, y1);
        this.point2 = new Point(x2, y2);

        super.setSize(Point.pointsDistance(this.point1, this.point2));
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
        return String.format("[[%d, %d] [%d, %d] %d]",
                this.point1.getX(), this.point1.getY(), this.point2.getX(), this.point2.getY(), this.getSize());
    }
}
