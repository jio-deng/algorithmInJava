package com.dengzm.lib.leetcode.lc_701_800;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 1比特与2比特字符
 * @date 2020/3/3 10:47
 */
public class Leetcode717 {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits == null || bits.length == 0) {
            return false;
        }

        return isOneBitCharacterCore(bits, 0);
    }

    private boolean isOneBitCharacterCore(int[] bits, int cur) {
        if (cur >= bits.length - 1) {
            return cur == bits.length - 1;
        }

        if (bits[cur] == 0) {
            return isOneBitCharacterCore(bits, cur + 1);
        } else {
            return isOneBitCharacterCore(bits, cur + 2);
        }
    }
}
