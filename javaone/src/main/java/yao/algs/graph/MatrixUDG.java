package yao.algs.graph;

/**
 * 邻接矩阵实现的无向图
 * <p>
 * 无向图的邻接矩阵和邻接表存储方式都存在数据冗余
 * <p>
 * Created by yaoo on 1/14/18
 */
@SuppressWarnings("unused")
public class MatrixUDG implements Graph {

    //所有的顶点数据，元素类型为String
    private String[] mVertex;
    //邻接矩阵存边，1表示有边，0表示无边
    private int[][] mMatrix;

    /**
     * 直接输入顶点数组和邻接矩阵初始化图
     *
     * @param mVertex 顶点数组
     * @param mMatrix 邻接矩阵
     */
    public MatrixUDG(String[] mVertex, int[][] mMatrix) {
        if (mVertex.length != mMatrix.length) {
            throw new RuntimeException("图的顶点数量和邻接矩阵长度必须相同");
        }
        this.mVertex = mVertex;
        this.mMatrix = mMatrix;
    }

    /**
     * 输入顶点数组和顶点对数组，逐步初始化邻接矩阵
     * <p>
     * 注意：由于需要计算元素在顶点数组中的索引位置，所以顶点数组元素不能重复
     * <p>
     * 适用范围太窄
     *
     * @param vex  顶点数组
     * @param edge 表示边的顶点对
     */
    public MatrixUDG(String[] vex, String[][] edge) {
        int vlen = vex.length;
        int elen = edge.length;

        this.mVertex = vex;
//        mVertex = new String[vlen];
//        System.arraycopy(vex, 0, mVertex, 0, vlen);

        mMatrix = new int[vlen][vlen];
        for (int i = 0; i < elen; i++) {
            int p1 = getPosition(edge[i][0]);
            int p2 = getPosition(edge[i][1]);
            mMatrix[p1][p2] = 1;
            mMatrix[p2][p1] = 1;
        }

    }


    /**
     * 打印矩阵队列图
     */
    public void print() {
//        System.out.printf("Martix Graph:\n");
        for (int i = 0; i < mVertex.length; i++) {
            for (int j = 0; j < mVertex.length; j++)
                System.out.printf("%d ", mMatrix[i][j]);
            System.out.println();
        }
    }

    public boolean addEdge(int i, int j) {
        if (i >= 0 && i < mVertex.length && j >= 0 && j < mVertex.length) {
            mMatrix[i][j] = 1;
            mMatrix[j][i] = 1;
            return true;
        }
        return false;
    }

    public boolean removeEdge(int i, int j) {
        if (i >= 0 && i < mVertex.length && j >= 0 && j < mVertex.length) {
            mMatrix[i][j] = 0;
            mMatrix[j][i] = 0;
            return true;
        }
        return false;
    }

    public boolean isEdge(int i, int j) {
        if (i >= 0 && i < mVertex.length && j >= 0 && j < mVertex.length) {
            if (mMatrix[i][j] == 1) {
                return true;
            }
        }
        return false;
    }


    /**
     * 查找元素在顶点数组中的索引位置
     *
     * @param str 要查找的值
     * @return 在顶点数组中的索引位置
     */
    private int getPosition(String str) {
        for (int i = 0; i < mVertex.length; i++) {
            if (mVertex[i].equals(str)) {
                return i;
            }
        }
        return -1;
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
