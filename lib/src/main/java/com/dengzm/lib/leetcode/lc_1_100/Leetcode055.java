package com.dengzm.lib.leetcode.lc_1_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 跳跃游戏
 * @date 2020/1/20 13:57
 */
public class Leetcode055 {
    public boolean canJump(int[] nums) {
//        int step = 0;
        int end = 0;
        int maxPosition = 0;

        for (int i = 0; i < nums.length - 1; i ++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);

            if (i == end) {
                if (maxPosition > end) {
                    end = maxPosition;
//                step ++;
                } else {
                    return false;
                }
            }
        }

        return true;
    }



    /**
     * timeout
     * @param nums
     * @return
     */
    public boolean canJump1(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        return canJumpCore(visited, nums, 0);
    }

    private boolean canJumpCore(boolean[] visited, int[] nums, int index) {
        if (visited[index]) {
            return false;
        }

        int range = nums[index];

        if (index + range >= nums.length - 1) {
            return true;
        }

        if (range == 0) {
            return false;
        }

        for (int i = index + range; i >= index + 1; i --) {
            if (canJumpCore(visited, nums, i)) {
                return true;
            }
        }

        return false;
    }

}
