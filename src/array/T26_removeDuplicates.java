package array;

import java.util.HashSet;
import java.util.Set;

/*
====================双指针====================
 */
public class T26_removeDuplicates {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(new T26_removeDuplicates().removeDuplicates_II(nums));
    }
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                nums[cnt++] = nums[i];
                set.add(nums[i]);
            }
        }
        return cnt;
    }

    /*
    通过题目条件：有序数组，
    只需要和处理过的元素比较大小即可确定是否唯一。
    省去set，
    set的运算比较慢
     */
    public int removeDuplicates_II (int[] nums) {
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[cnt - 1]) {
                nums[cnt++] = nums[i];
            }
        }
        return cnt;
    }
}
