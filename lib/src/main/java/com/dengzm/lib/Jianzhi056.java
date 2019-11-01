package com.dengzm.lib;

/**
 * @Description 056 数组中数字出现的次数
 * 题目一：数组中只出现一次的两个数字
 * 一个整型数组里除了两个数字之外，其他数字都出现了两次，找出这两个数字，要求时间复杂度O(n),空间复杂度O(1)
 * 题目二：数组中唯一只出现一次的数字
 * 在一个数组中除一个数字只出现一次之外，其他数字都出现了三次，请找出那个只出现一次的数字
 *
 * Created by deng on 2019/10/31.
 */
public class Jianzhi056 {

    public static void main(String[] args) {
        int[] data1 = new int[] {1,1,2,2,3,4,4,5,6,6,7,7};
        int[] data2 = new int[] {1,2};
        int[] data3 = new int[] {1,2,3,3};

        findNumsAppearOnce(data1);
        findNumsAppearOnce(data2);
        findNumsAppearOnce(data3);

        int[] data4 = new int[] {1,1,1,2,2,2,3,4,4,4,5,5,5};
        int[] data5 = new int[] {1,1,1,2};
        int[] data6 = new int[] {1,2,1,1,2,3,2,4,5,4,5,4,5};

        System.out.println("single num is " + findNumberAppearOnce(data4));
        System.out.println("single num is " + findNumberAppearOnce(data5));
        System.out.println("single num is " + findNumberAppearOnce(data6));
    }

    /**
     * 题目一 思路
     * 相同数字进行异或为0，将所有数字进行异或，得到的即为两个不同的数字的异或
     * 不同的数字的异或，二进制中一定会有一位为1，找到第一个为1的位，通过该位将数组分堆异或，即可得到两个数字
     *
     * @param data data
     */
    private static void findNumsAppearOnce(int[] data) {
        if (data == null || data.length < 2) {
            System.out.println("data is invalid");
            return;
        }

        int result = 0;

        for (int i : data) {
            result ^= i;
        }

        int indexBitOfOne = findFirstBitIs1(result);

        if (indexBitOfOne == -1) {
            System.out.println("sth is wrong with 'data'");
            return;
        }

        int num1 = 0;
        int num2 = 0;

        for (int i : data) {
            if (isBit1(i, indexBitOfOne)) {
                num1 ^= i;
            } else {
                num2 ^= i;
            }
        }

        System.out.println("The numbers are " + num1 + " and " + num2);
    }

    /**
     * 找到num二进制中第一个为1的位
     *
     * @param num num
     * @return first 1 in bits
     */
    private static int findFirstBitIs1(int num) {
        if (num == 0) {
            return -1;
        }

        int indexBit = 0;
        while ((num & 1) == 0) {
            num = num >> 1;
            ++ indexBit;
        }

        return indexBit;
    }

    private static boolean isBit1(int num, int indexBit) {
        return ((num >> indexBit) & 1) == 1;
    }

    /**
     * 题目二 思路
     * 使用一个大小为32int数组，的将所有数字的各个位都加在一起，%3，得到的即为单独的数字的各个位
     *
     * @param data data
     * @return num appeared once
     */
    private static int findNumberAppearOnce(int[] data) {
        if (data == null || data.length == 0) {
            throw new RuntimeException("data is invalid");
        }

        // 数字的最高位，保存在数组的第一位
        int[] bits = new int[32];

        for (int i = 0; i < 32; i ++) {
            bits[i] = 0;
        }

        for (int i : data) {
            int bitMask = 1;

            // 将各个位，放进数组
            for (int j = 31; j >= 0; j --) {
                int bit = bitMask & i;
                if (bit != 0) {
                    bits[j] += 1;
                }

                bitMask = bitMask << 1;
            }
        }

        // 计算数字
        int result = 0;
        for (int i = 0; i < 32; i ++) {
            result = result << 1;
            result += bits[i] % 3;
        }

        return result;
    }
}
