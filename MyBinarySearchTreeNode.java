import java.util.List;

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

    public T getItem(){
        return this.item;
    }

    public MyBinarySearchTreeNode<T> getParent(){
        return this.parent;
    }

    public MyBinarySearchTreeNode<T> insert(T item){
        if (this.item.compareTo(item) == 0){
            return null;
        }
        if (this.item.compareTo(item) < 0 ){
            if (this.leftChild == null){
                MyBinarySearchTreeNode<T> newLeft = new MyBinarySearchTreeNode<T>(item, this);
                this.leftChild = newLeft;
                return newLeft;
            }
            else {
                return this.leftChild.insert(item);
            }
        }
        if (this.item.compareTo(item) > 0 ){
            if (this.rightChild == null){
                MyBinarySearchTreeNode<T> newRight = new MyBinarySearchTreeNode<T>(item, this);
                this.rightChild = newRight;
                return newRight;
            }
            else {
                return this.rightChild.insert(item);
            }
        }
        return null;
    }

    public void preOrder(List<T> list){
        list.add(this.item);
        if (this.leftChild != null) {
            this.leftChild.preOrder(list);
        }
        if (this.rightChild != null) {
            this.rightChild.preOrder(list);
        }
    }
    public void inOrder(List<T> list){
        if (this.leftChild != null) {
            this.leftChild.preOrder(list);
        }
        list.add(this.item);
        if (this.rightChild != null) {
            this.rightChild.preOrder(list);
        }
    }
    public void postOrder(List<T> list){
        if (this.leftChild != null) {
            this.leftChild.preOrder(list);
        }
        if (this.rightChild != null) {
            this.rightChild.preOrder(list);
        }
        list.add(this.item);
    }

}