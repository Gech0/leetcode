package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class T217_containsDuplicate {
    /*
    判断一个数组有没有重复元素

    写了两种方法，第一种是先排序，再判断
    第二种通过hashset

    hash类型的结构效率真的很低！！！
     */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean containsDuplicate_1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n: nums) {
            if (set.contains(n)) {
                return true;
            }
            set.add(n);
        }
        return false;
    }
}
