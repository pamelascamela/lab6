public class MyBinarySearchTreeNode<T extends Comparable>{
    private T item;
    private MyBinarySearchTreeNode<T> parent;
    private MyBinarySearchTreeNode<T> leftChild;
    private MyBinarySearchTreeNode<T> rightChild;

    private MyBinarySearchTreeNode(T item, MyBinarySearchTreeNode<T> parent){
        this.parent = parent;
        this.item = item;
        this.leftChild = null;
        this.rightChild = null;
    }

    public MyBinarySearchTreeNode(T item){
        this(item, null);
    }



}