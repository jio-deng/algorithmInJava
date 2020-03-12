package com.dengzm.lib.leetcode.lc_801_900;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 三维形体的表面积
 * @date 2020/3/12 12:34
 */
public class Leetcode892 {
    public int surfaceArea(int[][] grid) {
        int result=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]!=0)
                    //假设每个v=grid[i][j]都是独立的。
                    result+=grid[i][j]*4+2;

                //减去面贴在一起的情况
                if (i>0)
                    result-=Math.min(grid[i-1][j], grid[i][j])*2;
                if (j>0)
                    result-=Math.min(grid[i][j-1], grid[i][j])*2;
            }
        }
        return result;
    }
}
