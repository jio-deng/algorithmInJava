package com.dengzm.lib.leetcode.lc_1201_1300;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 找出井字棋的获胜者
 * @date 2020/3/31 18:00
 */
public class Leetcode1275 {
    public String tictactoe(int[][] moves) {
        int total = 0;
        int[] X = new int[8];
        int[] A = new int[8];

        int[] tmp;

        for (int i = 0; i < moves.length; i ++) {
            int[] move = moves[i];
            tmp = i % 2 == 0 ? X : A;
            tmp[move[0]] ++;
            if (tmp[move[0]] == 3) {
                return i % 2 == 0 ? "A" : "B";
            }

            tmp[move[1] + 3] ++;
            if (tmp[move[1] + 3] == 3) {
                return i % 2 == 0 ? "A" : "B";
            }

            if (move[0] == move[1]) {
                tmp[6] ++;
                if (tmp[6] == 3) {
                    return i % 2 == 0 ? "A" : "B";
                }
            }

            if (move[0] + move[1] == 2) {
                tmp[7] ++;
                if (tmp[7] == 3) {
                    return i % 2 == 0 ? "A" : "B";
                }
            }

            total ++;
        }

        return total == 9 ? "Draw" : "Pending";
    }
}
