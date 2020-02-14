package com.dengzm.lib.leetcode.lc_1_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 搜索旋转排序数组
 * @date 2020/1/15 11:33
 */
public class Leetcode033 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int rotateIndex = findRotateIndex(nums);

        if (target == nums[0]) {
            return 0;
        } else if (target > nums[0]) {
            return searchBinary(nums, target, 0, rotateIndex);
        } else {
            return searchBinary(nums, target, rotateIndex + 1, nums.length - 1);
        }
    }

    private int searchBinary(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (target == nums[pivot]) {
                return pivot;
            } else if (target < nums[pivot]) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }

        return -1;
    }


    private int findRotateIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (left == right) {
                return left;
            }

            int pivot = (left + right) / 2;

            if (nums[pivot] > nums[pivot + 1]) {
                return pivot;
            } else {
                if (nums[pivot] < nums[left]) {
                    right = pivot - 1;
                } else {
                    left = pivot + 1;
                }
            }
        }

        return 0;
    }

//    public int search(int[] nums, int target) {
//        if (nums == null || nums.length == 0) {
//            return -1;
//        }
//
//        if (target >= nums[0]) {
//            for (int i = 0; i < nums.length; i ++) {
//                if (target == nums[i]) {
//                    return i;
//                } else if (target < nums[i]) {
//                    break;
//                }
//
//                if (i < nums.length - 1 && nums[i + 1] < nums[i]) {
//                    break;
//                }
//            }
//        } else {
//            for (int i = nums.length - 1; i > 0; i --) {
//                if (target == nums[i]) {
//                    return i;
//                } else if (target > nums[i]) {
//                    break;
//                }
//
//                if (i > 1 && nums[i - 1] > nums[i]) {
//                    break;
//                }
//            }
//        }
//
//        return -1;
//    }
}
