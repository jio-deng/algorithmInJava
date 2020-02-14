package com.dengzm.lib.leetcode.lc_101_200;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description Excel表列序号
 * @date 2020/2/13 10:15
 */
public class Leetcode171 {
    public int titleToNumber(String s) {
        int result = 0;
        char[] chars = s.toCharArray();

//        int xishu = 1;
//        for (int i = chars.length - 1; i >= 0; i --) {
//            int temp = chars[i] - 'A' + 1;
//            result += temp * xishu;
//            xishu *= 26;
//        }
        for (char c : chars) {
            result = result * 26 + (c - 'A' + 1);
        }

        return result;
    }
}
