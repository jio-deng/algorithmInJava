package com.dengzm.lib.leetcode.lc_1201_1300;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 将每个元素替换为右侧最大元素
 * @date 2020/3/31 18:13
 */
public class Leetcode1299 {
    public int[] replaceElements(int[] arr) {
        int[] ans = new int[arr.length];
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i --) {
            if (i + 1 < arr.length) {
                max = Math.max(max, arr[i+1]);
            }

            ans[i] = max;
        }

        return ans;
    }
}
