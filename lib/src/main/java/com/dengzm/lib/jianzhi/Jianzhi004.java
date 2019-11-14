package com.dengzm.lib.jianzhi;

/**
 * @Description 004 二维数组中的查找
 * 在一个二维数组中，每一行都按照从左到右的顺序递增，每一列都按照从上到下的顺序递增
 * 判断数组中是否含有某个整数
 * Created by deng on 2018/12/18.
 */
public class Jianzhi004 {

    public static void main(String[] args) {
        int[][] nums = new int[][] {{1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}};

        findNum(7, nums);
        findNum(5, nums);
    }

    //三种情况
    //1.相等：找到当前数字
    //2.比目标数字大：因为是从矩阵的右上角开始检测，如果大于目标数，则当前列均大于目标数，列数减1
    //3.比目标数组小：同上，如果小于目标数，则当前行均小于目标数，行数加1
    public static void findNum(int target, int[][] nums) {
        if (nums == null || nums.length == 0) {
            System.out.println("nums is empty!");
            return;
        }

        int rows = nums.length;
        int columns = nums[0].length;

        int row = 0;
        int column = columns - 1;

        while (row < rows && column >= 0) {
            if (nums[row][column] == target) {
                System.out.println(String.format("found the target at row %d column %d", row, column));
                return;
            } else if (nums[row][column] > target){
                column --;
            } else {
                row ++;
            }
        }

        System.out.println("no found target num!");
    }


}
