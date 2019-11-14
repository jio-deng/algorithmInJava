package com.dengzm.lib.jianzhi;

/**
 * @Description 047 礼物的最大价值
 *
 * Created by deng on 2019/9/21.
 */
public class Jianzhi047 {

    public static void main(String[] args) {
        int[][] data1 = new int[][] {{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};
        int[][] data2 = new int[][] {{1, 10, 3, 8}, {12, 2, 90, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};

        System.out.println("Max value is " + getMaxValue(data1));
        System.out.println("Max value is " + getMaxValue(data2));
    }

    /**
     * 首先计算第一排，从第二排开始，计算从左或从上来的最大值，并保存
     */
    private static int getMaxValue(int[][] values) {
        if(values == null || values.length == 0 || values[0].length == 0) {
            return -1;
        }

        int rows = values.length;
        int cols = values[0].length;
        int[] maxValues = new int[cols];

        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j ++) {
                int left = 0;
                int up = 0;

                if (i > 0) {
                    up = maxValues[j];
                }

                if (j > 0) {
                    left = maxValues[j - 1];
                }

                maxValues[j] = Math.max(up, left) + values[i][j];
            }
        }

        return maxValues[cols - 1];
    }

}
