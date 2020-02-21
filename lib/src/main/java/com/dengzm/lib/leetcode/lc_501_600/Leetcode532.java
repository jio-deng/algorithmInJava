package com.dengzm.lib.leetcode.lc_501_600;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 数组中的K-diff数对
 * @date 2020/2/21 16:12
 */
public class Leetcode532 {
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int ans = 0;
        if (k == 0) {
            for (int num : map.values()) {
                if (num > 1) {
                    ans ++;
                }
            }
        } else {
            for (int num : map.keySet()) {
                if (map.get(num + k) != null) {
                    ans ++;
                }
            }
        }

        return ans;
    }
}
