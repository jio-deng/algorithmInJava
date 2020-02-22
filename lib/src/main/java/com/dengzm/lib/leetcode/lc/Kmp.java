package com.dengzm.lib.leetcode.lc;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description KMP
 * @date 2020/2/22 15:02
 */
public class Kmp {
    // https://blog.csdn.net/v_JULY_v/article/details/7041827
    // https://blog.csdn.net/f1033774377/article/details/82556438
    public int kmp(String target, String str) {
        int[] next = next(str);

        int i = 0, j = 0;

        while (i < target.length()) {
            if (target.charAt(i) == str.charAt(j)) {
                i++;
                j++;
                if (j == str.length()) {
                    // j = next[j-1] + 1;
                    return i - str.length() + 1;
                }
            } else {
                if (j == 0)
                    i++;
                else
                    j = next[j-1]+1;
            }
        }

        return -1;
    }

    private int[] next(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;

        for (int i = 1; i < next.length; i++) {
            int j = next[i-1];

            while (pattern.charAt(j+1) != pattern.charAt(i) && j >= 0)
                j = next[j];

            if (pattern.charAt(j+1) == pattern.charAt(i))
                next[i] = j+1;
            else
                next[i] = -1;
        }

        return next;
    }
}
