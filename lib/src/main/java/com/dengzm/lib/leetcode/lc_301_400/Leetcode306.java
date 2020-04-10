package com.dengzm.lib.leetcode.lc_301_400;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 累加数
 * @date 2020/4/10 9:52
 */
public class Leetcode306 {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) {
            return false;
        }

        char[] chars = num.toCharArray();
        long pre1, pre2;

        // 起始数字要满足：
        // 1.开头不为0
        // 2.长度不超过总长度的一半
        for (int i = 0; i < num.length() / 2; i ++) {
            if (chars[0] == '0' && i > 0) {
                break;
            }

            pre1 = getNum(chars, 0, i);

            for (int j = i+1; j < num.length(); j ++) {
                if (chars[i+1] == '0' && j > i + 1) {
                    break;
                }

                pre2 = getNum(chars, i+1, j);

                if (isAdditiveNumberCore(chars, j+1, pre1, pre2)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 前两个数相加等于第三个数，如果不符返回false
     */
    private boolean isAdditiveNumberCore(char[] num, int start, long pre1, long pre2) {
        long target = pre1 + pre2;
        int length = String.valueOf(target).length();
        if (getNum(num, start, start + length - 1) != target) {
            return false;
        }

        start = start + length;
        return start == num.length || isAdditiveNumberCore(num, start, pre2, target);
    }

    /**
     * 获取当前数字
     */
    private long getNum(char[] chars, int start, int end) {
        if (end >= chars.length) {
            return -1;
        }

        long ans = 0;
        for (int i = start; i <= end; i ++) {
            ans *= 10;
            ans += (chars[i] - '0');
        }

        return ans;
    }

    public static void main(String[] args) {
        Leetcode306 leetcode306 = new Leetcode306();
        leetcode306.isAdditiveNumber("199100199");
    }
}
