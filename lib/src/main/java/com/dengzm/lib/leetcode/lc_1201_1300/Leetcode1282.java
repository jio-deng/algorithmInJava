package com.dengzm.lib.leetcode.lc_1201_1300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 用户分组
 * @date 2020/4/17 19:09
 */
public class Leetcode1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        if (groupSizes == null || groupSizes.length == 0) {
            return ans;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i ++) {
            int size = groupSizes[i];
            if (!map.containsKey(size)) {
                map.put(size, new ArrayList<>());
            }

            List<Integer> list = map.get(size);
            list.add(i);
            if (size == list.size()) {
                ans.add(list);
                map.put(size, new ArrayList<>());
            }
        }

        return ans;
    }
}
