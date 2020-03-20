package com.dengzm.lib.leetcode.lc_1001_1100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 将数组分成和相等的三个部分
 * @date 2020/3/11 9:32
 */
public class Leetcode1013 {
    public boolean canThreePartsEqualSum(int[] A) {
        int leftIndex = 0, rightIndex = A.length - 1;
        int leftSum = 0, rightSum = 0, sum = 0;

        for (int i : A) {
            sum += i;
        }

        if (sum % 3 != 0) {
            return false;
        }

        int tartgetSum = sum / 3;

        leftSum = A[0];
        rightSum = A[A.length - 1];

        while (leftIndex < A.length - 1) {
            if (leftSum != tartgetSum) {
                leftIndex ++;
                leftSum += A[leftIndex];
            } else {
                break;
            }
        }

        while (rightIndex > 0) {
            if (rightSum != tartgetSum) {
                rightIndex --;
                rightSum += A[rightIndex];
            } else {
                break;
            }
        }

        return leftSum == tartgetSum && rightSum == tartgetSum && leftIndex < rightIndex - 1;
    }
}
