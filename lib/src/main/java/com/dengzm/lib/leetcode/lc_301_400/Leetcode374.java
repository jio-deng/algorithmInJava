package com.dengzm.lib.leetcode.lc_301_400;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 猜数字大小
 * @date 2020/2/15 9:21
 */
public class Leetcode374 {
    /* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */
    public int guessNumber(int n) {
        if (n <= 1) {
            return 1;
        }

        int start = 1;
        int end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int result = guess(mid);

            if (result == 0) {
                return mid;
            } else if (result == -1) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    int guess(int num) {
        return 0;
    }
}
