package com.dengzm.lib.leetcode.lc_501_600;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最长和谐子序列
 * @date 2020/5/2 11:27
 */
public class Leetcode594 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val1 = map.getOrDefault(entry.getKey()-1, 0);
            int val2 = map.getOrDefault(entry.getKey()+1, 0);
            if (val1 == 0 && val2 == 0) {
                continue;
            }
            ans = Math.max(ans, entry.getValue() + Math.max(val1, val2));
        }

        return ans;
    }
}
