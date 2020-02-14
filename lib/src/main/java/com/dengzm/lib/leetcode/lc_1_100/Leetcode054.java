package com.dengzm.lib.leetcode.lc_1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 螺旋矩阵
 * @date 2020/1/20 15:09
 */
public class Leetcode054 {
    public List <Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0)
            return ans;
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) {
                ans.add(matrix[r1][c]);
            }

            /**
             * 记录：
             * for循环最开始，如果不满足条件，也不会执行
             */
            for (int r = r1 + 1; r <= r2; r++) {
                System.out.println("r = " + r + "matrix[r][c2] = " + matrix[r][c2]);
                ans.add(matrix[r][c2]);
            }

            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) {
                    ans.add(matrix[r2][c]);
                }

                for (int r = r2; r > r1; r--) {
                    ans.add(matrix[r][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }


    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int rStart = 0, rEnd = matrix.length - 1, cStart = 0, cEnd = matrix[0].length - 1;

        while (rStart < rEnd && cStart < cEnd) {
            for (int i = cStart; i <= cEnd; i ++) {
                result.add(matrix[rStart][i]);
            }

            for (int i = rStart + 1; i <= rEnd; i ++) {
                result.add(matrix[i][cEnd]);
            }

            for (int i = cEnd - 1; i >= cStart; i --) {
                result.add(matrix[rEnd][i]);
            }

            for (int i = rEnd - 1; i >= rStart + 1; i --) {
                result.add(matrix[i][cStart]);
            }

            rStart ++;
            rEnd --;
            cStart ++;
            cEnd --;
        }

        if (rStart < rEnd && cStart == cEnd) {
            for (int i = rStart; i <= rEnd; i ++) {
                result.add(matrix[i][cStart]);
            }
        } else if (cStart < cEnd && rStart == rEnd) {
            for (int i = cStart; i <= cEnd; i ++) {
                result.add(matrix[rStart][i]);
            }
        } else if (rStart == rEnd && cStart == cEnd) {
            result.add(matrix[rStart][cStart]);
        }

        return result;
    }

    public static void main(String[] args) {
        Leetcode054 leetcode054 = new Leetcode054();
        int[][] matrix = new int[][] {
                { 1, 2, 3 }};
        leetcode054.spiralOrder(matrix);
    }
}
