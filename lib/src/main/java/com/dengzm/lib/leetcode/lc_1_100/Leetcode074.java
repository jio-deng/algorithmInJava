package com.dengzm.lib.leetcode.lc_1_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 搜索二维矩阵
 * @date 2020/1/29 10:16
 */
public class Leetcode074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        return findTarger(matrix, 0, matrix.length * matrix[0].length - 1, target);
    }

    private boolean findTarger(int[][] nums, int start, int end, int target) {
        if (start > end) {
            return false;
        }

        int mid = (start + end) / 2;
        int row = mid / nums[0].length;
        int col = mid % nums[0].length;

        if (nums[row][col] == target) {
            return true;
        } else if (nums[row][col] < target) {
            return findTarger(nums, mid + 1, end, target);
        } else {
            return findTarger(nums, start, mid - 1, target);
        }
    }


//    public boolean searchMatrix1(int[][] matrix, int target) {
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//            return false;
//        }
//
//        int colIndex = 0;
//        while (colIndex < matrix.length) {
//            int temp = matrix[colIndex][0];
//            if (temp == target) {
//                return true;
//            } else if (temp > target) {
//                break;
//            }
//
//            colIndex ++;
//        }
//
//        colIndex --;
//
//        if (colIndex < 0) {
//            return false;
//        }
//
//        return findTarger(matrix[colIndex], 0, matrix[colIndex].length - 1, target);
//    }
//
//    private boolean findTarger(int[] nums, int start, int end, int target) {
//        if (start > end) {
//            return false;
//        }
//
//        int mid = (start + end) / 2;
//        if (nums[mid] == target) {
//            return true;
//        } else if (nums[mid] < target) {
//            return findTarger(nums, mid + 1, end, target);
//        } else {
//            return findTarger(nums, start, mid - 1, target);
//        }
//    }
}
