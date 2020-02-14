package com.dengzm.lib.leetcode.lc_201_300;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 猜数字游戏
 * @date 2020/2/14 12:12
 */
public class Leetcode299 {
    public String getHint(String secret, String guess) {
        StringBuilder sb = new StringBuilder();
        int[] nums = new int[10];

        int a = 0, b = 0;
        for (int i = 0; i < secret.length(); i ++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a ++;
            } else {
                nums[secret.charAt(i) - '0'] ++;
                nums[guess.charAt(i) - '0'] --;
            }
        }

        for (int num : nums) {
            if (num > 0) {
                b += num;
            }
        }

        b = secret.length() - a - b;

        sb.append(a).append("A").append(b).append("B");
        return sb.toString();
    }

    public String getHint1(String secret, String guess) {
        StringBuilder sb = new StringBuilder();
        int[] nums = new int[10];
        boolean[] used = new boolean[secret.length()];

        int a = 0, b = 0;
        for (int i = 0; i < secret.length(); i ++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                used[i] = true;
                a ++;
            } else {
                nums[secret.charAt(i) - '0'] ++;
            }
        }

        for (int i = 0; i < guess.length(); i ++) {
            if (!used[i] && nums[guess.charAt(i) - '0'] > 0) {
                b ++;
                nums[guess.charAt(i) - '0'] --;
            }
        }

        sb.append(a).append("A").append(b).append("B");
        return sb.toString();
    }
}
