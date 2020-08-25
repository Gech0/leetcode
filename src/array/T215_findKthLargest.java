package array;
import java.util.Arrays;

import static util.ArraysUtil.swap;

public class T215_findKthLargest {
    public int findKthLargest_lib(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest_partition (int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int target = len - k;

        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                // 小于 pivot 的元素都被交换到前面
                j++;
                swap(nums, j, i);
            }
        }
        // 在之前遍历的过程中，满足 [left + 1, j] < pivot，并且 (j, i] >= pivot
        swap(nums, j, left);
        // 交换以后 [left, j - 1] < pivot, nums[j] = pivot, [j + 1, right] >= pivot
        return j;
    }

    public void median (int[] nums) {
        int len = nums.length;
        int a = nums[0];
        int b = nums[(len - 1)/2];
        int c = nums[len - 1];
        if (a > b) {
            swap(nums, 0, (len - 1)/2);
        }
        if (a > c) {
            swap(nums, 0, len - 1);
        }
        if (b > c) {
            swap(nums, (len - 1)/2, len - 1);
        }

    }


    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int res = new T215_findKthLargest().findKthLargest_partition(nums, 2);
//        for (int n: nums) {
//            System.out.print(n + " ");
//        }
        System.out.println(res);

    }
 }
