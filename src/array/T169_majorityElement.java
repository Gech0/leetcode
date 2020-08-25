package array;

import java.util.Arrays;

public class T169_majorityElement {
    /*
    摩尔投票法思路：
    核心：就算两两抵消，最多的元素总会留下来
    进阶：T229 求众数
     */
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (res == nums[i]) {
                count++;
            } else if (--count == 0){
                res = nums[i];
                count = 1;
            }
        }
        return res;
    }


    /*
    排序思路：
    因为元素个数大于一半
    所以，经过排序后，中间的元素肯定是
     */
    public int majorityElement_sort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }



    public static void main(String[] args) {
        System.out.println(new T169_majorityElement().
                majorityElement(new int[]{1,1,1,1,1,1,1,0}));
    }
}
