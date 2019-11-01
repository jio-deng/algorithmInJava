package com.dengzm.lib;

/**
 * @Description 029 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 *
 * Created by deng on 2019/5/2.
 */
public class Jianzhi029 {

    public static void main(String[] args) {
        int[][] nums = new int[3][3];
        nums[0][0] = 1;
        nums[0][1] = 2;
        nums[0][2] = 3;
        nums[1][0] = 4;
        nums[1][1] = 5;
        nums[1][2] = 6;
        nums[2][0] = 7;
        nums[2][1] = 8;
        nums[2][2] = 9;
        printMatrixClockwisely(nums);
    }

    private static void printMatrixClockwisely(int[][] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int columns = nums.length;
        int rows = nums[0].length;

        int start = 0;

        while (columns > start * 2 && rows > start * 2) {
            printMatrixInCircle(nums, columns, rows, start);
            ++ start;
        }
    }

    private static void printMatrixInCircle(int[][] nums, int columns, int rows, int start) {
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;

        // 从左到右打印一行
        for (int i = start; i <= endY; i ++) {
            printNumber(nums[start][i]);
        }

        // 从上到下打印一列
        if (start < endY) {
            for (int i = start + 1; i <= endY; i ++) {
                printNumber(nums[i][endX]);
            }
        }

        // 从右到左打印一行
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i --) {
                printNumber(nums[endY][i]);
            }
        }

        // 从下到上打印一列
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i --) {
                printNumber(nums[i][start]);
            }
        }

    }

    private static void printNumber(int number) {
        System.out.print(number + " ");
    }
}
