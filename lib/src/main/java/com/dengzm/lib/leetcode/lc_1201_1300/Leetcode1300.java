package com.dengzm.lib.leetcode.lc_1201_1300;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 转变数组后最接近目标值的数组和
 * @date 2020/6/14 19:52
 */
public class Leetcode1300 {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);

        int i, part = 0;
        for (i = 0; i < arr.length; i ++) {
            int sum = part + arr[i] * (arr.length - i);
            if (sum > target) {
                break;
            }

            part += arr[i];
        }

        if (i == arr.length) {
            return arr[arr.length - 1];
        }

        int remain = target - part;
        int l = remain / (arr.length - i);
        int r = l + 1;

        return remain - l * (arr.length - i) <= r * (arr.length - i) - remain ? l : r;
    }


    // 读错题了
//    public int findBestValue(int[] arr, int target) {
//        Arrays.sort(arr);
//
//        int ans = Integer.MAX_VALUE, index = 1;
//        int muti = arr.length;
//        for (int i = 0; i < arr.length; i ++) {
//            int tmp = arr[i];
//            while (tmp * (muti - i) > target) {
//                if (Math.abs(target - ans * index) > Math.abs(tmp * (muti - i) - target) ||
//                        tmp < ans && Math.abs(target - ans * index) == Math.abs(tmp * (muti - i) - target)) {
//                    index = muti - i;
//                    ans = tmp;
//                }
//
//                tmp --;
//            }
//
//            if (tmp * (muti - i) == target) {
//                return tmp;
//            }
//
//            if (Math.abs(target - ans * index) > Math.abs(tmp * (muti - i) - target) ||
//                    tmp < ans && Math.abs(target - ans * index) == Math.abs(tmp * (muti - i) - target)) {
//                index = muti - i;
//                ans = tmp;
//            }
//        }
//
//        return ans;
//    }

    public static void main(String[] args) {
        Leetcode1300 leetcode1300 = new Leetcode1300();
        leetcode1300.findBestValue(new int[] {2,3,5}, 10);
    }
}
