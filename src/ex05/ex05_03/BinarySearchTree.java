package ex05.ex05_03;

public class BinarySearchTree<T extends Comparable<T>> {

    /**
     * Klasa węzła drzewa wyszukiwania binarnego, dla uproszczenia implementacji
     * przyjmuje się, że klucz jest równoważny z wartością węzła
     */
    private class BSTNode {

        public BSTNode(T key) {
            this.key = key;
        }

        public T getKey() {
            return key;
        }

        public BSTNode getLeftChild() {
            return leftChild;
        }

        public BSTNode getRightChild() {
            return rightChild;
        }

        public void setKey(T key) {
            this.key = key;
        }

        public void setLeftChild(BSTNode leftChild) {
            this.leftChild = leftChild;
        }

        public void setRightChild(BSTNode rightChild) {
            this.rightChild = rightChild;
        }
        private T key;
        private BSTNode leftChild;
        private BSTNode rightChild;
    } // BSTNode
    /**
     * Węzeł root (korzeń) drzewa
     */
    private BSTNode root;

    /**
     * Dodanie do drzewa węzła na właściwą pozycję
     *
     * @param key klucz/wartość dodwanego węzła
     */
    public void insert(T key) {
        root = insert(root, key);
    }

    /**
     * Zmiana wartości/klucza lub utworzenie nowego węzła w poddrzewie
     *
     * @param root korzeń poddrzewa
     * @param key dodawany klucz/wartość
     * @return
     */
    private BSTNode insert(BSTNode root, T key) {
        if (root == null) {
            return new BSTNode(key);
        }
        int insertCompare = key.compareTo((root.getKey()));
        if (insertCompare < 0) {
            root.setLeftChild(insert(root.leftChild, key));
        } else if (insertCompare > 0) {
            root.setRightChild(insert(root.rightChild, key));
        } else {
            root.setKey(key);
        }
        return root;
    } // insert

    /**
     * Wyszukiwanie węzła o podanym kluczu/wartości, w przypadku znalezienia
     * zwraca szukaną wartość, w innym przypadku zwraca null
     *
     * @param key szukany klucz/wartość
     * @return klucz/wartość jeśli znalezione, null gdy brak
     */
    public T search(T key) {
        return search(root, key);
    }

    /**
     * Wyszukiwanie klucza/wartości w poddrzewie z korzenia root
     *
     * @param root korzeń poddrzewa
     * @param key szukany klucz/wartość
     * @return
     */
    private T search(BSTNode root, T key) {
        if (root == null) {
            return null;
        }
        int searchCompare = key.compareTo(root.getKey());
        if (searchCompare < 0) {
            return search(root.getLeftChild(), key);
        } else if (searchCompare > 0) {
            return search(root.getRightChild(), key);
        } else {
            return root.getKey();
        }
    } //search

    /**
     * Zwraca najmniejszy klucz/wartość drzewa
     *
     * @return
     */
    public T minimum() {
        return minimum(root).getKey();
    }

    /**
     * Zwraca najmniejszą wartość poddrzewaz korzenia root
     *
     * @param root korzeń poddrzewa
     * @return
     */
    private BSTNode minimum(BSTNode root) {
        if (root.getLeftChild() == null) {
            return root;
        }
        return minimum(root.getLeftChild());
    } // minimum

    /**
     * Usuwanie najmniejszego klucza/wartości z drzewa, używane przy usuwaniu
     * węzła z drzewa
     */
    public void deleteMinimal() {
        root = deleteMinimal(root);
    }

    private BSTNode deleteMinimal(BSTNode root) {
        if (root.getLeftChild() == null) {
            return root.getRightChild();
        }
        root.setLeftChild(deleteMinimal(root.getLeftChild()));
        return root;
    } // deleteMinimal

    /**
     * Usuwanie z drzewa węzła o podanym kluczu/wartości
     *
     * @param key
     */
    public void delete(T key) {
        root = delete(root, key);
    }

