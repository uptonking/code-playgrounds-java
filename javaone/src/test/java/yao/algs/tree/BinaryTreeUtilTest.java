package yao.algs.tree;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import yao.algs.array.ResizableArray;
import yao.algs.queue.ArrayQueue;

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

    private static String expectedPreOrder;
    private static String expectedPostOrder;
    private static String expectedInOrder;
    private static String expectedLevelOrder;

    private BinaryTreeUtil binaryTreeUtil;
    private BinaryTreeNode<String> root;

    private ResizableArray<String> list;
    private String actual;

    private BinaryTreeNode<String> D;
    private BinaryTreeNode<String> H;
    private BinaryTreeNode<String> I;
    private BinaryTreeNode<String> J;
    private BinaryTreeNode<String> P;
    private BinaryTreeNode<String> G;
    private BinaryTreeNode<String> F;
    private BinaryTreeNode<String> E;
    private BinaryTreeNode<String> B;
    private BinaryTreeNode<String> C;
    private BinaryTreeNode<String> A;


    @BeforeClass
    public static void initBeforeClass() {
        expectedPreOrder = "[A, B, D, E, H, I, C, F, J, G, P]";
        expectedPostOrder = "[D, H, I, E, B, J, F, P, G, C, A]";
        expectedInOrder = "[D, B, H, E, I, A, F, J, C, P, G]";
        expectedLevelOrder = "[A, B, C, D, E, F, G, H, I, J, P]";
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

        D = new BinaryTreeNode<>("D", null, null);
        H = new BinaryTreeNode<>("H", null, null);
        I = new BinaryTreeNode<>("I", null, null);
        J = new BinaryTreeNode<>("J", null, null);
        P = new BinaryTreeNode<>("P", null, null);
        G = new BinaryTreeNode<>("G", P, null);
        F = new BinaryTreeNode<>("F", null, J);
        E = new BinaryTreeNode<>("E", H, I);
        B = new BinaryTreeNode<>("B", D, E);
        C = new BinaryTreeNode<>("C", F, G);
        A = new BinaryTreeNode<>("A", B, C);

        root = A;
        actual = "";
        list = null;

        binaryTreeUtil = new BinaryTreeUtil();
    }

    @After
    public void after() throws Exception {
//        actual = "";
//        list = null;
    }

    /**
     * Method: traversePreOrderRecursive(BinaryTreeNode<E> root)
     */
    @Test
    public void testTraversePreOrderRecursive() throws Exception {
        list = binaryTreeUtil.traversePreOrderRecursive(root);
        actual = Arrays.toString(list.toArray(new String[list.size()]));
        assertEquals(expectedPreOrder, actual);
    }

    /**
     * Method: traverseInOrderRecursive(BinaryTreeNode<E> root)
     */
    @Test
    public void testTraverseInOrderRecursive() throws Exception {
        list = binaryTreeUtil.traverseInOrderRecursive(root);
        actual = Arrays.toString(list.toArray(new String[list.size()]));
        assertEquals(expectedInOrder, actual);
    }

    /**
     * Method: traversePostOrderRecursive(BinaryTreeNode<E> root)
     */
    @Test
    public void testTraversePostOrderRecursive() throws Exception {
        list = binaryTreeUtil.traversePostOrderRecursive(root);
        actual = Arrays.toString(list.toArray(new String[list.size()]));
        assertEquals(expectedPostOrder, actual);
    }


    /**
     * Method: traversePreOrderIterative(BinaryTreeNode<E> root)
     */
    @Test
    public void testTraversePreOrderIterative() throws Exception {
        list = binaryTreeUtil.traversePreOrderIterative(root);
        actual = Arrays.toString(list.toArray(new String[list.size()]));
        assertEquals(expectedPreOrder, actual);
    }

    /**
     * Method: traversePreOrderDFSIterative(BinaryTreeNode<E> root)
     */
    @Test
    public void testTraversePreOrderDFSIterative() throws Exception {
        list = binaryTreeUtil.traversePreOrderDFSIterative(root);
        actual = Arrays.toString(list.toArray(new String[list.size()]));
        assertEquals(expectedPreOrder, actual);
    }

    /**
     * Method: traverseInOrderIterative(BinaryTreeNode<E> root)
     */
    @Test
    public void testTraverseInOrderIterative() throws Exception {
        list = binaryTreeUtil.traverseInOrderIterative(root);
        actual = Arrays.toString(list.toArray(new String[list.size()]));
        assertEquals(expectedInOrder, actual);
    }

    /**
     * Method: traversePostOrderIterative(BinaryTreeNode<E> root)
     */
    @Test
    public void testTraversePostOrderIterative() throws Exception {
        list = binaryTreeUtil.traversePostOrderIterative(root);
        actual = Arrays.toString(list.toArray(new String[list.size()]));
        assertEquals(expectedPostOrder, actual);
    }


    /**
     * Method: traverseLevelOrder(BinaryTreeNode<E> root)
     */
    @Test
    public void testTraverseLevelOrder() throws Exception {
        list = binaryTreeUtil.traverseLevelOrder(root);
        actual = Arrays.toString(list.toArray(new String[list.size()]));
        assertEquals(expectedLevelOrder, actual);
    }

    /**
     * Method: createCompleteBinaryTreeFromArray(E[] arr)
     */
    @Test
    public void testCreateCompleteBinaryTreeFromArray() throws Exception {
        String[] arr = {"aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "ii", "jj"};
        BinaryTreeNode root = binaryTreeUtil.createCompleteBinaryTreeFromArray(arr);
//        list = binaryTreeUtil.traverseLevelOrder(root);
        list = binaryTreeUtil.traversePreOrderIterative(root);
        actual = Arrays.toString(list.toArray(new String[list.size()]));
        System.out.println(actual);
    }

    @Test
    public void testCalMaxNotLeaf() {
//        assertEquals(0, binaryTreeUtil.calMaxNotLeaf(1));
        assertEquals(0, binaryTreeUtil.calMaxNotLeaf(1));
        assertEquals(0, binaryTreeUtil.calMaxNotLeaf(2));
        assertEquals(0, binaryTreeUtil.calMaxNotLeaf(3));
        assertEquals(2, binaryTreeUtil.calMaxNotLeaf(4));
        assertEquals(2, binaryTreeUtil.calMaxNotLeaf(6));
        assertEquals(2, binaryTreeUtil.calMaxNotLeaf(7));
        assertEquals(6, binaryTreeUtil.calMaxNotLeaf(8));
        assertEquals(6, binaryTreeUtil.calMaxNotLeaf(15));
    }

}
