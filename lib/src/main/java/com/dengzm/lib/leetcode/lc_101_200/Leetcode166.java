package com.dengzm.lib.leetcode.lc_101_200;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 分数到小数
 * @date 2020/4/2 13:06
 */
public class Leetcode166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder fraction = new StringBuilder();
        // If either one is negative (not both)
        if (numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }
        // Convert to Long or else abs(-2147483648) overflows
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        fraction.append(String.valueOf(dividend / divisor));
        long remainder = dividend % divisor;
        if (remainder == 0) {
            return fraction.toString();
        }
        fraction.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                break;
            }
            map.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append(String.valueOf(remainder / divisor));
            remainder %= divisor;
        }
        return fraction.toString();
    }



    /**
     * 自己写的残次品 懒得改了，太垃圾
     */
    public String fractionToDecimal1(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        Map<Integer, Integer> map = new HashMap<>();
        while (numerator > 0) {
            int v = numerator / denominator;
            int left = numerator % denominator;
            if (v == 0) {
                if (!flag) {
                    flag = true;
                    sb.append(".");
                } else {
                    if (map.containsKey(left)) {
                        sb.append(")");
                        sb.insert(map.get(left), "(");
                        break;
                    }
                    sb.append(v);
                    map.put(left, sb.length() - 1);
                }

                numerator = left * 10;
            } else {
                if (flag) {
                    if (map.containsKey(left)) {
                        sb.append(")");
                        sb.insert(map.get(left), "(");
                        break;
                    }
                    sb.append(v);
                    map.put(left, sb.length() - 1);
                    numerator = left * 10;
                } else {
                    sb.append(v);
                    numerator = left;
                }
            }
        }

        if (sb.charAt(0) == '.') {
            sb.insert(0, "0");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Leetcode166 leetcode166 = new Leetcode166();
        leetcode166.fractionToDecimal(2, 3);
    }
}
