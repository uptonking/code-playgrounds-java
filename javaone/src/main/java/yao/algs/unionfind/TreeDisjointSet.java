package yao.algs.unionfind;

/**
 * 树实现的并查集
 * Created by yaoo on 1/14/18
 */
public class TreeDisjointSet implements DisjointSet {

    private static class Node {
        int parent;
        boolean root;

        private Node() {
            parent = 1;
            root = true;
        }
    }

    Node[] node;

    public TreeDisjointSet(int n) {
        node = new Node[n + 1];
        for (int e = 0; e <= n; e++)
            node[e] = new Node();
    }

    @Override
    public int find(int e) {
        while (!node[e].root) e = node[e].parent;
        return e;
    }


    //root1,B表示已经存在的类标记
    @Override
    public void union(int root1, int root2) {
        node[root1].parent += node[root2].parent;
        node[root2].root = false;
        node[root2].parent = root1;
    }


}
