package com.dengzm.lib.leetcode.lc_101_200;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 比较版本号
 * @date 2020/4/2 12:24
 */
public class Leetcode165 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int index = 0;
        while (index < v1.length && index < v2.length) {
            int ver1 = Integer.valueOf(v1[index]);
            int ver2 = Integer.valueOf(v2[index]);
            System.out.println(ver1 + " " + ver2);
            if (ver1 != ver2) {
                return ver1 > ver2 ? 1 : -1;
            }

            index ++;
        }

        if (version1.length() == version2.length()) {
            return 0;
        }

        int result = version1.length() > version2.length() ? 1 : -1;
        String[] v = version1.length() > version2.length() ? v1 : v2;
        while (index < v.length) {
            if (Integer.valueOf(v[index]) > 0) {
                return result;
            }

            index ++;
        }

        return 0;
    }

    public static void main(String[] args) {
        Leetcode165 leetcode165 = new Leetcode165();
        leetcode165.compareVersion("0.1", "1.1");
    }
}
