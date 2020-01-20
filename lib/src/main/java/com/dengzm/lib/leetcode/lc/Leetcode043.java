package com.dengzm.lib.leetcode.lc;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 字符串相乘
 * @date 2019/12/10 12:03
 */
public class Leetcode043 {

    /**
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     *
     * 示例 1:
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     * 示例 2:
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     *
     * 说明：
     * num1 和 num2 的长度小于110。
     * num1 和 num2 只包含数字 0-9。
     * num1 和 num2 均不以零开头，除非是数字 0 本身。
     * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
     */

    /**
     * link form : https://leetcode-cn.com/problems/multiply-strings/comments/
     * @param num1 num1
     * @param num2 num2
     * @return multi
     */
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return null;
        }

        int[] result = new int[num1.length() + num2.length()];

        for (int i = num2.length() - 1; i >= 0; i --) {
            for (int j = num1.length() - 1; j >= 0 ; j --) {
                // 计算当前位
                int bitmul = (num2.charAt(i) - '0') * (num1.charAt(j) - '0');
                bitmul += result[i + j + 1];

                // 进位
                // 此处不必考虑循环过程中因为进位导致的大于10的情况：
                // 因为计算的顺序和我们用竖式计算乘法是一样的，这样进位后，一定会通过下一步的运算去重新计算被进位的位
                result[i + j] += bitmul / 10;
                result[i + j + 1] = bitmul % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < result.length && result[i] == 0) {
            i ++;
        }

        if (i == result.length) {
            return "0";
        }

        for (; i < result.length; i ++) {
            sb.append(result[i]);
        }

        return sb.toString();
    }

    /*执行结果：通过
      显示详情
      执行用时 :5 ms, 在所有 java 提交中击败了88.68%的用户
      内存消耗 :36.3 MB, 在所有 java 提交中击败了90.36%的用户*/
}
