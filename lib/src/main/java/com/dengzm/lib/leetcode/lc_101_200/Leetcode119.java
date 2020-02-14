package com.dengzm.lib.leetcode.lc_101_200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 杨辉三角 II
 * @date 2020/2/7 18:33
 */
public class Leetcode119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        rowIndex ++;
        if (rowIndex < 1) {
            return result;
        }

        int[] nums = new int[rowIndex];

        for (int i = 1; i <= rowIndex; i ++) {
            if (i == 1) {
                nums[0] = 1;
                continue;
            }

            for (int j = i - 1; j > 0; j --) {
                nums[j] = nums[j] + nums[j - 1];
            }
        }

        for (int i : nums) {
            result.add(i);
        }

        return result;
    }
}
