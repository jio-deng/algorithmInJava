package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题17. 打印从1到最大的n位数
 * @date 2020/5/9 17:27
 */
public class Ms017 {
    public int[] printNumbers(int n) {
        int max = (int)Math.pow(10, n);
        int[] ans = new int[max - 1];
        for (int i = 0; i < max - 1; i ++) {
            ans[i] = i+1;
        }

        return ans;
    }
}
