package com.dengzm.lib.leetcode.lc_1_50;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 正则表达式匹配
 * @date 2019/12/15 15:43
 */
public class Leetcode010 {

    /**
     * https://leetcode-cn.com/problems/regular-expression-matching/solution/ji-yu-guan-fang-ti-jie-gen-xiang-xi-de-jiang-jie-b/
     */

    public boolean isMatch(String s, String p) {
        boolean[][] memo = new boolean[s.length() + 1][p.length() + 1];
        boolean[][] flag = new boolean[s.length() + 1][p.length() + 1];
        return isMatchCore(memo, flag, s, 0, p, 0);
    }

    public boolean isMatchCore(boolean[][] memo, boolean[][] flag,  String text, int tIndex, String pattern, int pIndex) {
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }

        if (flag[tIndex][pIndex]) {
            return memo[tIndex][pIndex];
        }

        boolean result;
        boolean first = !text.isEmpty() && (text.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.');
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            result = isMatchCore(memo, flag, text, tIndex, pattern.substring(2), pIndex + 2) ||
                    first && isMatchCore(memo, flag, text.substring(1), tIndex + 1,  pattern, pIndex);
        } else {
            result = first && isMatchCore(memo, flag, text.substring(1), tIndex + 1, pattern.substring(1), pIndex + 1);
        }

        memo[tIndex][pIndex] = result;
        flag[tIndex][pIndex] = true;
        return result;
    }

    /*执行结果：通过
      显示详情
      执行用时 :3 ms, 在所有 java 提交中击败了93.45%的用户
      内存消耗 :36.5 MB, 在所有 java 提交中击败了86.87%的用户*/

    public static void main(String[] args) {
        Leetcode010 leetcode010 = new Leetcode010();
        System.out.println(leetcode010.isMatch("aaa", "a*"));
    }
}
