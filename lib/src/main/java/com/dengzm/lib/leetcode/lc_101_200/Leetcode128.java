package com.dengzm.lib.leetcode.lc_101_200;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最长连续序列
 * @date 2020/6/6 8:55
 */
public class Leetcode128 {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                continue;
            }
            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);
            int cur = left + right + 1;
            ans = Math.max(ans, cur);
            map.put(num, cur);
            map.put(num - left, cur);
            map.put(num + right, cur);
        }

        return ans;
    }
}
