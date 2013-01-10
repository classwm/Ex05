
package ex05.ex05_03;


public class BSTNode<T> {

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