package com.dengzm.lib.leetcode.lc_401_500;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 数字的补数
 * @date 2020/2/21 11:59
 */
public class Leetcode476 {
    public int findComplement(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.insert(0, (num % 2) ^ 1);
            num >>= 1;
        }

        int ans = 0;
        for (char c : sb.toString().toCharArray()) {
            ans <<= 1;
            ans += c - '0';
        }
        return ans;
    }
}
