package com.dengzm.lib;

/**
 * @Description 042 连续子数组的最大和
 *
 * Created by deng on 2019/9/18.
 */
public class Jianzhi042 {

    public static void main(String[] args) {
        int[] data1 = new int[] {-1, 1, 2, 3, -4, 3, 5, -15, 2};
        int[] data2 = new int[] {-1, 1, -2, 3, -4, 3, 5, -15, 2};
        int[] data3 = new int[] {-1, 1, 2, 3, -4, 3, -5, -15, 2};

        findGreatestSumOfSubArray(data1);
        findGreatestSumOfSubArray(data2);
        findGreatestSumOfSubArray(data3);
    }

    /**
     * 记录当前总和并不断累加，当总和小于0时重新开始
     *
     * 注：数组需有正数，否则当前函数计算结果不正确
     */
    private static void findGreatestSumOfSubArray(int[] data) {
        if (data == null || data.length == 0) {
            System.out.println("data invalid");
            return;
        }

        int curSum = 0;
        int result = 0;

        for (int i = 0; i < data.length; i ++) {
            if (curSum <= 0) {
                curSum = data[i];
            } else {
                curSum += data[i];
            }

            if (curSum > result) {
                result = curSum;
            }
        }

        System.out.println("Greatest sum is " + result);
    }


}
