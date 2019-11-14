package com.dengzm.lib.jianzhi;

/**
 * @Description 011 旋转数组的最小数字
 * 把一个数组最开始的若干元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增的数组的一个旋转，输出旋转数组的最小元素。例如，数组{3，4，5，1，2}是{1，2，3，4，5}的一个旋转，该数组的最小值为1
 * Created by deng on 2018/12/19.
 */
public class Jianzhi011 {

    public static void main(String[] args) {
        //int[] nums = new int[] {3,4,5,1,2};
        //int[] nums = new int[] {1,2,3,4,5};
        int[] nums = new int[] {1,1,0,1,1};
        int result = findMinNum(nums);
        System.out.println(result);
    }

    //判空
    //因为旋转数组本身是两段有序的数组组合而成，可以使用类似二分法的方式。
    //找到中间值比较与左端的大小：如果大于左端，则middle为start；若小于，则middle为end
    //特殊情况：1.数组本身没有旋转，自身就是自己的旋转数组，故开始时增加判断
    //         2.{1,1,0,1,1,1},顺序遍历寻找最小值
    public static int findMinNum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }

        if (nums[0] == nums[nums.length - 1]) {
            int result = nums[0];
            for (int i  = 0; i < nums.length; i ++) {
                if (nums[i] < result) {
                    result = nums[i];
                }
            }
            return result;
        }

        return findMinNumCore(nums, 0, nums.length - 1);
    }

    private static int findMinNumCore(int[] nums, int start, int end) {
        if (end - start == 1 || start ==end) {
            return nums[end];
        }

        int middle = ((end - start) >> 1) + start;
        if (nums[middle] >= nums[start]) {
            return findMinNumCore(nums, middle, end);
        } else {
            return findMinNumCore(nums, start, middle);
        }

    }
}
