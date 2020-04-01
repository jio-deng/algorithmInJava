package com.dengzm.lib.leetcode.lc_1301_1400;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 解压缩编码列表
 * @date 2020/3/31 17:52
 */
public class Leetcode1313 {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            int k = nums[i];
            int val = nums[i+1];
            while (k > 0) {
                list.add(val);
                k --;
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i ++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}
