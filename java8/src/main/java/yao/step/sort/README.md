# Sort Algorithms

## 01 SelectSort 选择排序

## 02 InsertSort 插入排序

## 03 ShellSort 希尔排序

## 04 MergeSort 归并排序

## 05 QuickSort 快速排序

## 06 HeapSort 堆排序

## 07 BubbleSort 冒泡排序

## 08 RadixSort 基数排序

## 09 CountingSort 计数排序
- 基本原理



## 10 BucketSort 桶排序
- 基本原理  
桶排序，也称箱排序，使用分治的思想  
a. 将待排序的数据按映射函数分成连续的若干段，最好使数据平均分布  
b. 确定桶数量  
c. 每个桶内部排序  
d. 按顺序输出数据  
`假设数组元素最大值和最小值分别为max和min，则桶的个数为max - min + 1，也即数组区间[min, max]每个元素和桶下标区间[0,max - min + 1]中每个元素一一对应，这也是桶排序的核心思想。
`
- 特征

**时间复杂度** O(M+N) M是桶个数（一般为最大数），N是待排序个数
**空间复杂度** 

**条件**
 

- 优点

- 缺点
 
- 应用场景








