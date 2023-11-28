package Lab09;

public abstract class Figure implements MyComparable {
    private int size;

    public int compareTo(MyComparable other) {
        if (this.getSize() == other.getSize())
            return 0;
        else if (this.getSize() > other.getSize())
            return 1;
        else
            return -1;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
