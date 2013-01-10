package ex05.ex05_03;

public class Node<T> {

    /**
     * Tworzy element dwukierunkowej listy - value 
     * @param value wartość elementu
     * @param prev poprzedni element
     * @param next następny element
     */
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
    
    public void setValue(T value) {
        this.value = value;
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
