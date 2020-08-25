package sort;

import util.ArraysUtil;

public class Sort {
    public void quickSort (int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        int pivot = nums[left];

        while (i != j) {
            /*
            1、必须先从j开始动
            2、== 的情况不交换
             */
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            if (i < j)
                ArraysUtil.swap(nums, i, j);
        }
        ArraysUtil.swap(nums, left, i);

        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }


    public static void main(String[] args) {
        int[] nums = {2,1,4,8,2,0,12,5,3};
        new Sort().quickSort(nums, 0, nums.length - 1);
        for (int n: nums) {
            System.out.print(n + " ");
        }
    }
}
