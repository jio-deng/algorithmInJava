package com.dengzm.lib.leetcode.lc_801_900;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 适龄的朋友
 * @date 2020/4/30 17:20
 */
public class Leetcode825 {
    public int numFriendRequests(int[] ages) {
        int[] nums = new int[121];
        for (int age : ages) {
            nums[age] ++;
        }

        int ans = 0;
        for (int i = 120; i >= 1; i --) {
            if (nums[i] == 0) {
                continue;
            }

            if (i > 0.5 * i + 7) {
                ans += nums[i] * (nums[i] - 1);
            }

            for (int j = i - 1; j >= 1; j --) {
                if (j <= 0.5 * i + 7) {
                    break;
                } else {
                    ans += nums[j] * nums[i];
                }
            }
        }

        return ans;
    }
}
