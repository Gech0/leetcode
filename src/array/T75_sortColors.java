package array;

import util.ArraysUtil;

public class T75_sortColors {
    /*
    此处注意点：
    扫描是从左向右，故左边的都是经过整理的，但右边交换来的数据不详，故右边交换后，当前元素还需进行判断！
     */
    public void sortColors(int[] nums) {
        int p = 0; //指向0的右边界
        int q = nums.length - 1;  //指向2的左边界
        for (int i = 0; i < q; ) {
            if (nums[i] == 0) {
                ArraysUtil.swap(nums, i++, p++);
            } else if (nums[i] == 2) {
                ArraysUtil.swap(nums, i, q--);
            } else i++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,2,2,1,2,1,0};
        new T75_sortColors().sortColors(nums);
        for (int n: nums) {
            System.out.print(n + " ");
        }
    }
}
