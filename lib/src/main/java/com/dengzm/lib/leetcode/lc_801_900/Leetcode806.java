package com.dengzm.lib.leetcode.lc_801_900;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 写字符串需要的行数
 * @date 2020/3/7 10:03
 */
public class Leetcode806 {
    public int[] numberOfLines(int[] widths, String S) {
        int[] lengths = new int[1000];
        int index = 0;

        for (char c : S.toCharArray()) {

            int width = widths[c-'a'];
            while (index < 1000) {
                if (lengths[index] + width > 100) {
                    index ++;
                    continue;
                }

                lengths[index] += width;
                break;
            }

        }

        int[] ans = new int[2];
        for (int i = 0; i < lengths.length; i ++) {
            if (lengths[i] == 0) {
                break;
            }

            ans[0] = i + 1;
            ans[1] = lengths[i];
        }

        return ans;
    }
}
