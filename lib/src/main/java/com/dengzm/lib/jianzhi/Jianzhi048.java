package com.dengzm.lib.jianzhi;

/**
 * @Description 048 最长不含重复字符串的子字符串
 *
 * Created by deng on 2019/9/21.
 */
public class Jianzhi048 {

    public static void main(String[] args) {
        System.out.println("Longest length is " + longestSubstringLengthWithoutDuplication("arabcacfr"));
        System.out.println("Longest length is " + longestSubstringLengthWithoutDuplication("arabcasdasdfgyjkhngacfr"));
        System.out.println("Longest length is " + longestSubstringLengthWithoutDuplication("arabcafhrydshbgbncfr"));
    }

    private static int longestSubstringLengthWithoutDuplication(String target) {
        if (target == null || target.length() == 0) {
            return 0;
        }

        int curLength = 0;
        int maxLength = 0;

        int[] position = new int[26];
        for (int i = 0; i < position.length; i ++) {
            position[i] = -1;
        }

        for (int i = 0; i < target.length(); i ++) {
            int preIndex = position[target.charAt(i) - 'a'];
            if (preIndex == -1 || i - preIndex > curLength) {
                // 该字母未出现过 或 在当前子字符串之外
                curLength ++;
            } else {
                // 保存长度、更新起点
                if (curLength > maxLength) {
                    maxLength = curLength;
                }

                curLength = i - preIndex;
            }

            // 记录当前字母出现的位置
            position[target.charAt(i) - 'a'] = i;
        }

        if (curLength > maxLength) {
            maxLength = curLength;
        }

        return maxLength;
    }
}
