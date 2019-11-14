package com.dengzm.lib.jianzhi;

/**
 * @Description 021 调整数组顺序使奇数位于偶数前面
 * Created by deng on 2018/12/22.
 */
public class Jianzhi021 {

    public static void main(String[] args) {
        recordOddEven(new int[] {1,2,3,4,5,6});
    }

    private static void recordOddEven(int[] data) {
        if (data == null || data.length == 0) {
            return;
        }

        int start = 0;
        int end  = data.length - 1;
        int temp;

        while (start < end) {
            while (start < end && (data[start] & 0x1) != 0) {
                start ++;
            }
            while (start < end && (data[end] & 0x1) == 0) {
                end --;
            }
            if (start < end) {
                temp = data[start];
                data[start] = data[end];
                data[end] = temp;
            }
        }

        for (int i = 0; i < data.length; i ++) {
            System.out.println(data[i]);
        }
    }

}
