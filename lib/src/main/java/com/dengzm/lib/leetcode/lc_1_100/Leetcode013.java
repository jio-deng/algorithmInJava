package com.dengzm.lib.leetcode.lc_1_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 罗马数字转整数
 * @date 2019/12/15 17:53
 */
public class Leetcode013 {
    /**
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     *
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。
     * 但也存在特例，例如 4 不写做 IIII，而是 IV。
     * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
     * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     *
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     *
     * 示例 1:
     * 输入: "III"
     * 输出: 3
     *
     * 示例 2:
     * 输入: "IV"
     * 输出: 4
     *
     * 示例 3:
     * 输入: "IX"
     * 输出: 9
     *
     * 示例 4:
     * 输入: "LVIII"
     * 输出: 58
     * 解释: L = 50, V= 5, III = 3.
     *
     * 示例 5:
     * 输入: "MCMXCIV"
     * 输出: 1994
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     */

    private int[] values = new int[]{1, 5, 10, 50, 100, 500, 1000};
//    int I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000;

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int result = 0;
        int lastValue = 1001;
        for (int i = 0; i < s.length(); i ++) {
            int value = getValue(s.charAt(i));
            if (value <= lastValue) {
                result += value;
            } else {
                result = result + value - lastValue * 2;
            }

            lastValue = value;
        }

        return result;
    }

    /*执行结果：通过
      显示详情
      执行用时 :5 ms, 在所有 java 提交中击败了92.82%的用户
      内存消耗 :36.1 MB, 在所有 java 提交中击败了98.41%的用户*/

    public int getValue(char c) {
        switch (c) {
            case 'M':
                return values[6];
            case 'D':
                return values[5];
            case 'C':
                return values[4];
            case 'L':
                return values[3];
            case 'X':
                return values[2];
            case 'V':
                return values[1];
            case 'I':
                return values[0];
        }

        return 0;
    }
}