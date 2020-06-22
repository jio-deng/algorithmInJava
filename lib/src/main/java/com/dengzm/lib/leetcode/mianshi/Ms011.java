package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 剑指 Offer 11. 旋转数组的最小数字
 * @date 2020/6/22 10:50
 */
public class Ms011 {
    public int minArray(int[] numbers) {
        int start = 0, end = numbers.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (numbers[mid] < numbers[end]) {
                end = mid;
            } else if (numbers[mid] > numbers[end]) {
                start = mid + 1;
            } else {
                end --;
            }
        }

        return numbers[start];
    }
}
