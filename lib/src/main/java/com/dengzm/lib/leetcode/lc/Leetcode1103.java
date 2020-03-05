package com.dengzm.lib.leetcode.lc;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 分糖果 II
 * @date 2020/3/5 10:47
 */
public class Leetcode1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int cur = 1;
        int sum = 0;
        int index = 0;
        int[] ans = new int[num_people];

        while (sum < candies) {
            sum += cur;
            if (sum > candies) {
                cur = candies + cur - sum;
            }

            ans[index ++] += cur;
            if (index == num_people) {
                index = 0;
            }

            cur ++;
        }

        return ans;
    }
}
