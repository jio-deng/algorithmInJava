package com.dengzm.lib.leetcode.lc_401_500;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 找到所有数组中消失的数字
 * @date 2020/2/15 18:43
 */
public class Leetcode448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i ++) {
            while (nums[i] != i + 1) {
                int temp = nums[i];
                if (nums[temp-1] == temp) {
                    break;
                }

                nums[i] = nums[temp-1];
                nums[temp-1] = temp;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }

        return result;
    }
}
