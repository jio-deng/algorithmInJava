package com.dengzm.lib.leetcode.lc_401_500;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 汉明距离总和
 * @date 2020/6/20 11:52
 */
public class Leetcode477 {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        int len = nums.length;
        for(int i = 0; i < 30; i++){
            int oneCount = 0;
            int temp = 0;
            for(int j = 0; j < len; j++){
                oneCount += nums[j] & 1;
                nums[j] >>= 1;
                temp += nums[j] == 0 ? 1 : 0;
            }
            res += oneCount * (len - oneCount);
            if(temp == len)break;
        }
        return res;
    }



    /**
     * timeout
     * @param nums
     * @return
     */
//    public int totalHammingDistance(int[] nums) {
//        int ans = 0;
//        for (int i = 0; i < nums.length - 1; i ++) {
//            for (int j = i+1; j < nums.length; j ++) {
//                int num1 = nums[i];
//                int num2 = nums[j];
//                int n = num1 ^ num2;
//                while (n > 0) {
//                    n = n & (n-1);
//                    ans ++;
//                }
//            }
//        }
//
//        return ans;
//    }
}
