package Lab09;

public class InvalidLineException extends Exception{
    private Object InvalidPointException;

    @Override
    public String toString() {
        return  "Invalid Circle Exception\n"
                + InvalidPointException;
    }
}
