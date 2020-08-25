public class T198_dp {
    public static void main(String[] args) {
        int[] req = {2,7,9,3,1};
        int[] req1 = {2};
        System.out.println(rob(req));
        System.out.println(rob(req1));
    }
    public static int rob(int[] nums) {
        if (nums.length <= 1) {
            return nums.length == 0? 0 : nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i ++){
            dp[i] = Math.max((dp[i - 2] + nums[i]), dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    //滚动数组
    public static int rob1(int[] nums) {
        int yesterday = 0;
        int today = 0;
        for (int cur: nums) {
            int temp = today;
            today = Math.max(today, yesterday + cur);
            yesterday = temp;
        }
        return today;
    }

}
