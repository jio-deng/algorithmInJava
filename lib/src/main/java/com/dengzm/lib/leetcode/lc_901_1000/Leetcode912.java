package com.dengzm.lib.leetcode.lc_901_1000;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 排序数组
 * @date 2020/3/31 16:02
 */
public class Leetcode912 {
    /**
     * 冒泡
     * @param nums
     * @return
     */
    public int[] sortArray1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i ++) {
            int val = nums[i];
            for (int j = i+1; j < nums.length; j ++) {
                if (nums[j] < val) {
                    int tmp = nums[j];
                    nums[j] = val;
                    val = tmp;
                }
            }

            nums[i] = val;
        }

        return nums;
    }

    /**
     * 插入
     */
    public void InsertSort(int[] nums) {
        for (int i = 0; i < nums.length; i ++) {
            int tmp = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > tmp) {
                nums[j+1] = nums[j];
                j --;
            }
            nums[j+1] = tmp;
        }
    }

    //折半插入
    void HInsertSort(int[] nums) {
        int low, high, mid;
        for (int i = 0; i < nums.length; i ++) {
            int tmp = nums[i];
            low = 0;
            high = i-1;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (nums[mid] > tmp) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            for (int j = i-1; j >= high+1; j --) {
                nums[j+1] = nums[j];
            }

            nums[high+1] = tmp;
        }
    }

    //希尔
    void ShellSort(int[] nums){
        int n = nums.length;
        for (int dk = n / 2; dk >= 1; dk = dk / 2) {
            for (int i = dk; i < n; i += dk) {
                if (nums[i] < nums[i - dk]) {
                    int tmp = nums[i], j;
                    for (j = i-dk; j >= 0 && tmp < nums[j]; j -= dk) {
                        nums[j+dk] = nums[j];
                    }
                    nums[j+dk] = tmp;
                }

            }
        }
    }

    //快排
    void QuickSort(int[] nums,int low,int high){
        if (low < high) {
            int pivotpos = partition(nums, low, high);
            QuickSort(nums, low, pivotpos-1);
            QuickSort(nums, pivotpos+1, high);
        }
    }

    int partition(int[] nums,int low,int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivot) --high;
            nums[low] = nums[high];
            while (low < high && nums[low] <= pivot) ++low;
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;

    }
}
