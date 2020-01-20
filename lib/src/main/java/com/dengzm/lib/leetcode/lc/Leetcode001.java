package com.dengzm.lib.leetcode.lc;

import java.util.HashMap;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 两数之和
 * @date 2019/12/10 10:30
 */
public class Leetcode001 {
    /**
     * 给定一个整数数组nums和一个目标值target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     **/

    /**
     * 两数之和
     * link form : https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-2/
     * 为了对运行时间复杂度进行优化，我们需要一种更有效的方法来检查数组中是否存在目标元素。
     * 如果存在，我们需要找出它的索引。保持数组中的每个元素与其索引相互对应的最好方法是什么？哈希表。
     * 通过以空间换取速度的方式，我们可以将查找时间从 O(n) 降低到 O(1)。
     * 哈希表正是为此目的而构建的，它支持以 近似 恒定的时间进行快速查找。
     * 我用“近似”来描述，是因为一旦出现冲突，查找用时可能会退化到 O(n)O(n)。
     * 但只要你仔细地挑选哈希函数，在哈希表中进行查找的用时应当被摊销为 O(1)O(1)。
     *
     * @param nums nums
     * @param target target sum
     * @return if does contain , return int[] with subtitles;
     *         if doesn't or sth is wrong with data provided, return null
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i ++) {
            int complement = target - nums[i];
            if (hashMap.containsKey(complement)) {
                return new int[]{hashMap.get(complement), i};
            }
            hashMap.put(nums[i], i);
        }

        return null;
    }

    /*执行结果：通过
      显示详情
      执行用时 :3 ms, 在所有 java 提交中击败了98.17%的用户
      内存消耗 :36.6 MB, 在所有 java 提交中击败了94.49%的用户*/
}
