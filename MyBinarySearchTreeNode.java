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
        if (this.item.compareTo(item) > 0 ){
            if (this.leftChild == null){
                MyBinarySearchTreeNode<T> newLeft = new MyBinarySearchTreeNode<T>(item, this);
                this.leftChild = newLeft;
                return newLeft;
            }
            else {
                return this.leftChild.insert(item);
            }
        }
        if (this.item.compareTo(item) < 0 ){
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
            if (this.rightChild!= null){
                return this.rightChild.find(obj);
            }
            return null;
        }
        if (this.item.compareTo(obj) > 0){
            if (this.leftChild!= null){
                return this.leftChild.find(obj);
            }
            return null;
            
        }
        return null;
    }

    private MyBinarySearchTreeNode<T> findSuccessor(){
        if (this.rightChild != null){
            MyBinarySearchTreeNode<T> current = this.rightChild;
            while (current.leftChild != null){
            current = current.leftChild;
        }
        return current;
        }
        return this;
    }

    public void remove(T item){
        MyBinarySearchTreeNode<T> current = this;

        if (current.item.compareTo(item) == 0){
            if (current.leftChild == null && current.rightChild == null){
                if (current.parent != null){
                    if (current.item.compareTo(current.parent.item) < 0){
                        current.parent.leftChild = null;
                    }
                    if (current.item.compareTo(current.parent.item) > 0){
                        current.parent.rightChild = null;
                    }
                }
                return;
            }

            if (current.leftChild != null && current.rightChild == null){
                if (current.parent != null){
                    if (current.item.compareTo(current.parent.item) < 0){
                        current.parent.leftChild = current.leftChild;
                    }
                    if (current.item.compareTo(current.parent.item) > 0){
                        current.parent.rightChild = current.leftChild;
                    }
                }
                current.leftChild.parent = current.parent;
                return;
            }

            if (current.leftChild == null && current.rightChild != null){
                if (current.parent != null){
                    if (current.item.compareTo(current.parent.item) < 0){
                        current.parent.leftChild = current.rightChild;
                    }
                    if (current.item.compareTo(current.parent.item) > 0){
                        current.parent.rightChild = current.rightChild;
                    }
                }
                current.rightChild.parent = current.parent;
                return;
            }

            MyBinarySearchTreeNode<T> saved = current.findSuccessor();
            T savedItem = saved.item;
            saved.remove(savedItem);
            current.item = savedItem;
            return;
        }

        if (current.item.compareTo(item) < 0){
            if (current.rightChild != null){
                current.rightChild.remove(item);
            }
        }
        else {
            if (current.leftChild != null){
                current.leftChild.remove(item);
            }
        }
}
}