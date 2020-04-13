package com.dengzm.lib.leetcode.lc_301_400;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 310. 最小高度树
 * @date 2020/4/13 11:16
 */
public class Leetcode310 {
    boolean[][] graph;
    int[] t;
    boolean[] visited;
    int left;
    LinkedList<Integer> queue;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        graph = new boolean[n][n];
        t = new int[n];
        visited = new boolean[n];
        left = n;
        queue = new LinkedList<>();

        for (int[] e : edges) {
            graph[e[0]][e[1]] = true;
            graph[e[1]][e[0]] = true;
            t[e[0]] ++;
            t[e[1]] ++;
        }

        while (left > 2) {
            for (int i = 0; i < n; i ++) {
                if (!visited[i] && t[i] == 1) {
                    queue.add(i);
                }
            }

            int size = queue.size();
            while (size > 0) {
                int i = queue.poll();
                visited[i] = true;
                for (int j = 0; j < n; j ++) {
                    if (!visited[j] && graph[i][j]) {
                        t[j] --;
                    }
                }

                left --;
                size --;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            if (!visited[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}
