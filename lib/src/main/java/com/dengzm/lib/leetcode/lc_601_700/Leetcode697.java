package com.dengzm.lib.leetcode.lc_601_700;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 数组的度
 * @date 2020/3/1 10:29
 */
public class Leetcode697 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < nums.length; i ++) {
            int num = nums[i];
            if (!left.containsKey(num)) {
                left.put(num, i);
            }

            right.put(num, i);
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int ans = nums.length;
        int degree = Collections.max(count.values());
        for (int x : count.keySet()) {
            if (count.get(x) == degree) {
                ans = Math.min(ans, right.get(x) - left.get(x) + 1);
            }
        }

        return ans;
    }
}
