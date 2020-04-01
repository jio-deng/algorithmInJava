package com.dengzm.lib.leetcode.lc_1101_1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最小绝对差
 * @date 2020/3/31 16:44
 */
public class Leetcode1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i ++) {
            int minus = arr[i+1] - arr[i];
            if (minus > min) {
                continue;
            }

            if (minus < min) {
                res.clear();
                min = minus;
            }

            List<Integer> list = new ArrayList<>();
            list.add(arr[i]);
            list.add(arr[i+1]);
            res.add(list);
        }

        return res;
    }
}
