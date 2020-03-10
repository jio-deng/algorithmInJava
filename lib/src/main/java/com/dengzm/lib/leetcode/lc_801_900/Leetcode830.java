package com.dengzm.lib.leetcode.lc_801_900;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 较大分组的位置
 * @date 2020/3/10 9:47
 */
public class Leetcode830 {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        int start = -1, end = -1;
        char[] s = S.toCharArray();
        for (int i = 0; i <= s.length; i ++) {
            if (i == 0) {
                start = i;
                continue;
            } else if (i == s.length) {
                if (end - start >= 2) {
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(end);
                    res.add(list);
                }

                continue;
            }

            if (s[i] == s[i-1]) {
                end = i;
            } else {
                if (end - start >= 2) {
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(end);
                    res.add(list);
                }

                start = i;
            }
        }

        return res;
    }
}
