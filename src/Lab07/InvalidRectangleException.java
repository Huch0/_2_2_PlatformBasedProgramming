package Lab07;

public class InvalidRectangleException extends Exception {
    private int width, height ;
    public InvalidRectangleException(int width, int height) {
        this.width = width ;
        this.height = height ;
    }
    public int getWidth() { return width; }
    public int getHeight() { return height; }

    // TODO: toString
    // 사각형의 넓이와 높이는 양수이어야 합니다. 20 -10
    @Override
    public String toString() {
        return "사각형의 넓이와 높이는 양수이어야 합니다." +
                " " + width +
                " " + height;
    }
}
