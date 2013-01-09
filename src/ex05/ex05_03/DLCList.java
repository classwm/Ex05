package ex05.ex05_03;

public class DLCList<T> {

    /**
     * Konstrukotr bezparametrowy, tworzy listę składającą się tylko z
     * wartownika
     */
    public DLCList() {
        head = new Node<>(null, null, null);
    } // DLCList() konstruktor

    /**
     * Konstruktor listy z tablicy elementów z zachowaniem kolejności
     *
     * @param keys
     */
    public DLCList(T[] keys) {
        this();
        for (int i = keys.length - 1; i >= 0; i--) {
            insert(keys[i]);
        }
    }

    /**
     * Wstawia element (danego typu) na początek listy (za wartownikiem)
     *
     * @param key
     */
    public void insert(T key) {

        if (head.getNext() == null) {
            Node<T> target = new Node<>(key, head, head);
            head.setNext(target);
            head.setPrev(target);
        } else {
            Node<T> target = new Node<>(key, head, head.getNext());
            (head.getNext()).setPrev(target);
            head.setNext(target);
        }
    } // insert

    /**
     * Kasuje z listy podany element
     *
     * @param key
     */
    public void delete(T key) {

        Node<T> nodeCurr = head.getNext();
        Node<T> nodeNext = nodeCurr.getNext();

        if (nodeCurr.getValue() == key && nodeNext != head) {
            head.setNext(nodeNext);
            nodeNext.setPrev(head);
        } else if (nodeCurr.getValue() == key && nodeNext == head) {
            head.setNext(null);
            head.setPrev(null);
        } else {
            while (nodeCurr != head) {
                if (nodeNext.getValue() == key) {
                    nodeCurr.setNext(nodeNext.getNext());
                    (nodeNext.getNext()).setPrev(nodeCurr);
                    return;
                }
                nodeCurr = nodeCurr.getNext();
                nodeNext = nodeCurr.getNext();
            }
        }
    }

    /**
     * Wyszukuje na liście element o podanej wartości; zwraca true jeśli element
     * wystepuje, false jesli nie występuje
     *
     * @param key
     */
    public boolean search(T key) {


        return true;

    }

    /**
     * Trawersuje listę i wyświetla jej elementy bez wartownika
     */
    public void display() {

        System.out.print("Lista:");
        Node<T> node = head.getNext();
        while (node != head) {
            System.out.print(" " + node.getValue());
            node = node.getNext();
        }
        System.out.println("");
    } // display   

    /**
     * Trawersuje listę i wyświetla jej elementy wraz z wartownikiem oraz
     * wartościami pól elementów
     */
    public void displayAll() {

        Node<T> node = head.getNext();
        if (node == null) {
            System.out.println("Lista jest pusta.");
            nodeFrame();
            System.out.println("| Prev: " + head.getPrev());
            nodeFrame();
            System.out.println("| HEAD: " + head.getValue());
            nodeFrame();
            System.out.println("| Next: " + head.getNext());
            nodeFrame();
        } else {
            nodeFrame();
            System.out.println("| Prev: " + (head.getPrev()).getValue());
            nodeFrame();
            System.out.println("| HEAD: " + head.getValue());
            nodeFrame();
            System.out.println("| Next: " + (head.getNext()).getValue());
            nodeFrame();
            while (node != head) {
                System.out.println("");
                nodeFrame();
                System.out.println("| Prev: " + (node.getPrev()).getValue());
                nodeFrame();
                System.out.println("| Value: " + node.getValue());
                nodeFrame();
                System.out.println("| Next: " + (node.getNext()).getValue());
                nodeFrame();
                node = node.getNext();
            }
        }
        System.out.println("");
    } // displayFull

    /**
     * Metoda pomocnicza dla displayAll
     */
    public void nodeFrame() {
        System.out.println("|----------------|");
    }
    /**
     * Wartownik listy
     */
    private Node<T> head;
} // DLCList
