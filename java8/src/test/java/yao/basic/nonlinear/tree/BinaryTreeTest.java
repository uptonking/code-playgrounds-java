package yao.basic.nonlinear.tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * BinaryTree Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 28, 2017</pre>
 */
public class BinaryTreeTest {


    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: createBinaryTreeFromArray(T[] array, int start, int end)
     */
    @Test
    public void testCreateBinaryTreeFromArray() throws Exception {

        ///使用数组构建二叉树
        //             5
        //           /   \
        //          2     8
        //         / \    / \
        //        1   3  6   9
        //             \  \   \
        //              4   7   0

        Integer[] array01 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        BinaryTreeNode<Integer> rootNode = binaryTree.createBinaryTreeFromArray(array01, 0, array01.length - 1);

        binaryTree.levelOrderTraverse(rootNode);
        System.out.println();

        binaryTree.preOrderTraverse(rootNode);
        System.out.println();

        binaryTree.midOrderTraverse(rootNode);
        System.out.println();

        binaryTree.postOrderTraverse(rootNode);
        System.out.println();

        binaryTree.preOrderTraverse1(rootNode);
        System.out.println();

        binaryTree.preOrderTraverse2(rootNode);
        System.out.println();

        binaryTree.midOrderTraverse1(rootNode);
        System.out.println();

        binaryTree.postOrderTraverse1(rootNode);
        System.out.println();

    }


    /**
     * Method: levelOrderTraverse(BinaryTreeNode<T> rootNode)
     */
    @Test
    public void testLevelOrderTraverse() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: preOrderTraverse(SingleNode<T> rootNode)
     */
    @Test
    public void testPreOrderTraverse() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: midOrderTraverse(SingleNode<T> rootNode)
     */
    @Test
    public void testMidOrderTraverse() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: postOrderTraverse(SingleNode<T> rootNode)
     */
    @Test
    public void testPostOrderTraverse() throws Exception {
//TODO: Test goes here... 
    }


} 
