package com.dengzm.lib.leetcode.lc_401_500;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 等差数列划分
 * @date 2020/4/15 12:27
 */
public class Leetcode413 {
    /**
     * 这道题如果需要效率快,那么必然是需要一个O(n)的算法,暴力法不考虑,
     * 复用5号题目的dp思想,效率也不是这么让人满意,
     * 这道题主要是需要找到其规律,从小的例子出发,仔细观察,
     *
     * 会发现当整个数组为(1, 2, 3, 4, 5, 6)的时候,
     * 我们先取出前三个,
     * (1, 2, 3)的等差数列的个数为1,
     * (1, 2, 3, 4)的等差数列的个数为3,
     * (1, 2, 3, 4, 5)的等差数列的个数为6,(
     * 1, 2, 3, 4, 5, 6)的等差数列个数为10,
     * 以此类推我们可以很容易的发现在一个等差数列中加入一个数字,
     * 如果还保持着等差数列的特性,每次的增量都会加1,
     * 如果刚加进来的数字与原先的序列构不成等差数列,就将增量置为0,
     *
     * 接下来继续循环,执行以上的逻辑即可.
     * 可以发现,这道题只要找到规律还是相当的简单的.觉得我解释的好的,给我点个赞哈QAQ!
     */
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length <= 2)
            return 0;
        int res = 0;
        int add = 0;
        for (int i = 2; i < A.length; i++)
            if (A[i - 1] - A[i] == A[i - 2] - A[i - 1])
                res += ++add;
            else
                add = 0;
        return res;
    }
}
