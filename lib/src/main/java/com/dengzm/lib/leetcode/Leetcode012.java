package com.dengzm.lib.leetcode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 整数转罗马数字
 * @date 2019/12/16 18:05
 */
public class Leetcode012 {

    private int[] values = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    private String[] symbols = new String[] {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
//    int I = 1, IV = 4, V = 5, IX = 9, X = 10, XL = 40, L = 50, XC = 90, C = 100, CD = 400, D = 500, CM = 900, M = 1000;

    public String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        for (int i = values.length - 1; i >= 0; i --) {
            int value = values[i];
            while (num >= value) {
                num -= value;
                result.append(symbols[i]);
            }

            if (num == 0) {
                break;
            }
        }

        return result.toString();
    }

    /*执行结果：通过
      显示详情
      执行用时 :5 ms, 在所有 java 提交中击败了93.29%的用户
      内存消耗 :36.1 MB, 在所有 java 提交中击败了100.00%的用户*/
}
