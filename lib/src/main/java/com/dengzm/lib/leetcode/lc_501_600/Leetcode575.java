package com.dengzm.lib.leetcode.lc_501_600;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 分糖果
 * @date 2020/2/23 18:10
 */
public class Leetcode575 {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int c : candies) {
            set.add(c);
        }

        if (set.size() >= candies.length / 2) {
            return candies.length / 2;
        } else {
            return set.size();
        }
    }
}
