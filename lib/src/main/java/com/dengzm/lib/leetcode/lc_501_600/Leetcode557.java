package com.dengzm.lib.leetcode.lc_501_600;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 反转字符串中的单词 III
 * @date 2020/2/21 17:15
 */
public class Leetcode557 {
    public String reverseWords(String s) {
        char[] ans = s.toCharArray();
        int start = -1, end;
        for (int i = 0; i < ans.length; i ++) {
            if ((ans[i] == ' ' || i == ans.length - 1) && start != -1) {
                end = ans[i] == ' ' ? i - 1 : i;
                if (start >= end) {
                    start = -1;
                    continue;
                }

                while (start < end) {
                    char temp = ans[start];
                    ans[start] = ans[end];
                    ans[end] = temp;

                    start ++;
                    end --;
                }

                start = -1;
            } else if (start == -1) {
                start = i;
            }
        }

        return String.valueOf(ans);
    }
}
