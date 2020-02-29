package com.dengzm.lib.leetcode.lc_601_700;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 机器人能否返回原点
 * @date 2020/2/29 10:09
 */
public class Leetcode657 {
    public boolean judgeCircle(String moves) {
        int left = 0, right = 0, up = 0, down = 0;
        for (int i = 0; i < moves.length(); i ++) {
            switch (moves.charAt(i)) {
                case 'U':
                    up ++;
                    break;
                case 'D':
                    down ++;
                    break;
                case 'L':
                    left ++;
                    break;
                case 'R':
                    right ++;
                    break;
            }
        }

        return left == right && up == down;
    }
}
