package dp;

public class T122_maxProfit {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                dp[i] = Math.max((dp[i - 1] + prices[i] - min),(prices[i]-min));
                min = prices[i + 1];
            }
        }
        return 0;
    }
}
