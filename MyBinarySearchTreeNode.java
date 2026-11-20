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


//i also made two helper methods here for children and parent checks because we use that a lot in remove and i didnt want to have to rewrite everything all the time
    private MyBinarySearchTreeNode<T> checkChildren(){
        if (this.leftChild == null && this.rightChild == null){
            return null; //is leaf
        }
        if (this.leftChild == null && this.rightChild != null){
            return rightChild; // has a right child only
        }
        if (this.leftChild != null && this.rightChild == null){
            return leftChild; //has a left child only
        }
        return this; //has two children
    }

    private int checkParent(){
        if (this.parent == null){
            return 0; //is the left child
        }
        if (this.parent.leftChild == this){
            return -1; //is the left child
        }
        if (this.parent.rightChild == this){
            return 1; // is the right child
        }
        return 0; //is root
    }


    public void remove(T item){
        //if current item is bigger than searched item
        int compareResult = this.item.compareTo(item);
        if (compareResult > 0){
            if (leftChild != null){
                leftChild.remove(item);
            }
            return;
        }
        //if current item is smaller than searched item
        if (compareResult < 0){
            if (rightChild != null){
                rightChild.remove(item);
            }
            return;
        }
        //if its the right item

        int position = checkParent();
        MyBinarySearchTreeNode<T> children = checkChildren();
//if it has two children (shouldnt matter if its the roomt)
                if(children == this){
                    MyBinarySearchTreeNode<T> successor = findSuccessor();
                    this.item = successor.item;
                    successor.remove(successor.item);
                    return;
                }
//if root
                if(position == 0){
                    //only has one child since i already handled the two child situation
                    if (children != null){
                        this.item = children.item;
                        this.leftChild = children.leftChild;
                        this.rightChild = children.rightChild;
                        if (leftChild != null) {
                            leftChild.parent = this;
                        }
                        if (rightChild != null) {
                            rightChild.parent = this;
                        }
                    }
                    return;
                }
                //if not root and left child
                if (position < 0){
                    parent.leftChild = children;
                }
                else {
                    parent.rightChild = children;
                }
                if (children != null) {
                    children.parent = parent;
                }

}
}