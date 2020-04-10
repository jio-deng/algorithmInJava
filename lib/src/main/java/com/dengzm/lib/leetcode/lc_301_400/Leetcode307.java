package com.dengzm.lib.leetcode.lc_301_400;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 区域和检索 - 数组可修改
 * @date 2020/4/10 11:34
 */
public class Leetcode307 {
    class NumArray {
        int[] tree;
        int n;

        public NumArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }

            n = nums.length;
            tree = new int[n * 2];
            buildTree(nums);
        }

        private void buildTree(int[] nums) {
            for (int i = n, j = 0; i < n * 2; i ++, j ++) {
                tree[i] = nums[j];
            }

            for (int i = n - 1; i >= 0; i --) {
                tree[i] = tree[i * 2] + tree[i * 2 + 1];
            }
        }

        public void update(int i, int val) {
            i += n;
            if (tree[i] == val) {
                return;
            }

            tree[i] = val;
            while (i > 0) {
                int left = i, right = i;
                if (i % 2 == 0) {
                    right ++;
                } else {
                    left --;
                }

                tree[i / 2] = tree[left] + tree[right];
                i /= 2;
            }
        }

        public int sumRange(int l, int r) {
            // get leaf with value 'l'
            l += n;
            // get leaf with value 'r'
            r += n;
            int sum = 0;
            while (l <= r) {
                if ((l % 2) == 1) {
                    sum += tree[l];
                    l++;
                }
                if ((r % 2) == 0) {
                    sum += tree[r];
                    r--;
                }
                l /= 2;
                r /= 2;
            }
            return sum;
        }
    }


//    class NumArray {
//        int[] sum;
//        int[] nums;
//
//        public NumArray(int[] nums) {
//            if (nums == null || nums.length == 0) {
//                return;
//            }
//
//            this.nums = nums;
//            int n = nums.length;
//            sum = new int[n];
//            sum[0] = nums[0];
//            for (int i = 1; i < n; i ++) {
//                sum[i] = sum[i-1] + nums[i];
//            }
//        }
//
//        public void update(int i, int val) {
//            if (nums == null) {
//                return;
//            }
//
//            if (nums[i] == val) {
//                return;
//            }
//
//            int dif = val - nums[i];
//            nums[i] = val;
//
//            for (int j = i; j < nums.length; j ++) {
//                sum[j] += dif;
//            }
//        }
//
//        public int sumRange(int i, int j) {
//            if (nums == null || nums.length <= j) {
//                return -1;
//            }
//            return sum[j] - (i <= 0 ? 0 : sum[i-1]);
//        }
//    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
}
