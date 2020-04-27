package com.dengzm.lib.leetcode.mianshi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 04.01. 节点间通路
 * @date 2020/4/25 15:18
 */
public class Ms0401 {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        if (start == target) {
            return true;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] g : graph) {
            int key = g[0], val = g[1];
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(val);
        }

        boolean[] isVisited = new boolean[n];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int point = queue.poll();
            if (point == target) {
                return true;
            }

            if (isVisited[point]) {
                continue;
            }

            isVisited[point] = true;

            if (!map.containsKey(point)) {
                continue;
            }

            queue.addAll(map.get(point));
        }

        return false;
    }
}
