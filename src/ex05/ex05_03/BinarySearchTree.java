package ex05.ex05_03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {

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
    private BSTNode root;

    public void insert(T key) {
        root = insert(root, key);
    }

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
    }

    public T search(T key) {
        return search(root, key);
    }

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
    }

    public void displayAsList() {
        List<T> list = new ArrayList<>();
        traversal(root, list);
        for (Iterator<T> it = list.iterator(); it.hasNext();) {
            T node = it.next();
            System.out.println(node);
        }
    }

    private void traversal(BSTNode node, List<T> list) {
        if (node != null) {
            traversal(node.leftChild, list);
            list.add(node.getKey());
            traversal(node.rightChild, list);
        }
    }

    public static void main(String[] args) {

        BinarySearchTree<Integer> treeInt = new BinarySearchTree<>();
        BinarySearchTree<String> treeStr = new BinarySearchTree<>();

        Integer[] numbers = {50, 1, 2, 3, 24, 4, 5, 6, 7, -30, 60, 134, 50, 500, -148};
        String[] letters = {"H", "C", "S", "A", "E", "R", "X"};

        for (Integer number : numbers) {
            treeInt.insert(number);
        }
        treeInt.displayAsList();
        System.out.println("Root drzewa: " + treeInt.root.getKey());
        System.out.println("Klucz/wartość 24" + (treeInt.search(24) != null ? "" : " nie") + " znajduje się w drzewie.");
        System.out.println("Klucz/wartość 300" + (treeInt.search(300) != null ? "" : " nie") + " znajduje się w drzewie.");

        for (String letter : letters) {
            treeStr.insert(letter);
        }
        treeStr.displayAsList();
        System.out.println("     Root drzewa: " + treeStr.root.getKey());
        System.out.println("Lewe: " + treeStr.root.getLeftChild().getKey() + "       Prawe: " + treeStr.root.getRightChild().getKey());
        System.out.println("Klucz/wartość 'R'" + (treeStr.search("R") != null ? "" : " nie") + " znajduje się w drzewie.");
        System.out.println("Klucz/wartość 'Y'" + (treeStr.search("Y") != null ? "" : " nie") + " znajduje się w drzewie.");


    }
} // BinarySearchTree
