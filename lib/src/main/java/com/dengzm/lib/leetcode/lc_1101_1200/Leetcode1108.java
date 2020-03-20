package com.dengzm.lib.leetcode.lc_1101_1200;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description IP 地址无效化
 * @date 2020/1/31 11:35
 */
public class Leetcode1108 {
    public String defangIPaddr(String address) {
        if (address == null || address.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        String[] strings = address.split("\\.");
        for (int i = 0; i < strings.length - 1; i ++) {
            sb.append(strings[i]);
            sb.append("[.]");
        }
        sb.append(strings[strings.length - 1]);
        return sb.toString();
    }
}
