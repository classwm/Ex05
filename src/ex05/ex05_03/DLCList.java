package ex05.ex05_03;

public class DLCList<T> {

    /**
     * Konstrukotr bezparametrowy, tworzy listę składającą się tylko z
     * wartownika
     */
    public DLCList() {
        sentinel = new Node<>(null, null, null);
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
     * Wstawia element (danego typu) na początek listy (po wartowniku)
     *
     * @param key
     */
    public void insert(T key) {

        if (sentinel.getNext() == null) {
            Node<T> target = new Node<>(key, sentinel, sentinel);
            sentinel.setNext(target);
            sentinel.setPrev(target);
        } else {
            Node<T> target = new Node<>(key, sentinel, sentinel.getNext());
            (sentinel.getNext()).setPrev(target);
            sentinel.setNext(target);
        }
    } // insert

    /**
     * Kasuje z listy podany element
     *
     * @param key
     */
    public void delete(T key) {

        Node<T> nodeCurr = sentinel.getNext();
        Node<T> nodeNext = nodeCurr.getNext();

        if (nodeCurr.getValue() == key && nodeNext != sentinel) {
            sentinel.setNext(nodeNext);
            nodeNext.setPrev(sentinel);
        } else if (nodeCurr.getValue() == key && nodeNext == sentinel) {
            sentinel.setNext(null);
            sentinel.setPrev(null);
        } else {
            while (nodeCurr != sentinel) {
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
     * Wyszukuje na liście element o podanej wartości; zwraca element jeśli
     * wystepuje, null jesli nie występuje
     *
     * @param key
     */
    public Node<T> search(T key) {

        Node<T> node = sentinel.getNext();
        while (node != sentinel) {
            if (key.equals(node.getValue())) {
                return (node);
            }
            node = node.getNext();
        }
        return null;
    } // search

    /**
     * Trawersuje listę i wyświetla jej elementy bez wartownika
     */
    public void display() {

        System.out.print("Lista:");
        Node<T> node = sentinel.getNext();
        while (node != sentinel) {
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

        Node<T> node = sentinel.getNext();
        if (node == null) {
            System.out.println("Lista jest pusta.");
            nodeFrame();
            System.out.println("| Prev: " + sentinel.getPrev());
            nodeFrame();
            System.out.println("| SENTINEL: " + sentinel.getValue());
            nodeFrame();
            System.out.println("| Next: " + sentinel.getNext());
            nodeFrame();
        } else {
            nodeFrame();
            System.out.println("| Prev: " + (sentinel.getPrev()).getValue());
            nodeFrame();
            System.out.println("| SENTINEL: " + sentinel.getValue());
            nodeFrame();
            System.out.println("| Next: " + (sentinel.getNext()).getValue());
            nodeFrame();
            while (node != sentinel) {
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
    private Node<T> sentinel;
} // DLCList