package yao.algs.graph.dijkstra;

import yao.algs.list.TwoWayList;

import java.util.Arrays;

/**
 * Dijkstra算法实现的单源最短路径
 * <p>
 * 适用于有向图，权值不能为负，适用于有环图
 * 与顶点数据内容无关，只需顶点数组下标
 * <p>
 * Created by yaoo on 1/16/18
 */
public class Graph {

    private int vlen;
    private int elen;
    //所有邻接表的头节点
    private TwoWayList<Edge>[] edgeLinks;
    private int[] distance;
    private int[] prev;
    //已求出最短路径的的顶点集合
    private TwoWayList<Integer> S;
    //未求出最短路径的的顶点集合
    private TwoWayList<Integer> U;

    //无穷大
    public static final int INFINITY_MAX = Integer.MAX_VALUE;
    //不存在
    public static final int NA = -1;

    @SuppressWarnings("unchecked")
    public Graph(int vlen) {
        this.vlen = vlen;
        this.elen = 0;
        this.edgeLinks = new TwoWayList[vlen];
        for (int i = 0; i < vlen; i++) {
            edgeLinks[i] = new TwoWayList<>();
        }

        this.distance = new int[vlen];
        this.prev = new int[vlen];

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
        elen++;
    }

    public void addEdge(int v1, int v2, int weight) {
        Edge edge = new Edge(v1, v2, weight);
        addEdge(edge);
    }

    /**
     * 计算从起始顶点start到其余各顶点的最短路径
     *
     * @param start 起始顶点位置下标
     */
    public void dijkstraShortestPath(int start) {
        initStartNode(start);

        S = new TwoWayList<>();
        U = new TwoWayList<>();
        for (int i = 0; i < vlen; i++) {
            U.add(i);
        }

        while (!U.isEmpty()) {
            int uMin = getMinDsitance(U);
            S.add(uMin);
            TwoWayList<Edge> list = (TwoWayList<Edge>) edgeLinks[uMin].clone();
            while (!list.isEmpty()) {
                Edge edge = list.removeLast();

                relaxEdge(edge);
            }
        }


    }


    /**
     * 根据起始顶点初始化资源
     *
     * @param start 起始顶点
     */
    public void initStartNode(int start) {
        Arrays.fill(distance, INFINITY_MAX);
        Arrays.fill(prev, NA);
        distance[start] = 0;
    }

    /**
     * 从带选集中选出距离最小的边，并删除这条边
     *
     * @param u 未求出最短路径的的顶点集合
     * @return 最小距离
     */
    public int getMinDsitance(TwoWayList<Integer> u) {

        if (u.isEmpty()) {
            return NA;
        }
        int min = u.get(0);
        for (int i = 0; i < u.size(); i++) {
            int v = u.get(i);
            if (distance[v] < distance[min]) {
                min = v;
            }
        }

        u.remove(min);
        return min;
    }

    /**
     * 松弛某一顶点的邻接点
     *
     * @param edge 边
     */
    public void relaxEdge(Edge edge) {

        if (distance[edge.v2] > distance[edge.v1] + edge.weight) {
            distance[edge.v2] = distance[edge.v1] + edge.weight;
            prev[edge.v2] = edge.v1;
        }

    }

    public void printShortestPath() {
        System.out.println("终点" + "\t" + "最短路径" + "\t" + "路线");

        TwoWayList<Integer>[] routes = (TwoWayList<Integer>[]) new TwoWayList[vlen];
        for (int i = 0; i < vlen; i++) {
            routes[i] = new TwoWayList<>();
            int j = i;
            while (j != NA) {
                routes[i].addLast(i);
                j = prev[j];
            }

            System.out.print(i + "\t" + distance[i] + "\t");

            while (!routes[i].isEmpty()) {
                int c = routes[i].removeLast();
                System.out.print(" --> " + c);
            }
            System.out.println();
        }
    }

    @SuppressWarnings("unchecked")
    public void printGraph() {
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
