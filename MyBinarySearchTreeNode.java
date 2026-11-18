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
            this.leftChild.inOrder(list);
        }
        list.add(this.item);
        if (this.rightChild != null) {
            this.rightChild.inOrder(list);
        }
    }
    public void postOrder(List<T> list){
        if (this.leftChild != null) {
            this.leftChild.postOrder(list);
        }
        if (this.rightChild != null) {
            this.rightChild.postOrder(list);
        }
        list.add(this.item);
    }

    public MyBinarySearchTreeNode<T> find(Object obj){
        if (this.item.compareTo(obj) == 0){
            return this;
        }
        if (this.item.compareTo(obj) < 0){
            if (this.leftChild!= null){
                return this.leftChild.find(obj);
            }
            return null;
        }
        if (this.item.compareTo(obj) > 0){
            if (this.rightChild!= null){
                return this.rightChild.find(obj);
            }
            return null;
            
        }
        return null;
    }

    private MyBinarySearchTreeNode<T> findSuccessor(){
        if (this.rightChild != null){
            this.rightChild = this;
        }
        while (this.leftChild != null){
            this.leftChild = this;
        }
        return this;
    }

    public void remove(T item){
        if (this.item.compareTo(item) == 0){
            if (this.leftChild == null && this.rightChild == null){
                if (this.item.compareTo(parent.item) < 0){
                    parent.leftChild = null;
                }
                if (this.item.compareTo(parent.item) > 0){
                    parent.rightChild = null;
                }
            }
            if (this.leftChild != null && this.rightChild == null){
                if (this.item.compareTo(parent.item) < 0){
                    parent.leftChild = this.leftChild;
                }
                if (this.item.compareTo(parent.item) > 0){
                    parent.rightChild = this.leftChild;
                }
            }
            if (this.leftChild == null && this.rightChild != null){
                if (this.item.compareTo(parent.item) < 0){
                    parent.leftChild = this.rightChild;
                }
                if (this.item.compareTo(parent.item) > 0){
                    parent.rightChild = this.rightChild;
                }
            }
            MyBinarySearchTreeNode<T> saved = this.findSuccessor();
            T savedItem = saved.item;
            this.remove(savedItem);
            this.item = savedItem;

    }
        if (this.item.compareTo(item) < 0){
            this.rightChild.remove(item);
        }

        this.leftChild.remove(item);
    }
}