package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题05. 替换空格
 * @date 2020/4/14 12:36
 */
public class Ms005 {
    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }
}
