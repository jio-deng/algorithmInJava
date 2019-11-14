package com.dengzm.lib.jianzhi;

/**
 * @Description 003 数组中重复的数字
 * Created by deng on 2018/12/18.
 */
public class Jianzhi003 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{0,2,3,4,5,6,7,1,8,8};
        findRepeatNum(nums1);
        int[] nums2 = new int[]{9,2,3,4,5,6,7,1,8,8};
        findRepeatNum2(nums2);
    }

    //题目一：在一个长度为n的数组里，所有数字都在0～n-1的范围内。
    //数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了多少次。
    //请找出数组中任意一个重复的数字。
    //空间复杂度为O(1)
    //原理：从头到尾扫描数组，当扫描到下标为i的数字时，首先判断这个数
    //缺点：修改了原数组
    public static void findRepeatNum(int[] nums) {
        if (nums == null || nums.length == 0) {
            System.out.println("cann't find any nums!");
            return;
        }

        for(int i = 0; i < nums.length; i ++) {
            if (nums[i] < 0 || nums[i] > nums.length - 1) {
                System.out.println("nums illegal!");
                return;
            }
        }

        int temp;

        for (int i = 0; i < nums.length; i ++) {
            while (nums[i] != i) {
                temp = nums[i];
                if (nums[temp] == temp) {
                    System.out.println("find a repeat num : " + temp);
                    return;
                } else {
                    nums[i] = nums[temp];
                    nums[temp] = temp;
                }
            }
        }
    }

    //题目二：在一个长度为n+1的数组里，所有数字在1～n范围内，所以至少又一个是重复的。请找出其中任意一个重复的数组
    //不修改原数组
    //原理：类似于二分法，统计 1～中值 的个数，当数量超过时，说明重复的数字在左面，反之则在右面
    public static void findRepeatNum2(int[] nums) {
        if (nums == null || nums.length == 0) {
            System.out.println("cann't find any nums!");
            return;
        }

        int start = 1;
        int end = nums.length - 1;
        int middle;
        int count;

        while (end >= start) {
            middle = ((end - start) >> 1) + start;
            count = 0;
            for (int i = 0; i < nums.length; i ++) {
                if (nums[i] >= start && nums[i] <= middle) {
                    count ++;
                }
            }

            if (end == start) {
                if (count > 1) {
                    System.out.println("find a repeat num : " + start);
                } else {
                    System.out.println("no repeat num found !");
                }
                return;
            }

            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
    }
}
