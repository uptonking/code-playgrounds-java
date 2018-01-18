package yao.algs.unionfind;


/**
 * 链表实现的并查集
 * <p>
 * Created by yaoo on 1/14/18
 */
@SuppressWarnings("unused")
public class LinkedDisjointSet implements DisjointSet {

    /**
     * 链表并查集的节点类型
     *
     * @author Sking
     */
    protected class Node {

        // node[e].equivClass既是find(e)返回的值，又是指向等价类node[e].equivClass的链中的第一个结点的指针。
        int size;//类的节点个数
        //node[e].size只有当e是链上的第一个结点时才被定义。表示一个类中的结点个数。
        int equivClass;//类别标记
        int next;

        /**
         * 指定类别和元素个数的构造函数
         *
         * @param theClass 类别
         * @param theSize  元素个数
         */
        Node(int theClass, int theSize) {
            equivClass = theClass;
            size = theSize;
        }
    }

    //节点数组
    private Node[] node;
    //并查集大小
    private int n;

    /**
     * 初始化并查集
     *
     * @param numberOfElements 并查集容量
     */
    public void initialize(int numberOfElements) {
        n = numberOfElements;
        node = new Node[n + 1];
        //初始化，单独成类，类的元素个数均为1
        for (int e = 1; e <= n; e++)
            node[e] = new Node(e, 1);
    }

    /**
     * 合并两个指定”类“
     *
     * @param root1 ”类1“
     * @param root2 ”类2“
     */
    @Override
    public void union(int root1, int root2) {
        //总是将具有较少元素的类链接到较多元素类对应的链中
        if (node[root1].size > node[root2].size) {
            int t = root1;
            root1 = root2;
            root2 = t;
        }
        int k;
        for (k = root1; node[k].next != 0; k = node[k].next)
            node[k].equivClass = root2;
        node[k].equivClass = root2;
        node[root2].size += node[root1].size;
        node[k].next = node[root2].next;
        node[root2].next = root1;
    }

    /**
     * 查找指定元素所属的类
     *
     * @param x 指定元素
     * @return 指定元素所属的类
     */
    @Override
    public int find(int x) {
        return node[x].equivClass;
    }

}
