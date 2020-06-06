package com.dengzm.lib.leetcode.mianshi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题29. 顺时针打印矩阵
 * @date 2020/6/5 11:17
 */
public class Ms029 {
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int index = 0;
        List<Integer> list = new ArrayList<>();
        int n = matrix.length, m = matrix[0].length;
        int dn1 = 0, dn2 = n-1, dm1 = 0, dm2 = m-1;

        int sX = -1, sY = 0;
        boolean flag = false;

        while (true) {
            int nsX = sX + dx[index], nsY = sY + dy[index];

            if (nsX < dm1 || nsX > dm2 || nsY < dn1 || nsY > dn2) {
                if (!flag) {
                    flag = true;
                    if (index == 0) {
                        dn1 ++;
                    } else if (index == 1) {
                        dm2 --;
                    } else if (index == 2) {
                        dn2 --;
                    } else {
                        dm1 ++;
                    }
                    index = (index + 1) % 4;
                    continue;
                } else {
                    break;
                }
            }

            flag = false;

            sX = nsX;
            sY = nsY;

            list.add(matrix[sY][sX]);
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i ++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
