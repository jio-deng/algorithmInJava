package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 16.18. 模式匹配
 * @date 2020/6/22 10:10
 */
public class Ms1618 {
    public boolean patternMatching(String pattern, String value) {
        // 模式为空
        if (pattern == null || pattern.length() == 0) {
            return value == null || value.length() == 0;
        }

        // 计算a，b的个数
        int countA = 0, countB = 0;
        for (char c : pattern.toCharArray()) {
            if (c == 'a') {
                countA ++;
            } else {
                countB ++;
            }
        }

        if (value == null || value.length() == 0) {
            return countA * countB == 0; // 只有一个可以为空
        }

        // 如果有0个的 让b是0
        if (countA == 0) {
            countA = countA + countB - (countB = countA);
        }

        // 边界情况：当只有一种字母，或是有一个字母代表“”
        int len = value.length() / countA;
        if (len * countA == value.length()) {
            String s = value.substring(0, len);
            if (value.replace(s, "").isEmpty()) {
                return true;
            }
        }

        if (countB == 0) {
            return false;
        } else {
            int len1 = value.length() / countB;
            if (len1 * countB == value.length()) {
                String s = value.substring(0, len1);
                if (value.replace(s, "").isEmpty()) {
                    return true;
                }
            }
        }

        // 循环
        for (int i = 1; i < value.length() / countA; i ++) {
            // 长度判断
            int bLen = (value.length() - i * countA) / countB;
            if (i * countA + bLen * countB != value.length()) {
                continue;
            }

            // 是否相等判断
            String s1 = null, s2 = null, tmp;
            int index = 0;
            for (char c : pattern.toCharArray()) {
                if (c == 'a') {
                    tmp = value.substring(index, index + i);
                    if (s1 == null) {
                        s1 = tmp;
                    } else {
                        if (!s1.equals(tmp)) {
                            break;
                        }
                    }
                    index += i;
                } else {
                    tmp = value.substring(index, index + bLen);
                    if (s2 == null) {
                        s2 = tmp;
                    } else {
                        if (!s2.equals(tmp)) {
                            break;
                        }
                    }
                    index += bLen;
                }
            }

            if (index == value.length()) {
                return true;
            }
        }

        return false;
    }
}
