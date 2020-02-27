package com.dengzm.lib.leetcode.lc_501_600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 两个列表的最小索引总和
 * @date 2020/2/24 16:38
 */
public class Leetcode599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (int i = 0;i < list1.length; i ++) {
            map.put(list1[i], i);
        }

        int num = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i ++) {
            if (map.containsKey(list2[i])) {
                if (num == i + map.get(list2[i])) {
                    ans.add(list2[i]);
                } else if (num > i + map.get(list2[i])) {
                    ans.clear();
                    ans.add(list2[i]);
                    num = i + map.get(list2[i]);
                }
            }
        }

        return ans.toArray(new String[0]);
    }
}
