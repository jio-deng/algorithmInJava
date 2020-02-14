package com.dengzm.lib.leetcode.lc_101_200;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 两数之和 II - 输入有序数组
 * @date 2019/12/10 11:15
 */
public class Leetcode167 {
    /**
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     *
     * 说明:
     * 返回的下标值（index1 和 index2）不是从零开始的。
     * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     *
     * 示例:
     * 输入: numbers = [2, 7, 11, 15], target = 9
     * 输出: [1,2]
     * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     */

    /**
     * link from : https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/solution/liang-shu-zhi-he-ii-shu-ru-you-xu-shu-zu-by-leetco/
     *
     * @param numbers numbers
     * @param target target sum
     * @return if does contain , return int[] with subtitles;
     *         if doesn't or sth is wrong with data provided, return null
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }

        int head = 0;
        int tail = numbers.length - 1;

        while (head < tail) {
            int sum = numbers[head] + numbers[tail];
            if (sum == target) {
                return new int[]{head + 1, tail + 1};
            } else if (sum > target) {
                tail --;
            } else {
                head ++;
            }
        }

        return null;
    }

    /*执行结果：通过
      显示详情
      执行用时 :1 ms, 在所有 java 提交中击败了99.16%的用户
      内存消耗 :38 MB, 在所有 java 提交中击败了50.36%的用户*/
}
