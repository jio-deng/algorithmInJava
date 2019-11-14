package com.dengzm.lib.jianzhi;

/**
 * @Description 013 机器人的运动范围
 * 地上又一个m行n列的方格。一个机器人从坐标（0，0）的格子开始移动，它每次可以向左右上下移动一个格子，但不能进入行和列坐标的数位之和大于k的格子。
 * 例如，k为18时，机器人能进入（35，37），因为3+5+3+7=18。但不能进入（35，38）。
 * 请问该机器人能进入多少个格子？
 * Created by deng on 2018/12/20.
 */
public class Jianzhi013 {

    public static void main(String[] args) {
        System.out.println(movingCount(18, 40, 40));
        System.out.println(movingCount(18, 5, 5));
    }

    //与012类似，使用回溯法
    public static int movingCount(int threshold, int rows, int columns) {
        if (threshold < 0 || rows < 1 || columns < 1) {
            return 0;
        }

        boolean[] isVisited = new boolean[rows * columns];
        for (int i = 0; i < isVisited.length; i ++) {
            isVisited[i] = false;
        }

        return movingCountCore(threshold, rows, columns, 0, 0, isVisited);
    }

    //若当前坐标可到达，返回步数为1+四周可移动的步数
    private static int movingCountCore(int threshold, int rows, int columns, int row, int col, boolean[] isVisited) {
        int count = 0;
        if (check(threshold, rows, columns, row, col, isVisited)) {
            isVisited[row * columns + col] = true;
            count = 1 + movingCountCore(threshold, rows, columns, row, col - 1, isVisited) +
                    movingCountCore(threshold, rows, columns, row - 1, col, isVisited) +
                    movingCountCore(threshold, rows, columns, row, col + 1, isVisited) +
                    movingCountCore(threshold, rows, columns, row + 1, col, isVisited);
        }
        return count;
    }

    //检测当前坐标是否可以到达
    private static boolean check(int threshold, int rows, int columns, int row, int col, boolean[] isVisited) {
        return row >= 0 && row < rows && col >= 0 && col < columns
                && getDigitSum(row) + getDigitSum(col) <= threshold
                && !isVisited[row * columns + col];
    }

    //计算数位和
    private static int getDigitSum(int digit) {
        int sum = 0;
        while (digit > 0) {
            sum += digit % 10;
            digit /= 10;
        }
        return sum;
    }

}
