package Lab09;

public class InvalidPointException extends NumberFormatException {
    private final String msg;

    InvalidPointException() {
        this.msg = "Invalid Point Exception\n"
                + "Point Coordinates should be integer type";
    }

    @Override
    public String toString() {
        return this.msg;
    }
}
