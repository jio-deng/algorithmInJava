package com.dengzm.lib.leetcode.lc_201_250;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 快乐数
 * @date 2020/2/13 12:54
 */
public class Leetcode202 {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = bitSquareSum(slow);
            fast = bitSquareSum(fast);
            fast = bitSquareSum(fast);
        } while (slow != fast);

        return slow == 1;
    }

    private int bitSquareSum(int n) {
        int sum = 0;
        while(n > 0) {
            int bit = n % 10;
            sum += bit * bit;
            n = n / 10;
        }
        return sum;
    }

//    public boolean isHappy(int n) {
//        if (n == 0) {
//            return false;
//        }
//
//        if (n == 1) {
//            return true;
//        }
//
//        Set<Integer> set = new HashSet<>();
//
//        while (!set.contains(n)) {
//            set.add(n);
//
//            int result = 0;
//            while (n != 0) {
//                int temp = n % 10;
//                result += temp * temp;
//                n = n / 10;
//            }
//
//            if (result == 1) {
//                return true;
//            }
//
//            n = result;
//        }
//
//        return false;
//    }
}
