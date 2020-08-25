package dp;

import java.util.Arrays;

public class T300_lengthOfLIS {
    public static void main(String[] args) {
        int[] nums = {4,10,4,3,8,9};
        T300_lengthOfLIS t = new T300_lengthOfLIS();
        System.out.println(t.lengthOfLIS(nums));
    }
    /*
    1、 nums = {} ==》 0  要预防数组越界
    2、 nums = {0} ==》 1
     */
    public int lengthOfLIS(int[] nums) {
//        if (nums.length == 0) return 0;
        /*
        改进
         */
        if (nums.length < 2) {
            return nums.length;
        }
        int[] dp =  new int[nums.length];

        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {  //i=1,若nums是空的会数组越界！！！
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    public int lengthOfLIS_plus(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;
        return 0;
    }
}
