package com.dengzm.lib.leetcode.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 四数之和
 * @date 2019/12/29 8:44
 */
public class Leetcode018 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i ++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // max and min
            int min = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (min > target) {
                break;
            }

            int max = nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] + nums[i];
            if (max < target) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j ++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // max and min
                int minJ = nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if (minJ > target) {
                    break;
                }

                int maxJ = nums[nums.length - 1] + nums[nums.length - 2] + nums[j] + nums[i];
                if (maxJ < target) {
                    continue;
                }

                int temp = nums[i] + nums[j];
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    int tempResult = temp + nums[left] + nums[right];
                    if (tempResult == target) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);

                        left ++;
                        while (left > 0 && left < nums.length && nums[left] == nums[left - 1]) left ++;
                        right --;
                        while (right > 0 && right < nums.length - 1 && nums[right] == nums[right + 1]) right --;
                    } else if (tempResult > target) {
                        right --;
                    } else {
                        left ++;
                    }
                }
            }
        }

        return result;
    }

    /*执行结果：通过
      显示详情
      执行用时 :4 ms, 在所有 java 提交中击败了99.54%的用户
      内存消耗 :39.1 MB, 在所有 java 提交中击败了87.11%的用户*/
}
