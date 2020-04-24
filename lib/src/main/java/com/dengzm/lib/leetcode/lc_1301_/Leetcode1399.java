package com.dengzm.lib.leetcode.lc_1301_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 统计最大组的数目
 * @date 2020/4/24 10:50
 */
public class Leetcode1399 {
    public int countLargestGroup(int n) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i ++) {
            int val = 0;
            int tmp = i;
            while (tmp > 0) {
                val += tmp % 10;
                tmp /= 10;
            }

            if (!map.containsKey(val)) {
                map.put(val, new ArrayList<>());
            }

            map.get(val).add(i);
        }

        int ans = 0, size = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() > size) {
                ans = 1;
                size = list.size();
            } else if (list.size() == size) {
                ans ++;
            }
        }


        return ans;
    }
}
