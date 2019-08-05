package yao.algs.unionfind;

/**
 * 并查集接口
 * <p>
 * 并查集的数学模型是一组不相交的动态集合的集合S={A,B,C,...}，每个集合用一个代表来标识
 * <p>
 * 应用场景：判断无向图中任何两个顶点是否连通
 * <p>
 * 并查集问题和路径问题的区别:并查集比路径能做的操作少，它只能回答两个节点是否连通
 * 路径还可以找到类似最短的连通点等等.但正因为并查集专注于连接问题,所以判断是否连接
 * 修改连接状态时比较高效.
 * Created by yaoo on 1/13/18
 */
public interface DisjointSet {

    /**
     * 将集合1和2合并，其结果取名为A或B
     *
     * @param root1 集合1的代表
     * @param root2 集合2的代表
     */
    void union(int root1, int root2);

    /**
     * 查找元素x所属集合的代表元
     *
     * @param x 待查找的元素
     * @return 集合代表
     */
    int find(int x);
}
