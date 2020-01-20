package com.dengzm.lib.leetcode.lc;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最长有效括号
 * @date 2020/1/15 10:45
 */
public class Leetcode032 {
    /**
     * 题解中三种解法，都很牛逼
     * 动态规划、栈、两边遍历
     * https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode/
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        int[] dp = new int[s.length()];
        int ans = 0;

        for (int i = 1; i < s.length(); i ++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }

                ans = Math.max(ans, dp[i]);
            }
        }

        return ans;
    }
}
