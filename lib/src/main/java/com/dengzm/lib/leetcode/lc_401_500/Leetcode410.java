package com.dengzm.lib.leetcode.lc_401_500;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 分割数组的最大值
 * @date 2020/7/25 12:06
 */
class Leetcode410 {
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        long right = 0, left = 0;
        for (int n : nums) {
            right += n;
            left = Math.max(left, n);
        }

        while (left < right) {
            long mid = left + (right - left) / 2;
            int cnt = 0;
            long sum = 0;
            for (int n : nums) {
                if (sum + n <= mid) {
                    sum += n;
                } else {
                    cnt ++;
                    sum = n;
                }
            }

            if (sum > 0) {
                cnt ++;
            }

            if (cnt > m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return (int) left;
    }
}
