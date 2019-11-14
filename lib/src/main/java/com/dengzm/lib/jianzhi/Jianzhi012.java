package com.dengzm.lib.jianzhi;

/**
 * @Description 012 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左右上下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * Created by deng on 2018/12/20.
 */
public class Jianzhi012 {

    public static void main(String[] args) {
        char[] matrix = new char[] {'a','b','t','g','c','f','c','s','j','d','e','h'};
        System.out.println(hasPath(matrix, 3, 4, "bfce"));
        System.out.println(hasPath(matrix, 3, 4, "abfb"));
        System.out.println(hasPath(matrix, 3, 4, "bfceh"));
        System.out.println(hasPath(matrix, 3, 4, "bfbfbfbf"));
    }

    //回溯法：每次访问到一个格子时，如果当前格子内的字符是要找的字符，则判断当前字符的四周是否有下一个字符；
    //当目标string被遍历完时，即可以找到该路径。在寻找的过程中使用boolean数组来表示当前位置是否被访问过，避免重复访问。
    public static boolean hasPath(char[] matrix, int rows, int columns, String target) {
        if (matrix == null || matrix.length == 0 || rows < 1 || columns < 1 || target == null || target.length() == 0) {
            System.out.println("initial data is empty!");
            return false;
        }

        boolean[] isVisited = new boolean[matrix.length];
        for (int i  = 0; i < isVisited.length; i ++) {
            isVisited[i] = false;
        }

        char[] targetString = target.toCharArray();

        for (int row = 0; row < rows; row ++) {
            for (int column = 0; column < columns; column ++) {
                if (hasPathCore(matrix, rows, columns, row, column, targetString, 0, isVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPathCore(char[] matrix, int rows, int columns, int row, int column,
                                       char[] target, int pathLength, boolean[] isVisited) {
        if (pathLength == target.length) {
            return true;
        }

        boolean hasPath = false;
        if (row >= 0 && row < rows
                && column >= 0 && column < columns
                && matrix[row * columns + column] == target[pathLength]
                && !isVisited[row * columns + column]) {
            pathLength ++;
            isVisited[row * columns + column] = true;

            hasPath = hasPathCore(matrix, rows, columns, row, column - 1, target, pathLength, isVisited)
                    || hasPathCore(matrix, rows, columns, row - 1, column, target, pathLength, isVisited)
                    || hasPathCore(matrix, rows, columns, row, column + 1, target, pathLength, isVisited)
                    || hasPathCore(matrix, rows, columns, row + 1, column, target, pathLength, isVisited);

            if (!hasPath) {
                isVisited[row * columns + column] = false;
            }
        }
        return hasPath;
    }
}
