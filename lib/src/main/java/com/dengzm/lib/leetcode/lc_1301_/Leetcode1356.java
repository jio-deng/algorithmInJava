package com.dengzm.lib.leetcode.lc_1301_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 根据数字二进制下 1 的数目排序
 * @date 2020/5/2 12:12
 */
public class Leetcode1356 {
    public int[] sortByBits(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int a : arr) {
            int count = Integer.bitCount(a);

            if (!map.containsKey(count)) {
                map.put(count, new ArrayList<>());
            }

            map.get(count).add(a);
        }

        List<Map.Entry<Integer, List<Integer>>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, List<Integer>>>() {
            @Override
            public int compare(Map.Entry<Integer, List<Integer>> o1, Map.Entry<Integer, List<Integer>> o2) {
                return o1.getKey() - o2.getKey();
            }
        });

        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : list) {
            List<Integer> l = entry.getValue();
            Collections.sort(l, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });

            ans.addAll(l);
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i ++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
