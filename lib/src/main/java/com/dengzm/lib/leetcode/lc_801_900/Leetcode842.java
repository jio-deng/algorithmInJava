package com.dengzm.lib.leetcode.lc_801_900;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 将数组拆分成斐波那契序列
 * @date 2020/4/10 11:25
 */
public class Leetcode842 {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ans = new ArrayList<>();
        if (S == null || S.length() < 3) {
            return ans;
        }

        char[] chars = S.toCharArray();
        int pre1, pre2;

        // 起始数字要满足：
        // 1.开头不为0
        // 2.长度不超过总长度的一半
        for (int i = 0; i < S.length() / 2; i ++) {
            if (chars[0] == '0' && i > 0) {
                break;
            }

            pre1 = getNum(chars, 0, i);

            for (int j = i+1; j < S.length(); j ++) {
                if (chars[i+1] == '0' && j > i + 1) {
                    break;
                }

                ans.clear();
                ans.add(pre1);

                pre2 = getNum(chars, i+1, j);
                ans.add(pre2);

                if (isAdditiveNumberCore(chars, j+1, ans)) {
                    return ans;
                }
            }
        }

        ans.clear();
        return ans;
    }

    /**
     * 前两个数相加等于第三个数，如果不符返回false
     */
    private boolean isAdditiveNumberCore(char[] num, int start, List<Integer> list) {
        int target = list.get(list.size() - 2) + list.get(list.size() - 1);
        int length = String.valueOf(target).length();
        if (getNum(num, start, start + length - 1) != target) {
            return false;
        }

        start = start + length;
        list.add(target);

        return start == num.length || isAdditiveNumberCore(num, start, list);
    }

    /**
     * 获取当前数字
     */
    private int getNum(char[] chars, int start, int end) {
        if (end >= chars.length) {
            return -1;
        }

        int ans = 0;
        for (int i = start; i <= end; i ++) {
            ans *= 10;
            ans += (chars[i] - '0');
        }

        return ans;
    }
}
