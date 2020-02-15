package com.dengzm.lib.leetcode.lc_401_500;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 数字转换为十六进制数
 * @date 2020/2/15 19:58
 */
public class Leetcode405 {
    public String toHex(int num) {
        if (num == 0) return "0";
        String hex = "0123456789abcdef";
        StringBuilder ans = new StringBuilder();
        while (num != 0 && ans.length() < 8) {
            ans.insert(0, hex.charAt(num & 0xf));
            num >>= 4;
        }

        return ans.toString();
    }
}
