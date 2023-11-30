package Lab09;

public abstract class Figure implements MyComparable {
    protected int size;

    public abstract int compareTo(MyComparable other);
    public abstract int getSize();
}
