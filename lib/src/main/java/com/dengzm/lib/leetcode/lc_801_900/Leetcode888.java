package com.dengzm.lib.leetcode.lc_801_900;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 公平的糖果交换
 * @date 2020/3/12 12:07
 */
public class Leetcode888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int sum1 = 0;
        for (int i : A) {
            sum1 += i;
        }

        int sum2 = 0;
        for (int i : B) {
            sum2 += i;
        }

        int[] bigger, shorter;
        int dif;
        if (sum1 >= sum2) {
            bigger = A;
            shorter = B;
            dif = sum1 - sum2;
        } else {
            bigger = B;
            shorter = A;
            dif = sum2 - sum1;
        }

        int left = 0, right = 0;
        while (left < bigger.length && right < shorter.length) {
            int val = (bigger[left] - shorter[right]) * 2;
            if (val == dif) {
                int[] res = new int[2];
                res[0] = sum1 >= sum2 ? bigger[left] : shorter[right];
                res[1] = sum1 >= sum2 ? shorter[right] : bigger[left];
                return res;
            } else if (val > dif) {
                right ++;
            } else {
                left ++;
            }
        }

        return new int[2];
    }

    public static void main(String[] args) {
        Leetcode888 leetcode888 = new Leetcode888();
        leetcode888.fairCandySwap(new int[] {1,1}, new int[] {2,2});
    }
}
