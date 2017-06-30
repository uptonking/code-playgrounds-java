package yao.basic.nonlinear.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 邻接矩阵实现的图
 */
public class MatrixGraph<T> {

    //顶点数组
    private T[] vertexArr;
    //顶点关系的邻接矩阵
    private int[][] adjMatrix;

    /**
     * 利用输入的顶点和边数组构建图
     * 顶点可以是字符串等实现了equals()方法的对象，边是长度为[elen][2]的二维数组
     *
     * @param vertexes
     * @param edges
     */
    public MatrixGraph(T[] vertexes, T[][] edges) {

        //获取输入的顶点数和边数
        int vlen = vertexes.length;
        int elen = edges.length;

        //初始化图的顶点
        vertexArr = (T[]) new Object[vlen];
        System.arraycopy(vertexes, 0, vertexArr, 0, vlen);

        //初始化图的边矩阵
        adjMatrix = new int[vlen][vlen];
        for (int i = 0; i < elen; i++) {
            int p1 = getIndex(edges[i][0]);
            int p2 = getIndex(edges[i][1]);

            adjMatrix[p1][p2] = 1;
        }
    }

    /**
     * 获取元素在顶点数组中的下标
     *
     * @param t
     * @return
     */
    public int getIndex(T t) {
        for (int i = 0; i < vertexArr.length; i++) {
            if (t.equals(vertexArr[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 邻接顶点是一条边上的两个顶点
     *
     * @param v
     * @return 返回顶点v的第一个邻接顶点的索引
     */
    public int firstVertex(int v) {
        if (v < 0 || v > (vertexArr.length - 1)) {
            return -1;
        }

        for (int i = 0; i < vertexArr.length; i++) {
            if (adjMatrix[v][i] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param v
     * @param w
     * @return 返回顶点v相对于w的下一个邻接顶点的索引
     */
    public int nextVertex(int v, int w) {
        if (v < 0 || v > (vertexArr.length - 1) || w < 0 || w > (vertexArr.length - 1)) {
            return -1;
        }
        for (int i = w + 1; i < vertexArr.length; i++) {
            if (adjMatrix[v][i] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 遍历一个顶点的所有邻接顶点
     *
     * @param i
     * @param visited
     */
    public void dfsVertex(int i, boolean[] visited) {
        visited[i] = true;
        System.out.printf("%s ", vertexArr[i]);
        ///遍历i的所有邻接顶点
        for (int w = firstVertex(i); w >= 0; w = nextVertex(i, w)) {
            if (!visited[w]) {
                dfsVertex(w, visited);
            }
        }
    }

    /**
     * 深度优先搜索图，递归
     */
    public void dfs() {

        //顶点访问标记数组
        boolean[] visited = new boolean[vertexArr.length];

//        ///初始化所有顶点未被访问
//        for (int i = 0; i < vertexArr.length; i++) {
//            visited[i] = false;
//        }

        ///从第一个顶点开始遍历其邻接顶点，邻接顶点的邻接顶点，直到所有顶点被访问
        for (int i = 0; i < vertexArr.length; i++) {
            if (!visited[i]) {
                dfsVertex(i, visited);
            }
        }

    }

    public void dfsNonRecursively() {

        //顶点访问标记数组
        boolean[] visited = new boolean[vertexArr.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < vertexArr.length; i++) {

            if (!visited[i]) {
                stack.add(i);

                visited[i] = true;

                while (!stack.isEmpty()) {
                    int j = stack.pop();

                    System.out.print(vertexArr[j] + " ");

                    ///从顶点数组的最后开始，将j的邻接顶点，邻接的邻接全部入栈
                    for (int k = lastVertex(j); k >= 0; k = lastVertex(j, k)) {

                        if (!visited[k]) {
                            stack.add(k);
                            visited[k] = true;
                        }

                    }

                }

            }
        }


    }

    /**
     * 获取与i邻接的下标最大的顶点
     *
     * @param i
     * @return
     */
    public int lastVertex(int i) {
        for (int j = vertexArr.length - 1; j >= 0; j--) {
            if (adjMatrix[i][j] == 1) {
                return j;
            }
        }
        return -1;
    }

    /**
     * @param i
     * @param j
     * @return 返回顶点i相对于j的上一个邻接顶点
     */
    public int lastVertex(int i, int j) {
        for (int k = j - 1; k >= 0; k--) {
            if (adjMatrix[i][k] == 1) {
                return k;
            }
        }
        return -1;
    }

    /**
     * 广度优先搜索，利用队列
     * 类似于树的层次遍历
     */
    public void bfs() {

        //顶点访问标记，默认初始化为false
        boolean[] visited = new boolean[vertexArr.length];

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < vertexArr.length; i++) {

            ///对于连通图，这里只打印第一个顶点
            if (!visited[i]) {
                queue.add(i);
                visited[i] = true;
                System.out.print(vertexArr[i] + " ");

                while (!queue.isEmpty()) {

                    int cur = queue.remove();

                    for (int j = firstVertex(cur); j >= 0; j = nextVertex(cur, j)) {

                        ///这里打印其他所有顶点
                        if (!visited[j]) {
                            queue.add(j);
                            visited[j] = true;
                            System.out.print(vertexArr[j] + " ");
                        }
                    }


                }

            }
        }

    }


    public void bfs1() {

        int head = 0;
        int rear = 0;

        //辅助队列
        int[] queue = new int[vertexArr.length];
        boolean[] visited = new boolean[vertexArr.length];

        for (int i = 0; i < vertexArr.length; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < vertexArr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                System.out.printf("%s ", vertexArr[i]);
                queue[rear] = i;
                rear++;
            }

            while (head != rear) {
                int j = queue[head];
                head++;
                for (int k = firstVertex(j); k >= 0; k = nextVertex(j, k)) { //k是为访问的邻接顶点
                    if (!visited[k]) {
                        visited[k] = true;
                        System.out.printf("%s ", vertexArr[k]);
                        queue[rear++] = k;
                    }

                }
            }
        }
        System.out.println();

    }

    public void display() {
        for (int i = 0; i < vertexArr.length; i++) {
            for (int j = 0; j < vertexArr.length; j++) {
                System.out.printf("%d", adjMatrix[i][j]);
            }
            System.out.println();
        }
    }

}
