package ex05.co05_03.pairtest1;

/**
 * @version 1.00 2004-05-10
 * @author Cay Horstmann
 */
public class Triple<T> {

    public Triple() {
        first = null;
        second = null;
        third = null;
    }

    public Triple(T first, T second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public T getThird() {
        return third;
    }

    public void setFirst(T newValue) {
        first = newValue;
    }

    public void setSecond(T newValue) {
        second = newValue;
    }

    public void setThird(T newValue) {
        third = newValue;
    }
    private T first;
    private T second;
    private T third;
}