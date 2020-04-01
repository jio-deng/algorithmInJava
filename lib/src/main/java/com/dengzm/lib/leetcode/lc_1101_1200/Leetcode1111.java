package com.dengzm.lib.leetcode.lc_1101_1200;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 有效括号的嵌套深度
 * @date 2020/4/1 12:34
 */
public class Leetcode1111 {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int first = 0, second = 0;
        for (int i = 0; i < seq.length(); i ++) {
            char c = seq.charAt(i);
            if (c == '(') {
                if (first <= second) {
                    first ++;
                } else {
                    second ++;
                    ans[i] = 1;
                }
            } else {
                if (first > second) {
                    first --;
                } else {
                    second --;
                    ans[i] = 1;
                }
            }
        }

        return ans;
    }
}
