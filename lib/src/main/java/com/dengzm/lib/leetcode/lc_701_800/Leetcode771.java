package com.dengzm.lib.leetcode.lc_701_800;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 宝石与石头
 * @date 2020/3/7 9:11
 */
public class Leetcode771 {
    public int numJewelsInStones(String J, String S) {
        int[] nums = new int[128];
        for (char c : S.toCharArray()) {
            nums[c] ++;
        }

        int ans = 0;
        for (char c : J.toCharArray()) {
            ans += nums[c];
        }

        return ans;
    }
}
