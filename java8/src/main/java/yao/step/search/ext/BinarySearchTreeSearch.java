package yao.step.search.ext;

/**
 * 二叉排序树查找
 */
public class BinarySearchTreeSearch {

    public static int Max = 10;
    public static int[] Data = {15, 2, 13, 6, 17, 25, 37, 7, 3, 18}; // 数据数组
    public static int Counter = 1;

    public static void main(String args[]) {

        int i; // 循环计数变量

        BNTreeArray BNTree = new BNTreeArray(); // 声明二叉树数组

        BNTree.TreeData[0] = Data[0];

        for (i = 1; i < Max; i++)
            BNTree.Create(Data[i]); // 建立二叉查找树

        int KeyValue = 25;
        // 调用二叉查找法
        if (BNTree.BinarySearch(KeyValue) > 0)
            // 输出查找次数
            System.out
                    .println("Search Time = " + BNTree.BinarySearch(KeyValue));
        else
            // 输出没有找到数据
            System.out.println("No Found!!");
    }

    static class BNTreeArray {
        public static int MaxSize = 20;
        public static int[] TreeData = new int[MaxSize];
        public static int[] RightNode = new int[MaxSize];
        public static int[] LeftNode = new int[MaxSize];

        public BNTreeArray() {
            int i; // 循环计数变量

            for (i = 0; i < MaxSize; i++) {
                TreeData[i] = 0;
                RightNode[i] = -1;
                LeftNode[i] = -1;
            }
        }

        // ----------------------------------------------------
        // 建立二叉树
        // ----------------------------------------------------
        public void Create(int Data) {
            int i; // 循环计数变量
            int Level = 0; // 树的阶层数
            int Position = 0;

            for (i = 0; TreeData[i] != 0; i++)
                ;

            TreeData[i] = Data;
            while (true) // 寻找节点位置
            {
                // 判断是左子树或是右子树
                if (Data > TreeData[Level]) {
                    // 右树是否有下一阶层
                    if (RightNode[Level] != -1)
                        Level = RightNode[Level];
                    else {
                        Position = -1; // 设定为右树
                        break;
                    }
                } else {
                    // 左树是否有下一阶层
                    if (LeftNode[Level] != -1)
                        Level = LeftNode[Level];
                    else {
                        Position = 1; // 设定为左树
                        break;
                    }
                }
            }

            if (Position == 1) // 建立节点的左右连结
                LeftNode[Level] = i; // 连结左子树
            else
                RightNode[Level] = i; // 连结右子树
        }

        // ---------------------------------------------------------
        // 二叉查找法
        // ---------------------------------------------------------
        public static int BinarySearch(int KeyValue) {
            int Pointer; // 现在的节点位置
            int Counter; // 查找次数

            Pointer = 0;
            Counter = 0;
            while (Pointer != -1) {
                Counter++;
                // 找到了目标节点
                if (TreeData[Pointer] == KeyValue)
                    return Counter;
                    // 传回查找次数
                else if (TreeData[Pointer] > KeyValue)
                    Pointer = LeftNode[Pointer];
                    // 往左子树找
                else
                    Pointer = RightNode[Pointer];
                // 往右子树找
            }
            return 0; // 该节点不在此二叉树中
        }

    }


}

