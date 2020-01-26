package com.dengzm.lib.leetcode.lc_1_50;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 跳跃游戏 II
 * @date 2020/1/20 12:23
 */
public class Leetcode045 {
    public int jump(int[] nums) {
        int step = 0;
        int end = 0;
        int maxPosition = 0;

        for (int i = 0; i < nums.length - 1; i ++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);

            if (maxPosition >= nums.length - 1) {
                return ++ step;
            }

            if (i == end) {
                end = maxPosition;
                step ++;
            }
        }

        return step;
    }




//    public int jump(int[] nums) {
//        int step = 0;
//        int cur = 0;
//        while (cur < nums.length - 1) {
//            int curI = cur;
//            int tempMax = 0;
//            for (int i = 0; i <= nums[cur]; i ++) {
//                int temp = i + cur;
//                if (temp >= nums.length - 1) {
//                    return step + 1;
//                }
//
//                if (nums[temp] + temp > tempMax) {
//                    curI = temp;
//                    tempMax = nums[temp] + temp;
//                }
//            }
//
//            step ++;
//            cur = curI;
//        }
//
//        return step;
//    }
}
