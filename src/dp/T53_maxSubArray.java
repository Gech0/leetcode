package dp;

public class T53_maxSubArray {
    public int maxSubArray(int[] nums) {
        /*
        把dp[i]定义为，以i为尾的连续子序列中，最大的组合
         */
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] <= 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
