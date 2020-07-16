package com.dengzm.lib.leetcode.lc_701_800;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 判断二分图
 * @date 2020/7/16 15:51
 */
class Leetcode785 {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return true;
        }

        int n = graph.length;

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        boolean[] isAdded = new boolean[n];
        boolean[] isVisited = new boolean[n];

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (true) {
            if (queue.isEmpty()) {
                for (int i = 0; i < n; i ++) {
                    boolean isV = isVisited[i];
                    if (!isV) {
                        queue.add(i);
                        break;
                    }
                }
            }

            if (queue.isEmpty()) {
                break;
            }

            Integer index = queue.poll();
            if (isVisited[index]) {
                continue;
            }

            isVisited[index] = true;
            int[] g = graph[index];

            int flag = 0;
            if (isAdded[index]) {
                flag = set1.contains(index) ? 1 : 2;
            }

            int targetFlag = flag == 0 ? 0 : flag == 1 ? 2 : 1;
            for (int dot : g) {
                if (isAdded[dot]) {
                    int tmp = set1.contains(dot) ? 1 : 2;
                    if (targetFlag == 0) {
                        targetFlag = tmp;
                    } else {
                        if (targetFlag != tmp) {
                            return false;
                        }
                    }
                }

                isAdded[dot] = true;
                queue.add(dot);
            }

            if (flag == 1 || flag == 0 && (targetFlag == 0 || targetFlag == 2)) {
                set1.add(index);
                for (int dot : g) {
                    set2.add(dot);
                }
            } else {
                set2.add(index);
                for (int dot : g) {
                    set1.add(dot);
                }
            }
        }

        return true;
    }
}
