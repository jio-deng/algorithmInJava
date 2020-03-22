package com.dengzm.lib.leetcode.lc_1001_1100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 查找常用字符
 * @date 2020/3/22 10:07
 */
public class Leetcode1002 {
    public List<String> commonChars(String[] A) {
        int[][] times = new int[A.length][128];
        for (int i = 0; i < A.length; i ++) {
            char[] chars = A[i].toCharArray();
            int[] t = times[i];
            for (char c : chars) {
                t[c] ++;
            }
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < 128; i ++) {
            int min = 100;
            for (int j = 0; j < A.length; j ++) {
                if (times[j][i] < min) {
                    min = times[j][i];
                    if (min == 0) {
                        break;
                    }
                }
            }

            while (min > 0) {
                res.add(String.valueOf((char) i));
                min --;
            }
        }

        return res;
    }
}
