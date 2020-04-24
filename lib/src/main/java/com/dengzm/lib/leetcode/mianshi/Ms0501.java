package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 05.01. 插入
 * @date 2020/4/23 19:26
 */
public class Ms0501 {
    public int insertBits(int N, int M, int i, int j) {
        for (int k = i; k <= j; k++) {
            if ((N & (1 << k)) != 0) {
                N -= (1 << k);
            }
        }
        N |= (M << i);
        return N;
    }

    public int insertBits1(int N, int M, int i, int j) {
//        System.out.println(Integer.toBinaryString(N));
//        System.out.println(Integer.toBinaryString(M));
//
//        System.out.println("-----");

        int mask = 1 << i;

        for (int n = i; n <= j; n ++) {
            if ((N & mask) != 0) {
                N -= mask;
            }

            mask <<= 1;
        }

//        System.out.println(Integer.toBinaryString(N));

        N |= M << i;

//        System.out.println(Integer.toBinaryString(N));
//        System.out.println(Integer.toBinaryString(2082885133));

        return N;
    }

    public static void main(String[] args) {
        Ms0501 ms0501 = new Ms0501();
        ms0501.insertBits(1143207437,
                1017033,
                11,
                31);

//        System.out.println("-----");
//        System.out.println("-----");
//        System.out.println("-----");
//
//        ms0501.insertBits(1024,
//                19,
//                2,
//                6);
    }
}
