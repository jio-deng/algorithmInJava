package com.dengzm.lib.leetcode.lc_1301_;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 拥有最多糖果的孩子
 * @date 2020/5/3 11:25
 */
public class Leetcode5384 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int c : candies) {
            max = Math.max(max, c);
        }

        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < candies.length; i ++) {
            if (candies[i] + extraCandies >= max) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }

        return ans;
    }
}
