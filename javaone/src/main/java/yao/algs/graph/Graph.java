package yao.algs.graph;

/**
 * 图的接口
 * <p>
 * 深度优先和广度优先是不唯一的，可以有多个
 * 一般情况都是给邻接表或者邻接矩阵求深度优先和广度优先，此时，深度优先和广度优先都是唯一的了
 * 因为当你的存储结构固定的时候，深度优先和广度优先也随之被固定了
 * Created by yaoo on 1/14/18
 */
public interface Graph {


//    void initialize(int v,int e);
//    void createGraph(String fileName);
//    void print();
//    int V();
//    int E();
//    int degree(int v);
//    int maxDegree();
//    float weight(int v1,int v2);
//    boolean isAdjacent(int v1,int v2);
//    float shortestPath(int s,int t);

    <T> T[] dfs(int i);

    <T> T[] bfs(int i);

}
