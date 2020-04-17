package com.dengzm.lib.leetcode.lc_601_700;

import java.util.LinkedList;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description Dota2 参议院
 * @date 2020/4/17 15:12
 */
public class Leetcode649 {
    public String predictPartyVictory(String senate) {
        LinkedList<Integer> radiants = new LinkedList<>();
        LinkedList<Integer> dires = new LinkedList<>();

        int len = senate.length();

        for (int i = 0; i < len; i ++) {
            char c = senate.charAt(i);
            if (c == 'R') {
                radiants.add(i);
            } else {
                dires.add(i);
            }
        }

        while (!radiants.isEmpty() && !dires.isEmpty()) {
            int r = radiants.poll();
            int d = dires.poll();

            if (r < d) {
                radiants.offer(r + len);
            } else {
                dires.offer(d + len);
            }
        }

        return !radiants.isEmpty() ? "Radiant": "Dire";
    }
}
