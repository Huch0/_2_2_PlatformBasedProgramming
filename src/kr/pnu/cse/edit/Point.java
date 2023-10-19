package kr.pnu.cse.edit;

public class Point {
    private int x, y;

    public Point(int inputX, int inputY) {
        x = inputX;
        y = inputY;
    }

    @Override
    public String toString() {
        return "[" + x +
                ", " + y +
                ']';
    }
}