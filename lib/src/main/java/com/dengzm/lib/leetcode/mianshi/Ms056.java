package com.dengzm.lib.leetcode.mianshi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题56 - I. 数组中数字出现的次数 && 面试题56 - II. 数组中数字出现的次数 II
 * @date 2020/4/28 10:14
 */
public class Ms056 {
    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return nums;
        }

        int tmp = 0;
        for (int num : nums) {
            tmp ^= num;
        }

        int mask = 1;
        while ((tmp & mask) == 0) {
            mask <<= 1;
        }

        int[] ans = new int[2];
        for (int num : nums) {
            if ((num & mask) == 0) {
                ans[0] ^= num;
            } else {
                ans[1] ^= num;
            }
        }

        return ans;
    }

    public int singleNumber2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }


    /**
     * from : https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/comments/
     *
     * 这是相当于是三进制,one表示第一次出现,two表示第二次出现
     * 第一次出现时 one = 1 two = 0
     * 第二次出现时 one = 0 two = 1
     * 第三次出现时 one = 0 two = 0
     * 通过 one/two ^ num就可以将数据保留到相应的数字里(相当于置1),
     * 而后面的 &~one/two意思是就是判断是否需要进位,
     * 因为one = 1 two = 1 是表示 3 此时 one = 0 two = 0
     */
    public int singleNumber(int[] nums) {
        int a = 0;
        int b = 0;

        for(int num : nums) {
            a = (a ^ num) & ~b;
            b = (b ^ num) & ~a;
        }

        return a;
    }
}
