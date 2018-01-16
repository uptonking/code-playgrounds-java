package yao.algs.graph;

import yao.algs.list.TwoWayList;
import yao.algs.queue.LinkedQueue;
import yao.algs.stack.LinkedStack;

/**
 * 邻接表实现的图  顶点类+邻接点类
 * <p>
 * 顶点用数组存储
 * 顶点对象包含数据和头节点first
 * 边关系用EdgeNode实现，包含顶点索引和next
 * <p>
 * Created by yaoo on 1/15/18
 */
@SuppressWarnings("unused")
public class LinkedGraph<T> implements Graph {

    //顶点数
    private int vlen;
    //边数
    private int elen;
    //是否是有向图
    private boolean directed;
    //顶点数据，不推荐使用数组存储，不方便动态添加节点，可以使用map
    //private T[] vertexAll;
    private Vertex<T>[] vertexAll;

    @SuppressWarnings("unchecked")
    public LinkedGraph(int capacity) {
        if (capacity < 1) throw new IllegalArgumentException("顶点数组长度要大于0");
//        this.vlen = vlen;
        this.vertexAll = (Vertex<T>[]) new Vertex[capacity];
        this.directed = true;
    }

    public LinkedGraph(Vertex<T>[] vertexAll) {
        if (vertexAll == null || vertexAll.length < 1) throw new IllegalArgumentException("顶点数组不能为空");
        this.vertexAll = vertexAll;
        this.vlen = vertexAll.length;
        this.directed = true;
    }

    @SuppressWarnings("unchecked")
    public LinkedGraph(T[] dataAll) {
        this(dataAll, true);
    }

    @SuppressWarnings("unchecked")
    public LinkedGraph(T[] dataAll, boolean directed) {
        if (dataAll == null || dataAll.length < 1) throw new IllegalArgumentException("顶点数组不能为空");
        int len = dataAll.length;
        this.vertexAll = (Vertex<T>[]) new Vertex[len];
        for (int i = 0; i < len; i++) {
            vertexAll[i] = new Vertex<>(dataAll[i]);
        }
        this.vlen = len;
        this.directed = directed;
    }

    /**
     * 将索引为v和w的顶点设为邻接点，即一条边
     *
     * @param v 起点
     * @param w 终点
     */
    public void addEdge(int v, int w) {
        checkVertexRange(v);
        checkVertexRange(w);
        if (vertexAll[v] == null) throw new IllegalArgumentException(v + "索引位置的节点不存在");

        EdgeNode newNode = new EdgeNode(w);

        if (vertexAll[v].first == null) {
            vertexAll[v].first = newNode;
        } else {
            ///将新节点插入邻接表头部
            newNode.next = vertexAll[v].first;
            vertexAll[v].first = newNode;
        }

        if (!directed) {
            EdgeNode newNode2 = new EdgeNode(v);
            if (vertexAll[w].first == null) {
                vertexAll[w].first = newNode2;
            } else {
                ///将新节点插入邻接表头部
                newNode2.next = vertexAll[w].first;
                vertexAll[w].first = newNode2;
            }
        }

        elen++;
    }


    /**
     * 从第i个点开始深度优先遍历
     * <p>
     * 用栈实现
     *
     * @param i 顶点索引位置
     */
    @Override
    public Object[] dfs(int i) {
        checkVertexRange(i);
        TwoWayList list = new TwoWayList();

        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(i);

        EdgeNode curNode;
        while (!stack.isEmpty()) {

            int v = stack.pop();
            visit(v);
            //System.out.print(vertexAll[v].data + "  ");
            list.add(vertexAll[v].data);

            curNode = vertexAll[v].first;
            while (curNode != null) {
                if (!hasVisited(curNode.to) && !stack.contains(curNode.to)) {
                    stack.push(curNode.to);
                }
                curNode = curNode.next;
            }
        }

        return list.toArray(new Object[list.size()]);
    }

    /**
     * 深度优先遍历
     * 递归实现
     *
     * @param i 顶点索引位置
     */
    public void dfsRecursive(int i) {
        checkVertexRange(i);
        visit(i);
        System.out.print(vertexAll[i].data + "  ");

        EdgeNode curNode = vertexAll[i].first;
        while (curNode != null) {
            if (!hasVisited(curNode.to)) {
                dfsRecursive(curNode.to);
            }
            curNode = curNode.next;
        }
    }

