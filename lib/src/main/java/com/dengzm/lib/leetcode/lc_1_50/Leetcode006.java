package com.dengzm.lib.leetcode.lc_1_50;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description Z 字形变换
 * @date 2019/12/13 18:04
 */
public class Leetcode006 {
    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     *
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     *
     * string convert(string s, int numRows);
     *
     * 示例 1:
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     *
     * 示例 2:
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     *
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     */


    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i ++) {
            int curIndex = i;
            int newIndex;
            while (curIndex < s.length()) {
                sb.append(s.charAt(curIndex));

                newIndex = curIndex + (numRows - 1) * 2;

                if (i != 0 && i != numRows - 1 && newIndex - i * 2 > curIndex && newIndex - i * 2 < s.length()) {
                    sb.append(s.charAt(newIndex - i * 2));
                }

                curIndex = newIndex;
            }
        }

        return sb.toString();
    }

    /*执行结果：通过
      显示详情
      执行用时 :4 ms, 在所有 java 提交中击败了95.18%的用户
      内存消耗 :37.6 MB, 在所有 java 提交中击败了98.48%的用户*/
}
