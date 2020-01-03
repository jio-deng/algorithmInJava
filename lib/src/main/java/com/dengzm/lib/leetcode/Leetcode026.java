package com.dengzm.lib.leetcode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 删除排序数组中的重复项
 * @date 2020/1/3 21:50
 */
public class Leetcode026 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        int length = 0;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] != nums[length]) {
                length ++;
                nums[length] = nums[i];

            }
        }

        return length + 1;
    }

    /*执行结果：通过
      显示详情
      执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
      内存消耗 :40.3 MB, 在所有 Java 提交中击败了94.62%的用户*/
}
