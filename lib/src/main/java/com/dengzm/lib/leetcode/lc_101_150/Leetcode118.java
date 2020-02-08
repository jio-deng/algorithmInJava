package com.dengzm.lib.leetcode.lc_101_150;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 杨辉三角
 * @date 2020/2/7 18:24
 */
public class Leetcode118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows < 1) {
            return result;
        }

        for (int i = 1; i <= numRows; i ++) {
            if (i == 1) {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                result.add(list);
                continue;
            }

            List<Integer> preList = result.get(i-2);
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i; j ++) {
                if (j == 0) {
                    list.add(1);
                } else if (j == i-1) {
                    list.add(1);
                } else {
                    list.add(preList.get(j) + preList.get(j-1));
                }
            }

            result.add(list);
        }

        return result;
    }
}
