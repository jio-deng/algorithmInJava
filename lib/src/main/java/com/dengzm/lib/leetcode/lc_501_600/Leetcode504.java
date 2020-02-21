package com.dengzm.lib.leetcode.lc_501_600;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 七进制数
 * @date 2020/2/21 14:42
 */
public class Leetcode504 {
    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();

        boolean flag = true;
        if (num < 0) {
            flag = false;
            num = -num;
        }

        while (num > 0) {
            sb.insert(0, num % 7);
            num = num / 7;
        }

        if (!flag) {
            sb.insert(0, "-");
        }

        if (sb.length() == 0) {
            sb.append("0");
        }

        return sb.toString();
    }
}
