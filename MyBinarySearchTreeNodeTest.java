import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

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

    private MyBinarySearchTreeNode<Integer> createTraversalTree() {
        MyBinarySearchTreeNode<Integer> root = new MyBinarySearchTreeNode<>(151);
        root.insert(150);
        root.insert(241);
        root.insert(210);
        root.insert(275);
        root.insert(280);
        return root;
    }
    @Test
    void testPreOrderTraversal() {
        List<Integer> items = new ArrayList<>();
        MyBinarySearchTreeNode<Integer> root = createTraversalTree();

        root.preOrder(items);

        assertEquals(List.of(151, 241, 275, 280, 210, 150), items);
    }

    @Test
    void testInOrderTraversal() {
        List<Integer> items = new ArrayList<>();
        MyBinarySearchTreeNode<Integer> root = createTraversalTree();

        root.inOrder(items);

        assertEquals(List.of(280, 275, 241, 210, 151, 150), items);
    }

    @Test
    void testPostOrderTraversal() {
        List<Integer> items = new ArrayList<>();
        MyBinarySearchTreeNode<Integer> root = createTraversalTree();

        root.postOrder(items);

        assertEquals(List.of(280, 275, 210, 241, 150, 151), items);
    }

    
}
