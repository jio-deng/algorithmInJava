package com.dengzm.lib.leetcode.lc_1_100;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最接近的三数之和
 * @date 2019/12/22 9:52
 */
public class Leetcode016 {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) {
            throw new RuntimeException("params are not right!");
        }

        int len = nums.length;
        Arrays.sort(nums); // 排序

        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len - 2; i ++) {
            int left = i + 1;
            int right = len - 1;

            if (nums[i] + nums[i + 1] + nums[i + 2] > target && nums[i] + nums[i + 1] + nums[i + 2] - target > Math.abs(result - target)) {
                break;
            }

            // 判断最小值
            int min = nums[i] + nums[left] + nums[left + 1];
            if(target < min){
                if(Math.abs(result - target) > Math.abs(min - target))
                    result = min;
                continue;
            }
            //判断最大值
            int max = nums[i] + nums[right] + nums[right - 1];
            if(target > max){
                if(Math.abs(result - target) > Math.abs(max - target))
                    result = max;
                continue;
            }

            while (left < right) {
                int tempResult = nums[i] + nums[left] + nums[right];
                if (tempResult == target) {
                    return target;
                } else if (Math.abs(result - target) > Math.abs(tempResult - target)) {
                    result = tempResult;
                }

                if (tempResult > target) {
                    right --;
                } else {
                    left ++;
                }
            }
        }

        return result;
    }

    /*执行结果：通过
      显示详情
      执行用时 :2 ms, 在所有 java 提交中击败了100.00%的用户
      内存消耗 :36.4 MB, 在所有 java 提交中击败了84.12%的用户*/
}
