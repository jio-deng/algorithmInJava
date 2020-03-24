package com.dengzm.lib.leetcode.lc_1001_1100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 总持续时间可被 60 整除的歌曲
 * @date 2020/3/24 10:00
 */
public class Leetcode1010 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] nums = new int[60];

        for (int t : time) {
            nums[t % 60] ++;
        }

        int ans = 0;
        for (int i = 0; i <= 30; i ++) {
            if (i == 0 || i == 30) {
                if (nums[i] > 0) {
                    ans += nums[i] * (nums[i] - 1) / 2;
                }
            } else {
                ans += nums[i] * nums[60 - i];
            }
        }

        return ans;
    }
}
