package com.dengzm.lib.leetcode.lc_1_100;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 寻找两个有序数组的中位数
 * @date 2019/12/12 11:03
 */
public class Leetcode004 {
    /**
     * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * 你可以假设 nums1 和 nums2 不会同时为空。
     *
     * 示例 1:
     * nums1 = [1, 3]
     * nums2 = [2]
     * 则中位数是 2.0
     *
     * 示例 2:
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * 则中位数是 (2 + 3)/2 = 2.5
     */

    /**
     * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-shu-b/
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        // make sure (m <= n)
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;

            int tep = m;
            m = n;
            n = tep;
        }

        // in case length == 0
        if (n == 0) {
            return 0.0;
        } else if (m == 0) {
            return n % 2 == 0 ? ((double) nums2[n / 2 - 1] + nums2[n / 2]) / 2 : ((double) nums2[n / 2]);
        }

        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            // mid in m
            int i = (iMin + iMax) / 2;
            // mid in n
            int j = halfLen - i;

            if (i < iMax && nums2[j - 1] > nums1[i]) {
                iMin = i + 1;
            } else if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax = i - 1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j-1];
                } else if (j == 0) {
                    maxLeft = nums1[i-1];
                } else {
                    maxLeft = Math.max(nums1[i-1], nums2[j-1]);
                }
                if ( (m + n) % 2 == 1 ) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums2[j], nums1[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }

        return 0.0;
    }

    /*执行结果：通过
      显示详情
      执行用时 :3 ms, 在所有 java 提交中击败了98.49%的用户
      内存消耗 :44.6 MB, 在所有 java 提交中击败了99.57%的用户*/



    /**
     * 普通做法，时间复杂度不对，不可取
     *
     * @param nums1
     * @param nums2
     * @return
     */
    @Deprecated
    public double findMedianSortedArraysByMyself(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0;
        }

        int length = nums1.length + nums2.length;

        if (length == 0) {
            return 0;
        }

        int[] nums = new int[length];

        System.arraycopy(nums1, 0, nums, 0, nums1.length);
        System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);

        Arrays.sort(nums);

        if (length % 2 == 0) {
            return ((double) nums[length / 2 - 1] + nums[length / 2]) / 2;
        } else {
            return (double) nums[length / 2];
        }
    }

}
