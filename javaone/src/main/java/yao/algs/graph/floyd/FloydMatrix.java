package yao.algs.graph.floyd;

import yao.algs.list.TwoWayList;

/**
 * Floyd-Warshall算法求解任意两点间的最短路径
 * <p>
 * 暴力算法
 * 未保存路径轨迹
 * <p>
 * Created by yaoo on 1/17/18
 */
public class FloydMatrix {

    //图中顶点数
    private int vlen;
    //权值矩阵(即距离矩阵)
    private int[][] dist;
    private final int MAX = Integer.MAX_VALUE;

    public FloydMatrix(int vlen) {
        this.vlen = vlen;
        this.dist = new int[vlen][vlen];
    }

    public FloydMatrix(int[][] matrix) {
        this.vlen = matrix.length;
        this.dist = matrix;
    }

    public void addEdge(int v, int w, int weight) {
        dist[v][w] = weight;
    }

    /**
     * 求解所有最短路径
     */
    public void floydShortestPath() {

        for (int k = 0; k < vlen; k++) {
            for (int i = 0; i < vlen; i++) {
                for (int j = 0; j < vlen; j++) {
                    if (dist[i][k] != MAX &&
                            dist[k][j] != MAX &&
                            dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }

            }
        }
    }

    public void printShortestPath() {
        System.out.println("各顶点到各顶点最短路径长度构成的矩阵为：");
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                System.out.print(dist[i][j] + "\t");

            }
            System.out.println();
        }
    }

}
