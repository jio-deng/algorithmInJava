package com.dengzm.lib;

/**
 * @Description 057 和为s的数字
 * 题目一：和为s的两个数
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * 题目二：和为s的连续正数序列
 * 输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）
 *
 * Created by deng on 2019/10/31.
 */
public class Jianzhi057 {

    public static void main(String[] args) {
        int[] data1 = new int[] {1,3,5,6,8,9,12,15,17,20};

        findNumbersWithSum(data1, 20);
        findNumbersWithSum(data1, 17);
        findNumbersWithSum(data1, 18);
        System.out.println();

        findContinuousSequence(15);
        System.out.println();
        findContinuousSequence(25);
        System.out.println();
        findContinuousSequence(35);
        System.out.println();
    }

    /**
     * 题目一
     * 两个下标，从数组的头尾开始遍历，如果和大于s，左边的下标增加；如果下雨，则右边的增加，直到和为s 或 下标相等
     *
     * @param data data
     * @param s sum
     */
    private static void findNumbersWithSum(int[] data, int s) {
        if (data == null || data.length < 2 || s < data[0]) {
            System.out.println("sth is wrong in data or sum is too big");
            return;
        }

        int leftIndex = 0;
        int rightIndex = data.length - 1;

        while (leftIndex != rightIndex) {
            int sum = data[leftIndex] + data[rightIndex];
            if (sum == s) {
                System.out.println("sum is " + s + " and the numbers are " + data[leftIndex] + " and " + data[rightIndex]);
                return;
            } else if (sum > s) {
                rightIndex --;
            } else {
                leftIndex ++;
            }
        }

        System.out.println("no such numbers in data");
    }

    /**
     * 题目二
     * 与题目一类似，在计算和时，如果小于sum，右边增加；如果大于，左边增加，相当于整体向右移动
     *
     * @param sum sum
     */
    private static void findContinuousSequence(int sum) {
        if (sum < 2) {
            System.out.println("sum cannot be less than 2");
            return;
        }

        int leftIndex = 1;
        int rightIndex = 2;

        while (leftIndex < (sum + 1) / 2 && leftIndex < rightIndex) {
            float tempSum = ((float)(leftIndex + rightIndex)) * (rightIndex - leftIndex + 1) / 2;
            if (tempSum == sum) {
                System.out.println("sum is " + sum + ", sequence is " + leftIndex + " to " + rightIndex);
                leftIndex ++;
            } else if (tempSum > sum) {
                leftIndex ++;
            } else {
                rightIndex ++;
            }
        }
    }
}
