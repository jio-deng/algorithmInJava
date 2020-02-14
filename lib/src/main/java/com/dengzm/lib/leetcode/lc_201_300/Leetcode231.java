package com.dengzm.lib.leetcode.lc_201_300;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 2的幂
 * @date 2020/2/14 9:48
 */
public class Leetcode231 {
    /**
     * 解法一：2的幂，二进制表示时，只有一位是1，其余都是0；n-1会使该位为0，低位变为1，与操作后为0
     * 解法二：负数的在计算机中二进制表示为补码(原码->正常二进制表示，原码按位取反(0-1,1-0)，最后再+1。
     * 然后两者进行与操作，得到的肯定是原码中最后一个二进制的1。
     * 例如8&(-8)->00001000 & 11111000 得 00001000，即8
     */
    public boolean isPowerOfTwo(int n) {
        // 1.return n > 0 && ( n & n-1) == 0;
        return (n > 0) && (n & -n) == n;
    }
}
