package com.dengzm.lib.leetcode.lc_1_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 盛最多水的容器
 * @date 2019/12/15 17:25
 */
public class Leetcode011 {
    /**
     * 这道题我最开始陷入了一个思维误区绕了半天，其实就是记住盛水量由最短板决定即可
     * 必须要去改变短板位置，否则向中心收拢时乘积只会越来越小
     */

    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int ans = (right - left) * minHeight;
            if (ans > max) {
                max = ans;
            }

            if (height[left] < height[right]) {
                left ++;
            } else {
                right --;
            }
        }

        return max;
    }

    /*执行结果：通过
      显示详情
      执行用时 :3 ms, 在所有 java 提交中击败了93.11%的用户
      内存消耗 :39.9 MB, 在所有 java 提交中击败了92.44%的用户*/
}