    /**
     * 从第i个点开始广度优先遍历
     * <p>
     * 用队列实现
     *
     * @param i 顶点索引位置
     */
    @SuppressWarnings("unchecked")
    @Override
    public Object[] bfs(int i) {
        checkVertexRange(i);
        TwoWayList list = new TwoWayList();

        LinkedQueue<Integer> queue = new LinkedQueue<>();
        queue.offer(i);

        EdgeNode curNode;

        while (!queue.isEmpty()) {

            i = queue.poll();
            if (!hasVisited(i)) {
                if (vertexAll[i].data != null) {
                    list.add(vertexAll[i].data);
                }
                //System.out.print(vertexAll[i].data + "  ");
                //vertexAll[i].visited = true;
                visit(i);
            }

            curNode = vertexAll[i].first;
            while (curNode != null) {
                if (!hasVisited(curNode.to)) {
                    queue.offer(curNode.to);
                }
                curNode = curNode.next;
            }
        }

        return list.toArray(new Object[list.size()]);
    }

    private boolean hasVisited(int i) {
        return vertexAll[i].visited;
    }

    private void visit(int i) {
        vertexAll[i].visited = true;
    }

    /**
     * 判断两点是否相邻
     *
     * @param v 节点一索引位置
     * @param w 节点二索引位置
     * @return 是否是邻接点
     */
    public boolean hasEdge(int v, int w) {
        checkVertexRange(v);
        checkVertexRange(w);
        if (vertexAll[v] == null || vertexAll[w] == null)
            throw new IllegalArgumentException(v + "或" + w + "索引位置的节点不存在");

        EdgeNode curNode = vertexAll[v].first;
        while (curNode != null) {
            if (curNode.to == w) {
                return true;
            }
            curNode = curNode.next;
        }

        if (!directed) {
            curNode = vertexAll[w].first;
            while (curNode != null) {
                if (curNode.to == v) {
                    return true;
                }
                curNode = curNode.next;
            }
        }

        return false;
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

    /**
     * 返回i索引位置的度，即相邻节点的个数
     *
     * @param i 索引位置
     * @return 度
     */
    public int degree(int i) {
        checkVertexRange(i);
        EdgeNode curNode = vertexAll[i].first;
        int adjNum = 0;
        if (curNode == null) {
            return 0;
        }
        while (curNode != null) {
            adjNum++;
            curNode = curNode.next;
        }
        return adjNum;
    }

    /**
     * 返回i索引位置的邻接表头指针
     *
     * @param i 索引位置
     * @return 邻接表头指针
     */
    public EdgeNode getAdj(int i) {
        checkVertexRange(i);
        return vertexAll[i].first;
    }

    @SuppressWarnings("unchecked")
    public void print() {

        EdgeNode curNode;

        for (int i = 0; i < vlen; i++) {
            curNode = vertexAll[i].first;
            System.out.print("第" + (i + 1) + "个顶点是：" + vertexAll[i].data + "  -  ");
            while (curNode != null) {
                System.out.print(vertexAll[curNode.to].data + "\t");
                curNode = curNode.next;
            }
            System.out.println();
        }
    }


    /**
     * 向图中加入顶点
     * <p>
     * 只用使用容量大小初始化时LinkedGraph(int capacity)才能使用此方法逐步添加顶点
     * 直接用顶点数组初始化时LinkedGraph(Vertex<T>[] vertexAll)，不能用此方法添加顶点
     *
     * @param vex 新顶点
     */
    @Deprecated
    public void addVertex(Vertex<T> vex) {
        if (vex == null) throw new IllegalArgumentException("顶点数据不能为空");
        if (vlen == vertexAll.length) throw new RuntimeException("顶点数组已满");

        vertexAll[vlen++] = vex;
    }

    @Deprecated
    public void addVertex(T data) {
        if (data == null) throw new IllegalArgumentException("顶点数据不能为空");
        if (vlen == vertexAll.length) throw new RuntimeException("顶点数组已满");

        Vertex<T> v = new Vertex<>(data);
        v.first = null;

        addVertex(v);
    }


}


/**
 * 顶点
 */
class Vertex<T> {

    //顶点数据
    T data;
    //该顶点对应邻接表的头指针
    EdgeNode first;

    //是否已访问，遍历时有用
    boolean visited;

    public Vertex(T data) {
        this.data = data;
    }
}

/**
 * 边的另一顶点信息
 */
class EdgeNode {

    //相应顶点下标
    int to;
    //下一节点
    EdgeNode next;

    //还可以添加权值、额外信息
    //int weight;


    public EdgeNode(int to) {
        this.to = to;
    }

}
