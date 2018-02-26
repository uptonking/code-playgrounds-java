package yao.algs.graph;

import yao.algs.list.TwoWayList;

/**
 * 邻接表实现的图
 * <p>
 * 顶点元素用数组存储
 * 边关系用第三方链表存储
 * 这种方式不便于扩展到带权图
 * <p>
 * Created by yaoo on 1/14/18
 */
public class LinkedGraphList<T> implements Graph {

    //顶点数
    private final int vlen;
    //边数
    private int elen;
    //是否是有向图
    private boolean directed;
    //顶点数据，不推荐使用数组存储，不方便动态添加节点
    private T[] vertexAll;
    //各顶点的邻接表构成的数组
    private TwoWayList<Integer>[] adj;


    public LinkedGraphList(T[] vertexAll) {
        ///默认为有向图
        this(vertexAll, true);
    }

    public LinkedGraphList(T[] vertexAll, boolean directed) {
        this.vertexAll = vertexAll;
        this.vlen = vertexAll.length;
        this.elen = 0;
        this.directed = directed;

        this.adj = (TwoWayList<Integer>[]) new TwoWayList[vlen];
        for (int i = 0; i < vlen; i++) {
            adj[i] = new TwoWayList<>();
        }

    }

    public LinkedGraphList(int vlen) {
        ///默认为有向图
        this(vlen, true);
    }

    public LinkedGraphList(int vlen, boolean directed) {
        if (vlen < 0) throw new IllegalArgumentException("顶点数要大于0");

        this.vlen = vlen;
        this.elen = 0;
        this.directed = directed;

        this.adj = (TwoWayList<Integer>[]) new TwoWayList[vlen];
        for (int i = 0; i < vlen; i++) {
            adj[i] = new TwoWayList<>();
        }
    }

    /**
     * 将v索引位置顶点与w位置顶点连成边
     *
     * @param v 第一个位置索引
     * @param w 第二个位置索引
     */
    public void addEdge(int v, int w) {
        checkVertexRange(v);
        checkVertexRange(w);

        adj[v].add(w);

        if (v != w && !directed) {
            adj[w].add(v);
        }

        elen++;
    }

    public boolean hasEdge(int v, int w) {
        checkVertexRange(v);
        checkVertexRange(w);

        for (int i = 0; i < adj[v].size(); i++) {
            if (adj[v].get(i).equals(w)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 返回i索引位置的度，即相邻节点的个数
     *
     * @param i 索引位置
     * @return 度
     */
    public int degree(int i) {
        checkVertexRange(i);
        return adj[i].size();
    }

    /**
     * 返回i索引位置的邻接表头指针
     *
     * @param i 索引位置
     * @return 邻接表头指针
     */
    public TwoWayList<Integer> getAdj(int i) {
        return adj[i];
    }

    @SuppressWarnings("unchecked")
    public Integer[] toArray(Integer[] t) {

//        Integer[] result = t;
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
//                result[j]=adj[i].get(j);
                System.out.print(adj[i].get(j) + "\t");
            }
            System.out.println();
        }

        return null;
    }

    /**
     * 检查索引在顶点数范围内
     *
     * @param index 输入索引
     */
    private void checkVertexRange(int index) {
        if (index < 0 || index >= vlen)
            throw new IllegalArgumentException(index + " 插入的位置必须在[0,vlen-1]的闭区间");
    }

    @Override
    public Object[] dfs(int i) {
        return new Object[0];
    }

    @Override
    public Object[] bfs(int i) {
        return new Object[0];
    }
}



