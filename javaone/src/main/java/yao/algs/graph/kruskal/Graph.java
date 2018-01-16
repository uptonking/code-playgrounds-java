package yao.algs.graph.kruskal;

import yao.algs.list.TwoWayList;

/**
 * Kruskal算法计算最小生成树
 * <p>
 * 将n个顶点看成n个孤立的连通分量，按权值大小加边，直到图连通，即顶点全包含
 * <p>
 * 使用链表实现的并查集来判断是否构成环，同一集合中的元素相连会构成环
 * <p>
 * 当下一个权值最小的边有多条时，如何选取？？？
 * <p>
 * 此图未保存顶点数据，计算最小生成树的重点是边的权值，只需顶点下标
 * <p>
 * Created by yaoo on 1/15/18
 */
@SuppressWarnings("unused")
public class Graph {

    private int vlen;
    private int elen;
    //所有邻接表的头节点
    private TwoWayList<Edge>[] edgeLinks;
    //已加入树中的边
    private TwoWayList<Edge> TE;

    private final int MAX_WEIGHT = Integer.MAX_VALUE;


    @SuppressWarnings("unchecked")
    public Graph(int vlen) {
        this.vlen = vlen;
        this.elen = 0;
        this.edgeLinks = new TwoWayList[vlen];
        for (int i = 0; i < vlen; i++) {
            edgeLinks[i] = new TwoWayList<>();
        }
    }

    /**
     * 带权值的边 类
     */
    class Edge {
        int v1;
        int v2;
        int weight;

        public Edge(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        public Edge(int weight) {
            this(-1, -1, weight);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (this.getClass() != obj.getClass()) return false;
            Edge edge = (Edge) obj;
            return this.v1 == edge.v1 && this.v2 == edge.v2 && this.weight == edge.weight;
        }

        @Override
        public String toString() {
            return "Edge{" + "v1=" + v1 + ", v2=" + v2 + ", weight=" + weight + '}';
        }
    }

    public void addEdge(Edge edge) {
        edgeLinks[edge.v1].add(edge);
        edgeLinks[edge.v2].add(new Edge(edge.v2, edge.v1, edge.weight));
        elen++;
    }

    public void addEdge(int v1, int v2, int weight) {
        Edge edge = new Edge(v1, v2, weight);
        addEdge(edge);
    }


    public void removeEdge(Edge edge) {
        edgeLinks[edge.v1].remove(edge);
        edgeLinks[edge.v2].remove(new Edge(edge.v2, edge.v1, edge.weight));
        elen--;
    }

    @SuppressWarnings("unchecked")
    public Integer kruskalMST() {
        TE = new TwoWayList<>();

        //用来区分是否成环的数组
        TwoWayList<Integer>[] kindLists = (TwoWayList<Integer>[]) new TwoWayList[vlen];

        for (int i = 0; i < vlen; i++) {
            kindLists[i] = new TwoWayList<>();
            kindLists[i].addLast(i);
        }

        while (elen > 0 && TE.size() != vlen - 1) {

            Edge minEdge = getMinEdge();
            removeEdge(minEdge);

            ///判断下标v1、v2是否是集合代表，若是则取出代表
            int containsV1 = -1;
            int containsV2 = -1;
            for (int i = 0; i < vlen; i++) {
                TwoWayList<Integer> list = kindLists[i];

                if (list.contains(minEdge.v1)) {
                    containsV1 = i;
                }
                if (list.contains(minEdge.v2)) {
                    containsV2 = i;
                }
            }

            ///判断不成环
            if (containsV1 != containsV2) {
                TE.addLast(minEdge);

                //合并代表
                while (!kindLists[containsV2].isEmpty()) {
                    kindLists[containsV1].add(kindLists[containsV2].removeLast());
                }
            }

        }

        ///边数为节点数-1，MST计算成功
        if (TE.size() == vlen - 1) {
            TwoWayList<Edge> list = (TwoWayList<Edge>) TE.clone();
            int weightSum = 0;
            while (!list.isEmpty()) {
                Edge edge = list.removeLast();
                weightSum = weightSum + edge.weight;
            }
            System.out.println("最小生成树总权重为：" + weightSum);
            return weightSum;
        } else {
            System.out.println("最小生成树不存在");
            return null;
        }

    }

    /**
     * 从生成树的所有顶点出发计算权重最小的边
     * <p>
     * 二重循环，外层树中点，内层邻接表
     */
    @SuppressWarnings("unchecked")
    public Edge getMinEdge() {

        Edge minEdge = new Edge(MAX_WEIGHT);

        TwoWayList<Integer> tv = new TwoWayList<>();
        for (int i = 0; i < vlen; i++) {
            tv.addLast(i);
        }
        ///复制图中所有顶点
        TwoWayList<Integer> vexAll = (TwoWayList<Integer>) tv.clone();

        while (!vexAll.isEmpty()) {
            int i = vexAll.removeLast();

            //取出第i的顶点的邻接表
            TwoWayList<Edge> list = (TwoWayList<Edge>) edgeLinks[i].clone();

            while (!list.isEmpty()) {
                Edge edge = list.removeLast();
                if (edge.weight < minEdge.weight) {
                    minEdge = edge;
                }
            }
        }

        if (minEdge.weight == MAX_WEIGHT) {
            return null;
        }

        return minEdge;
    }

    @SuppressWarnings("unchecked")
    public void print() {
        System.out.println("图的顶点有：" + vlen + " 个，边有：" + elen + " 条");

        for (int i = 0; i < vlen; i++) {

            TwoWayList<Edge> stack = (TwoWayList<Edge>) edgeLinks[i].clone();
            while (!stack.isEmpty()) {

                Edge edge = stack.removeLast();
                System.out.print(edge.v2 + "[" + edge.weight + "]" + "\t");
            }
            System.out.println();
        }
    }


}
