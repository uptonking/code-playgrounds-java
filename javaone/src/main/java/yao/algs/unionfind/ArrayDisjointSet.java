package yao.algs.unionfind;

/**
 * 数组实现的并查集
 * <p>
 * 在并查集中需要两个类型的参数：集合名字的类型和元素的类型。
 * 在许多情况下，可以用整数作为集合的名字。 如果集合中共有n个元素，可以用范围【1：n】以内的整数表示元素。
 * <p>
 * 实现并查集的一个简单方法是使用数组表示元素及其所属子集的关系。 用数组下标表示元素，用数组单元记录该元素所属的子集名字。
 * <p>
 * 在应用的问题中，需将n个不同的元素划分成一组不相交的集合。开始时，每个元素自成一格单元素集合，然后按一定顺序将属于同一组的元素的集合合并。
 * 如果元素类型不是整型，则可以先构造一个映射，将每个元素映射成一个整数。这种映射可以用散列表或其他方式实现。
 * <p>
 * Created by yaoo on 1/14/18
 */
@SuppressWarnings("unused")
public class ArrayDisjointSet implements DisjointSet {

    //存储
    public int[] s;

    //并查集中子集合个数
    public int count;

    public ArrayDisjointSet(int elementsNum) {
        this.count = elementsNum;
        this.s = new int[elementsNum];

        //初始化并查集,相当于新建了count个互不相交的集合
        for (int i = 0; i < count; i++) {
            //初始时每个元素代表一个集合，所属子集都用-1表示，s[i]存储的是高度(秩)信息
            s[i] = -1;
        }
    }

    /**
     * 按高度(秩)合并以root1和root2为代表的两个集合
     * <p>
     * 树变高会影响find的效率
     * 先判断下哪棵子树更高，让矮的子树的根指向高的子树的根
     *
     * @param root1 并查集中以root1为代表的某个子集
     * @param root2 并查集中以root2为代表的某个子集
     */
    @Override
    public void union(int root1, int root2) {

        //两集合已经连通了
        if (find(root1) == find(root2)) return;

        ///root2更高
        if (s[root1] > s[root2]) {
            s[root1] = root2;

        } else {

            ///高度相同
            if (s[root1] == s[root2]) {
                s[root1]--;
            }
            s[root2] = root1;
        }

        //uinon后子集个数减1
        count--;
    }

//    public void union(int root1, int root2) {
//        s[root2] = root1;//将root1作为root2的新树根
//    }

    @Override
    public int find(int x) {
        if (s[x] < 0) {
            return x;
        } else {

            //使用了路径压缩,让查找路径上的所有顶点都指向了树根(代表节点)
            s[x] = find(s[x]);
            return s[x];

            //没有使用 路径压缩
            //return find(s[x]);
        }
    }

    public void unionBySize(int root1, int root2){

        if(find(root1) == find(root2))
            return;//root1 与 root2已经连通了

        if(s[root2] < s[root1])//root2 is deeper
            s[root1] = root2;
        else{
            if(s[root1] == s[root2])//root1 and root2 is the same deeper
                s[root1]--;//将root1的高度加1
            s[root2] = root1;//将root2的根(指向)更新为root1
        }

        count--;//每union一次,子树数目减1
    }
}
