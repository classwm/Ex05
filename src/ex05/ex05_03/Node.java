package ex05.ex05_03;

public class Node<T> {

    public Node(T value, Node<T> prev, Node<T> next) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public Node<T> getNext() {
        return next;
    }    
    
    public void setValue(T data) {
        this.value = data;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
    private T value;
    private Node<T> next;
    private Node<T> prev;
}
