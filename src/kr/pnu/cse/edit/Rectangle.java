package kr.pnu.cse.edit;

public class Rectangle {
    private int width, height;
    private double area;

    public Rectangle(int inputWidth, int inputHeight) {
        width = inputWidth;
        height = inputHeight;
        area = (double) width * height;
    }
    @Override
    public String toString() {
        return "[ Rectangle " + width +
                " " + height +
                " " + String.format("%.6f", area) +
                ']';
    }
}
