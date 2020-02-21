package com.dengzm.lib.leetcode.lc_501_600;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 相对名次
 * @date 2020/2/21 14:46
 */
public class Leetcode506 {
    public String[] findRelativeRanks(int[] nums) {
        int[] x = Arrays.copyOf(nums, nums.length);
        Arrays.sort(x);

        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < x.length; i ++) {
            if (i == 0) {
                map.put(x[x.length - 1], "Gold Medal");
            } else if (i == 1) {
                map.put(x[x.length - 2], "Silver Medal");
            } else if (i == 2) {
                map.put(x[x.length - 3], "Bronze Medal");
            } else {
                map.put(x[x.length - 1 - i], String.valueOf(i+1));
            }
        }

        String[] res = new String[nums.length];
        for (int i = 0; i < res.length; i ++) {
            res[i] = map.get(nums[i]);
        }

        return res;
    }
}
