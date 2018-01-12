package yao.algs.tree;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import yao.algs.array.ResizableArray;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * BinaryTreeUtil Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jan 12, 2018</pre>
 */
public class BinaryTreeUtilTest {

    private static BinaryTreeNode<String> root;
    private String expectedPreOrder;
    private String expectedPostOrder;
    private String expectedInOrder;

    ResizableArray<String> list;
    String actual;


    @BeforeClass
    public void createTree() {
        BinaryTreeNode<String> D = new BinaryTreeNode<>("D", null, null);
        BinaryTreeNode<String> H = new BinaryTreeNode<>("H", null, null);
        BinaryTreeNode<String> I = new BinaryTreeNode<>("I", null, null);
        BinaryTreeNode<String> J = new BinaryTreeNode<>("J", null, null);
        BinaryTreeNode<String> P = new BinaryTreeNode<>("P", null, null);
        BinaryTreeNode<String> G = new BinaryTreeNode<>("G", P, null);
        BinaryTreeNode<String> F = new BinaryTreeNode<>("F", null, J);
        BinaryTreeNode<String> E = new BinaryTreeNode<>("E", H, I);
        BinaryTreeNode<String> B = new BinaryTreeNode<>("B", D, E);
        BinaryTreeNode<String> C = new BinaryTreeNode<>("C", F, G);
        BinaryTreeNode<String> A = new BinaryTreeNode<>("A", B, C);
        root = A;
    }

    /**
     * 手工构建二叉树测试
     * -------------------A
     * -----------B                C
     * -------D      E         F       G
     * ------------H  I         J     P
     */
    @Before
    public void before() throws Exception {


        expectedPreOrder = "[A, B, D, E, H, I, C, F, J, G, P]";
        expectedPostOrder = "[D, H, I, E, B, J, F, P, G, C, A]";
        expectedInOrder = "[D, B, H, E, I, A, F, J, C, P, G]";


    }

    @After
    public void after() throws Exception {
        root = null;
        actual = "";
    }

    /**
     * Method: traversePreOrderIterative(BinaryTreeNode<E> root)
     */
    @Test
    public void testTraversePreOrderIterative() throws Exception {
//        ResizableArray list = BinaryTreeUtil.traversePreOrderIterative(root);
//        String actual = Arrays.toString(list.toArray(new String[list.size()]));
//        assertEquals(expectedPreOrder, actual);
    }

    /**
     * Method: traversePreOrderDFSIterative(BinaryTreeNode<E> root)
     */
    @Test
    public void testTraversePreOrderDFSIterative() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: traversePreOrderRecursive(BinaryTreeNode<E> root)
     */
    @Test
    public void testTraversePreOrderRecursive() throws Exception {
        list = BinaryTreeUtil.traversePreOrderRecursive(root);
        actual = Arrays.toString(list.toArray(new String[list.size()]));
        assertEquals(expectedPreOrder, actual);
    }

    /**
     * Method: traversePostOrderIterative(BinaryTreeNode<E> root)
     */
    @Test
    public void testTraversePostOrderIterative() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: traversePostOrderRecursive(BinaryTreeNode<E> root)
     */
    @Test
    public void testTraversePostOrderRecursive() throws Exception {
        list = BinaryTreeUtil.traversePostOrderRecursive(root);
        actual = Arrays.toString(list.toArray(new String[list.size()]));
        assertEquals(expectedPostOrder, actual);
    }

    /**
     * Method: traverseInOrderIterative(BinaryTreeNode<E> root)
     */
    @Test
    public void testTraverseInOrderIterative() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: traverseInOrderRecursive(BinaryTreeNode<E> root)
     */
    @Test
    public void testTraverseInOrderRecursive() throws Exception {
        list = BinaryTreeUtil.traverseInOrderRecursive(root);
        actual = Arrays.toString(list.toArray(new String[list.size()]));
        assertEquals(expectedInOrder, actual);
    }

    /**
     * Method: traverseLevelOrder(BinaryTreeNode<E> root)
     */
    @Test
    public void testTraverseLevelOrder() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: createCompleteBinaryTreeFromArray(E[] arr)
     */
    @Test
    public void testCreateCompleteBinaryTreeFromArray() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: main(String[] args)
     */
    @Test
    public void testMain() throws Exception {
//TODO: Test goes here...
    }


}
