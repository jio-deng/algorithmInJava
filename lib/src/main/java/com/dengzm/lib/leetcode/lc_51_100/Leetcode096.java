package com.dengzm.lib.leetcode.lc_51_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 不同的二叉搜索树
 * @date 2020/2/1 8:22
 */
public class Leetcode096 {
    private int[] memo;

    public int numTrees(int n) {
        if (n < 1) {
            return 0;
        }

        memo = new int[n];

        return numTreesCore(1, n);
    }

    private int numTreesCore(int start, int end) {
        if (start >= end) {
            return 1;
        }

        int result = 0;
        int length1;
        int length2;
        int result1;
        int result2;
        for (int i = start; i <= end; i ++) {
            length1 = i - 1 - start;
            length2 = end - i - 1;

            result1 = length1 >= 0 && memo[length1] > 0 ? memo[length1] : numTreesCore(start, i - 1);
            result2 = length2 >= 0 && memo[length2] > 0 ? memo[length2] : numTreesCore(i + 1, end);

            result += result1 * result2;

            if (length1 >= 0) {
                memo[length1] = result1;
            }

            if (length2 >= 0) {
                memo[length2] = result2;
            }
        }

        return result;
    }
}
