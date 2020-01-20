package com.dengzm.lib.leetcode.lc;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最长公共前缀
 * @date 2019/12/15 18:35
 */
public class Leetcode014 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i ++) {
            for (int j = 1; j < strs.length; j ++) {
                if (i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }

            sb.append(strs[0].charAt(i));
        }

        return sb.toString();
    }

    /*执行结果：通过
      显示详情
      执行用时 :1 ms, 在所有 java 提交中击败了88.93%的用户
      内存消耗 :37 MB, 在所有 java 提交中击败了81.99%的用户*/
}
