package com.dengzm.lib.leetcode.lc_1_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 移除元素
 * @date 2020/1/3 22:09
 */
public class Leetcode027 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == val) {
                continue;
            }

            nums[length] = nums[i];
            length ++;
        }

        return length + 1;
    }

    /*执行结果：通过
      显示详情
      执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
      内存消耗 :36.3 MB, 在所有 Java 提交中击败了83.94%的用户*/
}
