package com.dengzm.lib.leetcode.lc_1_50;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最长回文子串
 * @date 2019/12/12 11:59
 */
public class Leetcode005 {

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *
     * 示例 1：
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     *
     * 示例 2：
     * 输入: "cbbd"
     * 输出: "bb"
     */

    /**
     * 出自评论区大神{@糖丶7}的解法：本质上还是中心扩散法，但是将奇数和偶数的情况进行了统一，耗时更短
     * 该算法意识到当出现连续相同的字符时, 可以把这一段相同的字符看做一个点来寻找以该点为中点的最长回文字符串,
     * 从而只要一出现连续相同的字符, 就可以直接快进到这串相同字符的最后一位再开始回文字符串检查
     *
     * https://leetcode-cn.com/problems/longest-palindromic-substring/comments/
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        // 用于保存最长字串的位置
        int[] range = new int[2];

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i ++) {
            i = findLongest(chars, i, range);
        }

        return s.substring(range[0], range[1] + 1);
    }

    public int findLongest(char[] chars, int low, int[] range) {
        int high = low;
        // 将相同的中心部分看作一个整体，寻找它的左右位置
        while (high < chars.length - 1 && chars[high] == chars[high + 1]) {
            high ++;
        }

        // 中心部分的最后一个字符
        int ans = high;

        while (low > 0 && high < chars.length - 1 && chars[low - 1] == chars[high + 1]) {
            low --;
            high ++;
        }

        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }

        return ans;
    }

    /*执行结果：通过
      显示详情
      执行用时 :2 ms, 在所有 java 提交中击败了99.96%的用户
      内存消耗 :36.5 MB, 在所有 java 提交中击败了90.75%的用户*/


    /**
     * 马拉车算法
     */
    public String longestPalindromeByManacher(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder("$#");

        for (int i = 0; i < s.length(); i ++) {
            sb.append(s.charAt(i)).append("#");
        }

        char[] target = sb.toString().toCharArray();
        int[] p = new int[target.length];
        int mx = 0, id = 0, resLen = 0, resCenter = 0;
        for (int i = 1; i < target.length; i ++) {
            // mx > i ,即i在mx内，此时可以复用对称点的半径，但是复用大小不能超过mx-i
            p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;
            while (i + p[i] < target.length && i - p[i] > 0 && target[i + p[i]] == target[i - p[i]]) {
                p[i] ++;
            }

            if (mx < i + p[i]) {
                mx = i + p[i];
                id = i;
            }

            if (resLen < p[i]) {
                resLen = p[i];
                resCenter = i;
            }
        }

        int start = (resCenter-resLen)/2;
        return s.substring(start, start+resLen-1);
    }

    /*执行结果：通过
      显示详情
      执行用时 :7 ms, 在所有 java 提交中击败了96.00%的用户
      内存消耗 :36.5 MB, 在所有 java 提交中击败了90.61%的用户*/
}
