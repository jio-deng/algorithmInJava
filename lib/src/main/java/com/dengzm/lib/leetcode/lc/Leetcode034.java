package com.dengzm.lib.leetcode.lc;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 在排序数组中查找元素的第一个和最后一个位置
 * @date 2020/1/15 12:50
 */
public class Leetcode034 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] { -1, -1 };

        if (nums == null || nums.length == 0) {
            return result;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int pivot = (start + end) / 2;

            if (nums[pivot] == target) {
                result[0] = findLeft(nums, target, start, pivot);
                result[1] = findRight(nums, target, pivot, end);
                break;
            } else if (nums[pivot] > target) {
                end = pivot - 1;
            } else {
                start = pivot + 1;
            }

        }

        return result;
    }

    private int findLeft(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int pivot = (start + end) / 2;

            if (nums[pivot] == target) {
                if (pivot == 0 || nums[pivot - 1] < target) {
                    return pivot;
                } else {
                    end = pivot - 1;
                }
            } else {
                start = pivot + 1;
            }
        }

        return -1;
    }

    private int findRight(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int pivot = (start + end) / 2;

            if (nums[pivot] == target) {
                if (pivot == nums.length - 1 || nums[pivot + 1] > target) {
                    return pivot;
                } else {
                    start = pivot + 1;
                }
            } else {
                end = pivot - 1;
            }
        }

        return -1;
    }
}
