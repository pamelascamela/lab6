import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class MyBinarySearchTreeNodeTest {

    @Test
    void getItemReturnsTheNodeItem() {
        MyBinarySearchTreeNode<String> node = new MyBinarySearchTreeNode<>("item");

        assertEquals("item", node.getItem());
    }

    @Test
    void getParentReturnsNullForRootNode() {
        MyBinarySearchTreeNode<String> node = new MyBinarySearchTreeNode<>("item");

        assertNull(node.getParent());
    }
}
