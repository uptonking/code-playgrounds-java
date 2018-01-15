package yao.basic.nonlinear.graph;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 邻接表节点
 */
class ListNode {
    //顶点元素在数组的下标
    int vex;
    //指向下一个邻接点
    ListNode nextNode;
}


/**
 * 顶点类
 *
 * @param <T> 顶点数据元素类型
 */
class VertexNode<T> {
    //顶点数据
    T data;
    //该顶点邻接的第一点
    ListNode firstNode;

}


/**
 * 邻接表实现的图
 * 每个顶点都包含一条链表
 */
public class ListGraph<T> {

    //顶点数组
    private VertexNode<T>[] vertexArr;

    public ListGraph(T[] vertexes, T[][] edges) {

        int vlen = vertexes.length;
        int elen = edges.length;

        //初始化顶点
//        vertexArr = (VertexNode<T>[]) new Object[vlen];
        vertexArr = new VertexNode[vlen];

        for (int i = 0; i < vlen; i++) {
            vertexArr[i] = new VertexNode<>();
            vertexArr[i].data = vertexes[i];
            vertexArr[i].firstNode = null;
        }


        for (int i = 0; i < elen; i++) {

            int from = getIndex(edges[i][0]);
            int to = getIndex(edges[i][1]);

            //用尾顶点创建node
            ListNode node = new ListNode();
            node.vex = to;

            //将尾顶点节点加入头顶点的邻接表的最后
            if (vertexArr[from].firstNode == null) {
                vertexArr[from].firstNode = node;
            } else {
                addToListTail(vertexArr[from].firstNode, node);
            }

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
            if (t.equals(vertexArr[i].data)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 将node插入到list的最后
     *
     * @param list
     * @param node
     */
    public void addToListTail(ListNode list, ListNode node) {
        ListNode currentNode = list;
        while (currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
        }
        currentNode.nextNode = node;
    }

    /**
     * 深度优先搜索，递归
     */
    public void dfs() {

        boolean[] visited = new boolean[vertexArr.length];

        for (int i = 0; i < vertexArr.length; i++) {
            if (!visited[i]) {
                dfsVertex(i, visited);
            }
        }

        System.out.println();
    }

    /**
     * 遍历邻接，邻接的邻接，直到某个邻接的边都遍历完
     *
     * @param i
     * @param visited
     */
    public void dfsVertex(int i, boolean[] visited) {

        visited[i] = true;
        System.out.print(vertexArr[i].data + " ");

        ListNode headNode = vertexArr[i].firstNode;
        ListNode currentNode = headNode;
        while (currentNode != null) {
            if (!visited[currentNode.vex]) {
                dfsVertex(currentNode.vex, visited);
            }
            currentNode = currentNode.nextNode;
        }
    }

    /**
     * 深度优先搜索，利用栈
     */
    public void dfsNonRecursively() {

        boolean[] visited = new boolean[vertexArr.length];

        for (int i = 0; i < vertexArr.length; i++) {

            if (!visited[i]) {

                Stack<VertexNode<T>> stack = new Stack<>();
                visited[i] = true;
                System.out.println(vertexArr[i].data + " ");

                stack.push(vertexArr[i]);


                while (!stack.isEmpty()) {

                    VertexNode<T> currentVertex = stack.peek();

                    int vex = getFirstUnvisitedVertex(currentVertex, visited);

                    if (vex != -1) {
                        visited[vex] = true;
                        System.out.println(vertexArr[vex].data + " ");

                        stack.push(vertexArr[vex]);

                    } else {
                        stack.pop();
                    }
                }
            }
        }
        System.out.println();
    }

    /**
     * 获取一顶点的第一个未被访问的邻接节点
     *
     * @param vertexNode
     * @param visited
     * @return
     */
    public int getFirstUnvisitedVertex(VertexNode<T> vertexNode, boolean[] visited) {

        if (vertexNode == null) {
            return -1;
        }
        ListNode node = vertexNode.firstNode;

        if (node == null) {
            return -1;
        }

        while (node != null) {
            if (!visited[node.vex]) {
                return node.vex;
            }
            node = node.nextNode;
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


        for (int i = 0; i < vertexArr.length; i++) {

            if (!visited[i]) {

                Queue<VertexNode<T>> queue = new LinkedList<>();
                queue.add(vertexArr[i]);

                while (!queue.isEmpty()) {

                    VertexNode<T> currentNode = queue.remove();
                    int index = getIndex(currentNode.data);
                    if (!visited[index]) {
                        visited[index] = true;
                        System.out.print(currentNode.data + " ");
                    }

                    ListNode node = currentNode.firstNode;
                    while (node != null) {
                        if (!visited[node.vex]) {
                            queue.add(vertexArr[node.vex]);
                        }
                        node = node.nextNode;
                    }

                }
            }
        }
        System.out.println();
    }


    public void display() {

        for (int i = 0; i < vertexArr.length; i++) {

            System.out.print(vertexArr[i].data + "  -->  ");

            ListNode headNode = vertexArr[i].firstNode;
            ListNode currentNode = headNode;

            while (currentNode != null) {
                System.out.print(vertexArr[currentNode.vex].data + " ");
                currentNode = currentNode.nextNode;
            }

            System.out.println();

        }
    }


}
