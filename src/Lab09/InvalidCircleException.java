package Lab09;

public class InvalidCircleException extends Exception {
    public int radius;
    private String msg;

    InvalidCircleException(int radius) {
        this.radius = radius;
        this.msg = "Invalid Circle Exception\n"
                + "radius of Circle should be positive integer\n"
                + "current radius : " + radius;
    }
    @Override
    public String toString() {
        return this.msg;
    }
}
