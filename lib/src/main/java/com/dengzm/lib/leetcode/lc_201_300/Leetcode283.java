package com.dengzm.lib.leetcode.lc_201_300;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 移动零
 * @date 2020/2/14 12:02
 */
public class Leetcode283 {
    public void moveZeroes(int[] nums) {
        int i, j = 0;
        for(i = 0 ; i < nums.length; i++) {
            if(nums[i] != 0)
            {
                nums[j++] = nums[i];
            }
        }

        while(j < nums.length) {
            nums[j++] = 0;
        }

//        int indexOfZero = -1;
//        for (int i = 0; i < nums.length; i ++) {
//            if (nums[i] == 0) {
//                if (indexOfZero == -1) {
//                    indexOfZero = i;
//                }
//            } else {
//                if (indexOfZero != -1) {
//                    nums[indexOfZero] = nums[i];
//                    nums[i] = 0;
//                    i = indexOfZero;
//                    indexOfZero = -1;
//                }
//            }
//        }
    }
}
