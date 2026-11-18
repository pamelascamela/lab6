import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class MyBinarySearchTreeNodeTest {

    @Test
    void testgetItem() {
        MyBinarySearchTreeNode<String> node = new MyBinarySearchTreeNode<>("item");

        assertEquals("item", node.getItem());
    }

    @Test
    void testRoot() {
        MyBinarySearchTreeNode<String> node = new MyBinarySearchTreeNode<>("item");

        assertNull(node.getParent());
    }

    @Test
    void testRootChildren() {
        MyBinarySearchTreeNode<Integer> root = new MyBinarySearchTreeNode<>(10);

        MyBinarySearchTreeNode<Integer> left = root.insert(5);
        MyBinarySearchTreeNode<Integer> right = root.insert(15);

        assertNotNull(left);
        assertNotNull(right);
        assertSame(root, left.getParent());
        assertSame(root, right.getParent());
        // assertSame(left, right.getParent());
    }

    @Test
    void testNull() {
        MyBinarySearchTreeNode<Integer> root = new MyBinarySearchTreeNode<>(10);

        assertNull(root.insert(10));
    }
}
