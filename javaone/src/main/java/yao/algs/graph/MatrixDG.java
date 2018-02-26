package yao.algs.graph;

import yao.algs.list.TwoWayList;
import yao.algs.queue.LinkedQueue;
import yao.algs.stack.LinkedStack;

import java.util.Arrays;

/**
 * 邻接矩阵实现的有向图
 * <p>
 * Created by yaoo on 1/14/18
 */
@SuppressWarnings("unused")
public class MatrixDG<T> implements Graph {

    private int vlen;
    //所有的顶点数据，元素类型为String
    private T[] mVertex;
    //邻接矩阵存边，1表示有边，0表示无边
    private int[][] mMatrix;

    private int visited[];

    /**
     * 直接输入顶点数组和邻接矩阵初始化图
     *
     * @param mVertex 顶点数组
     * @param mMatrix 邻接矩阵
     */
    public MatrixDG(T[] mVertex, int[][] mMatrix) {
        if (mVertex.length != mMatrix.length) throw new IllegalArgumentException("图的顶点数量和邻接矩阵长度必须相同");
        this.mVertex = mVertex;
        this.vlen = mVertex.length;
        this.mMatrix = mMatrix;
        this.visited = new int[vlen];
    }

    public MatrixDG(T[] mVertex) {
        this.mVertex = mVertex;
        this.vlen = mVertex.length;
        this.mMatrix = new int[vlen][vlen];
        this.visited = new int[vlen];
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
    public MatrixDG(T[] vex, T[][] edge) {
        this.vlen = vex.length;
        int elen = edge.length;

        this.mVertex = vex;
//        mVertex = new String[vlen];
//        System.arraycopy(vex, 0, mVertex, 0, vlen);
        this.visited = new int[vlen];

        mMatrix = new int[vlen][vlen];
        for (int i = 0; i < elen; i++) {
            int p1 = getPosition(edge[i][0]);
            int p2 = getPosition(edge[i][1]);
            mMatrix[p1][p2] = 1;
        }

    }


    public boolean addEdge(int i, int j) {
        checkVertexRange(i);
        checkVertexRange(j);

        mMatrix[i][j] = 1;
        return true;
    }

    public boolean removeEdge(int i, int j) {
        checkVertexRange(i);
        checkVertexRange(j);

        mMatrix[i][j] = 0;
        return false;
    }

    public boolean isEdge(int i, int j) {
        checkVertexRange(i);
        checkVertexRange(j);

        if (mMatrix[i][j] != 0) {
            return true;
        }
        return false;
    }


    /**
     * 拓扑排序
     *
     * @return 排序后的顶点元素值，不是下标
     */
    public T[] topologicalSort() {
        TwoWayList<Integer> sortedVex = new TwoWayList<>();

        //计算所有顶点的入度
        int[] inDegree = getInDegree();
        //用于存放入度为0的顶点的栈
        LinkedStack<Integer> stack = new LinkedStack<>();
        ///所有入度为0的顶点入栈
        for (int i = 0; i < vlen; i++) {
            if (inDegree[i] == 0) {
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            int v = stack.pop();
            //记录该入度为0的点的下标
            sortedVex.addLast(v);

            for (int i = 0; i < vlen; i++) {
                ///顶点v是顶点i的前驱顶点，且i除v外再无前驱顶点
                if (mMatrix[v][i] != 0 && (--inDegree[i] == 0)) {
                    stack.push(i);
                }
            }
        }


        T[] vertexAll = (T[]) new Object[vlen];
        for (int i = 0; i < vlen; i++) {
            vertexAll[i] = mVertex[sortedVex.get(i)];
        }

        return vertexAll;
    }

    /**
     * 基于深度优先实现拓扑排序
     */
    public void topologicalSortDFS() {

        Arrays.fill(visited, 0);
        LinkedStack<Integer> stack = new LinkedStack<>();

        for (int i = 0; i < vlen; i++) {
            if (!hasVisited(i)) {
                dfsRecursive4Topo(i, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(mVertex[stack.pop()] + "\t");
        }

    }

    public void dfsRecursive4Topo(int i, LinkedStack stack4return) {

        visit(i);
        //System.out.print(mVertex[i] + "\t");

        for (int j = 0; j < vlen; j++) {
            //j是i的邻接点，且j没被访问过
            if (mMatrix[i][j] != 0 && !hasVisited(j)) {
                dfsRecursive4Topo(j, stack4return);
            }
        }
        stack4return.push(i);
    }


    @Override
    public Object[] dfs(int i) {
        TwoWayList<Integer> visitedList = new TwoWayList<>();

        LinkedStack<Integer> stack = new LinkedStack<>();

        stack.push(i);

        while (!stack.isEmpty()) {
            int v = stack.pop();
            visit(v);

//            System.out.print(mVertex[v] + "\t");
            visitedList.add(v);

            for (int j = 0; j < vlen; j++) {
                if (mMatrix[v][j] != 0 && !hasVisited(j) && !stack.contains(j)) {
//                if (mMatrix[v][j] != 0 && !hasVisited(j)) {
                    stack.push(j);
                }
            }
        }

        return visitedList.toArray(new Object[visitedList.size()]);
    }

    public void dfsRecursive(int i) {

        visit(i);
        System.out.print(mVertex[i] + "\t");

        for (int j = 0; j < vlen; j++) {
            //j是i的邻接点，且j没被访问过
            if (mMatrix[i][j] != 0 && !hasVisited(j)) {
                dfsRecursive(j);
            }
        }
    }

    @Override
    public Object[] bfs(int i) {
        TwoWayList<Integer> visitedList = new TwoWayList<>();
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        queue.offer(i);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            visit(v);

//            System.out.print(mVertex[v] + "\t");
            visitedList.add(v);

            for (int j = 0; j < vlen; j++) {
                if (mMatrix[v][j] != 0 && !hasVisited(j) && !queue.contains(j)) {
                    queue.offer(j);
                }
            }
        }

        return visitedList.toArray(new Object[visitedList.size()]);
    }


    public void visit(int i) {
        visited[i] = 1;
    }

    public boolean hasVisited(int i) {
        return visited[i] == 1;
    }

    /**
     * 计算所有顶点的入度
     *
     * @return 入度数组
     */
    public int[] getInDegree() {

        int[] inDegree = new int[vlen];

        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                if (mMatrix[j][i] != 0) {
                    inDegree[i]++;
                }
            }
        }
        return inDegree;
    }

    /**
     * 打印矩阵队列图
     */
    public void printGraph() {
//        System.out.printf("Martix Graph:\n");
        for (int i = 0; i < mVertex.length; i++) {
            for (int j = 0; j < mVertex.length; j++) {
                System.out.printf("%d ", mMatrix[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 查找元素在顶点数组中的索引位置
     *
     * @param str 要查找的值
     * @return 在顶点数组中的索引位置
     */
    private int getPosition(T str) {
        for (int i = 0; i < mVertex.length; i++) {
            if (mVertex[i].equals(str)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 检查索引在顶点数范围内
     *
     * @param index 输入索引
     */
    private void checkVertexRange(int index) {
        if (index < 0 || index >= vlen)
            throw new IllegalArgumentException(index + " 顶点的位置必须在[0,vlen-1]的闭区间");
    }
}
