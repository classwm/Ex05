package ex05.ex05_03;

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
        return root;
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

        public BSTNode getParent() {
            return parent;
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

        public void setParent(BSTNode parent) {
            this.parent = parent;
        }
        private T key;
        private BSTNode leftChild;
        private BSTNode rightChild;
        private BSTNode parent;
    } // BSTNode
    private BSTNode root;
} // BinarySearchTree
