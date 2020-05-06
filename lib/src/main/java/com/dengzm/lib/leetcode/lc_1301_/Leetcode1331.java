package com.dengzm.lib.leetcode.lc_1301_;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 数组序号转换
 * @date 2020/5/2 12:21
 */
public class Leetcode1331 {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] tmp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(tmp);
        int index = 1;
        for (int i = 0; i < tmp.length; i ++) {
            if (!map.containsKey(tmp[i])) {
                map.put(tmp[i], index);
                index ++;
            }
        }

        for (int i = 0; i < arr.length; i ++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}
