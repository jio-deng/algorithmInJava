package com.dengzm.lib.leetcode.lc_901_1000;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 找到小镇的法官
 * @date 2020/3/20 12:17
 */
public class Leetcode997 {
    /**
     * 用一个二维数组记录每个结点的入度和出度，出度为0入度为N-1的就是法官
     * @param N
     * @param trust
     * @return
     */
    public int findJudge(int N, int[][] trust) {
        int[][] people = new int[N][2];
        for(int[] person : trust){
            int out = person[0];
            int in = person[1];
            people[out - 1][0] ++;
            people[in - 1][1] ++;
        }
        for(int i = 0; i < N; i ++){
            if(people[i][0] == 0 && people[i][1] == N - 1)
                return i + 1;
        }
        return -1;
    }



    public int findJudge1(int N, int[][] trust) {
        int[][] graph = new int[N+1][N+1];
        for (int[] t : trust) {
            graph[t[0]][t[1]] = 1;
        }

        int ans = -1;
        for (int i = 1; i < graph.length; i ++) {
            int[] g = graph[i];
            int sum = 0;
            for (int a : g) {
                if (a > 0) {
                    sum ++;
                }
            }

            if (sum == 0) {
                ans = i;
                break;
            }
        }

        if (ans > 0) {
            for (int i = 1; i < graph.length; i ++) {
                if (i == ans) {
                    continue;
                }

                if (graph[i][ans] == 0) {
                    ans = -1;
                    break;
                }
            }
        }

        return ans;
    }
}
