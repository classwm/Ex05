package ex05.ex05_03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {

    public BinarySearchTree(T key) {
        root = new BSTNode(key);
    }

    public void insert(T key) {

        root = insert(root, key);
    }

    private BSTNode insert(BSTNode root, T key) {
        if (root == null) {
            return new BSTNode(key);
        }
        int targetCompare = key.compareTo((root.getKey()));
        if (targetCompare < 0) {
            root.leftChild = insert(root.leftChild, key);
        } else if (targetCompare > 0) {
            root.rightChild = insert(root.rightChild, key);
        } else {
            root.setKey(key);
        }
        return root;
    }
    

    public void displayListFromBST() {
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
} // BinarySearchTree
