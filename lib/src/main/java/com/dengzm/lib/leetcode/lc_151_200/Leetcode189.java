package com.dengzm.lib.leetcode.lc_151_200;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 旋转数组
 * @date 2020/2/13 10:58
 */
public class Leetcode189 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

//    public void rotate(int[] nums, int k) {
//        int n = nums.length;
//        k %= n;
//        reverse(nums, 0, n - 1);
//        reverse(nums, 0, k - 1);
//        reverse(nums, k, n - 1);
//    }
//
//    private void reverse(int[] nums, int start, int end) {
//        while (start < end) {
//            int temp = nums[start];
//            nums[start++] = nums[end];
//            nums[end--] = temp;
//        }
//    }
}
