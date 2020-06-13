package com.dengzm.lib.leetcode.lc_401_500;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 用 Rand7() 实现 Rand10()
 * @date 2020/6/13 12:39
 */
public class Leetcode470 {
    public int rand10() {
        int a = rand7(), b = rand7();
        if(a>4&&b<4)  return rand10();
        else          return (a+b)%10+1;
    }

    public int rand7() {
        return 0;
    }
}
