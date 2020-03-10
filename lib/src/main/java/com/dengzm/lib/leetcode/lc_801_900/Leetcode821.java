package com.dengzm.lib.leetcode.lc_801_900;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 字符的最短距离
 * @date 2020/3/9 10:45
 */
public class Leetcode821 {
    public int[] shortestToChar(String S, char C) {
        int[] ans = new int[S.length()];
        Arrays.fill(ans, S.length());

        for (int i = 0; i < ans.length; i ++) {
            if (S.charAt(i) == C) {
                ans[i] = 0;
            }
        }

        for (int i = 0; i < ans.length; i ++) {
            if (ans[i] == 0) {
                int left = i - 1;
                while (left >= 0) {
                    if (ans[left] > i - left) {
                        ans[left] = i - left;
                        left --;
                    } else {
                        break;
                    }
                }

                int right = i + 1;
                while (right < ans.length) {
                    if (ans[right] > right - i) {
                        ans[right] = right - i;
                        right ++;
                    } else {
                        break;
                    }
                }
            }
        }

        return ans;
    }
}
