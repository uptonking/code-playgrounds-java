package yao.basic.nonlinear.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 图的顶点
 */
public class GraphNode<T> {

    T data;
    List<GraphNode<T>> neighborList;
    boolean visited;

    public GraphNode(T data) {
        this.data = data;
        this.neighborList = new ArrayList<>();
        this.visited = false;
    }

    public boolean equals(GraphNode<T> node) {
        return this.data.equals(node.data);
    }

    /**
     * 设置图中所有节点未访问
     * @param node
     */
    public void setUnvisited(GraphNode<T> node) {

        if (node.visited) {
            node.visited = false;
        }

        List<GraphNode<T>> neighbors = node.neighborList;
        for (int i = 0; i < neighbors.size(); i++) {
            setUnvisited(neighbors.get(i));
        }

    }

    public void setUnvisited() {
        setUnvisited(this);
    }

}
