package com.dengzm.lib.leetcode.lc_1_50;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 字符串转换整数 (atoi)
 * @date 2019/12/13 20:06
 */
public class Leetcode008 {

    public int myAtoi(String str) {
        if (str == null || str.length() == 0 || str.trim().length() == 0) {
            return 0;
        }

        char[] target = str.trim().toCharArray();
        boolean aboveZero = true;

        int index = 0;

        if (target[index] == '-') {
            aboveZero = false;
            index ++;
        } else if (target[index] == '+') {
            index ++;
        }

        int result = 0;
        while (index < target.length) {
            if (target[index] < '0' || target[index] > '9') {
                break;
            }

            //溢出判断
            if (aboveZero && result > Integer.MAX_VALUE / 10) {
                return Integer.MAX_VALUE;
            }
            if (aboveZero && result == Integer.MAX_VALUE / 10 && target[index] - '0' > Integer.MAX_VALUE % 10) {
                return Integer.MAX_VALUE;
            }
            if (!aboveZero && -result < Integer.MIN_VALUE / 10) {
                return Integer.MIN_VALUE;
            }
            if (!aboveZero && -result == Integer.MIN_VALUE / 10 && - (target[index] - '0') < Integer.MIN_VALUE % 10) {
                return Integer.MIN_VALUE;
            }

            result = result * 10 + (target[index] - '0');

            index ++;
        }

        return aboveZero ? result : -result;
    }
    
    /*执行结果：通过
      显示详情
      执行用时 :2 ms, 在所有 java 提交中击败了99.79%的用户
      内存消耗 :35.9 MB, 在所有 java 提交中击败了87.79%的用户*/
}