    private BSTNode delete(BSTNode root, T key) {
        if (root == null) {
            return null;
        }
        int deleteCompare = key.compareTo(root.getKey());
        if (deleteCompare < 0) {
            root.setLeftChild(delete(root.getLeftChild(), key));
        } else if (deleteCompare > 0) {
            root.setRightChild(delete(root.getRightChild(), key));
        } else {
            if (root.getRightChild() == null) {
                return root.getLeftChild();
            }
            if (root.getLeftChild() == null) {
                return root.getRightChild();
            }
            BSTNode tmp = root;
            root = minimum(tmp.getRightChild());
            root.setRightChild(deleteMinimal(tmp.getRightChild()));
            root.setLeftChild(tmp.getLeftChild());
        }
        return root;
    } // delete(T key)  

    /**
     * Wywołanie wyświetlenie listy węzłów drzewa
     */
    public void displayNodes() {
        displayNodes(root);
    }

    /**
     * Trawersal po strukturze drzewa, wyświetla listę węzłów
     *
     * @param node węzeł początkowy trawersu
     */
    private void displayNodes(BSTNode node) {
        if (node.getLeftChild() != null) {
            displayNodes(node.getLeftChild());
        }
        System.out.println(node.getKey() + " ");
        if (node.getRightChild() != null) {
            displayNodes(node.getRightChild());
        }
    } // displayNodes

    public static void main(String[] args) {

        BinarySearchTree<Integer> treeInt = new BinarySearchTree<>();
        BinarySearchTree<String> treeStr = new BinarySearchTree<>();

        Integer[] numbers = {50, 1, 2, 3, 24, 4, 5, 6, 7, -30, 60, 134, 50, 500, -148, 60};
        String[] letters = {"H", "C", "S", "A", "E", "R", "X"};

        for (Integer number : numbers) {
            treeInt.insert(number);
        }
        separator("=", "Drzewo Integerów dodanych z tablicy", 12);
        treeInt.displayNodes();
        System.out.println("Root drzewa: " + treeInt.root.getKey());
        separator("-", "Test szukania kluczy/wartości", 12);
        System.out.println("Klucz/wartość 24" + (treeInt.search(24) != null ? "" : " nie") + " znajduje się w drzewie.");
        System.out.println("Klucz/wartość 300" + (treeInt.search(300) != null ? "" : " nie") + " znajduje się w drzewie.");
        separator("-", "Test usuwania kluczy/wartości", 12);
        treeInt.delete(24);
        treeInt.displayNodes();
        System.out.println("Klucz/wartość 24" + (treeInt.search(24) != null ? "" : " nie") + " znajduje się w drzewie.");

        separator("=", "Drzewo Stringów dodanych z tablicy", 12);
        for (String letter : letters) {
            treeStr.insert(letter);
        }
        treeStr.displayNodes();
        System.out.println("    Root:  " + treeStr.root.getKey());
        System.out.println("Lewe: " + treeStr.root.getLeftChild().getKey() + "       Prawe: " + treeStr.root.getRightChild().getKey());

        separator("-", "Test szukania kluczy/wartości", 12);
        System.out.println("Klucz/wartość 'R'" + (treeStr.search("R") != null ? "" : " nie") + " znajduje się w drzewie.");
        System.out.println("Klucz/wartość 'Y'" + (treeStr.search("Y") != null ? "" : " nie") + " znajduje się w drzewie.");
        separator("-", "Test usuwania kluczy/wartości", 12);
        treeStr.delete("H");
        treeStr.displayNodes();
        System.out.println("    Root:  " + treeStr.root.getKey());
        System.out.println("Lewe: " + treeStr.root.getLeftChild().getKey() + "       Prawe: " + treeStr.root.getRightChild().getKey());
        System.out.println("Klucz/wartość 'H'" + (treeStr.search("H") != null ? "" : " nie") + " znajduje się w drzewie.");
    }

    /**
     * Formatowanie wyjścia danych programu.
     *
     * @param sep Ciąg znaków separatora.
     * @param info String z opisem następnego bloku wypisanych danych.
     * @param i Ilośc powtórzen wyświetlenia separatora.
     */
    private static void separator(String sep, String info, int i) {
        System.out.println("");
        while (i > 0) {
            System.out.print(sep);
            i--;
        }
        System.out.println(" " + info + ":");
    }
} // BinarySearchTree