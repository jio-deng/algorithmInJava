package com.dengzm.lib.leetcode.lc_401_500;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 下一个更大元素 I
 * @date 2020/2/21 13:19
 */
public class Leetcode496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int num : nums2) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() < num) {
                    map.put(stack.pop(), num);
                }
            }
            stack.push(num);
        }

        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        for (int i = 0; i < nums1.length; i ++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }

        return nums1;
    }

//    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
//        int[] result = new int[nums1.length];
//
//        for (int i = 0; i < result.length; i ++) {
//            int num = nums1[i];
//            int value = -1;
//            boolean isFound = false;
//            for (int item : nums2) {
//                if (!isFound) {
//                    if (item == num) {
//                        isFound = true;
//                    }
//
//                    continue;
//                }
//
//                if (item > num) {
//                    value = item;
//                    break;
//                }
//            }
//
//            result[i] = value;
//        }
//
//        return result;
//    }
}
