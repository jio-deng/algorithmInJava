package com.dengzm.lib.leetcode.card.chu_ji_suan_fa;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 删除排序数组中的重复项
 * @date 2020/3/9 9:21
 */
public class Cjsf01 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int pre = nums[0];
        int index = 1;

        for (int cur = 1; cur < nums.length; cur ++) {
            if (nums[cur] == pre) {
                // do nothing
            } else {
                nums[index ++] = nums[cur];
                pre = nums[cur];
            }
        }

        return index;
    }

    public static void main(String[] args) {
        Cjsf01 cjsf01 = new Cjsf01();
        cjsf01.removeDuplicates(new int[] {1,1,2});
    }
}
