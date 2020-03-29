package com.dengzm.lib.leetcode.lc_1101_1200;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 等价多米诺骨牌对的数量
 * @date 2020/3/29 11:21
 */
public class Leetcode1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        for (int[] d : dominoes) {
            Arrays.sort(d);
        }

        Arrays.sort(dominoes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0] != 0 ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });

        int ans = 0, curStart = -1, curSum = -1, curIndex = -1;
        for (int[] dominoe : dominoes) {
            if (curStart == -1) {
                curStart = dominoe[0];
                curSum = dominoe[0] + dominoe[1];
                curIndex = 1;
            } else {
                if (dominoe[0] == curStart && dominoe[0] + dominoe[1] == curSum) {
                    curIndex++;
                } else {
                    ans += dengchashulie(curIndex);
                    curStart = dominoe[0];
                    curSum = dominoe[0] + dominoe[1];
                    curIndex = 1;
                }
            }
        }

        ans += dengchashulie(curIndex);
        return ans;
    }

    private int dengchashulie(int n) {
        if (n <= 0) {
            return 0;
        }

        return n * (n - 1) / 2;
    }

    public static void main(String[] args) {
        Leetcode1128 leetcode1128 = new Leetcode1128();
        leetcode1128.numEquivDominoPairs(new int[][] {{1,2},{1,2},{1,1},{1,2},{2,2}});
    }
}
