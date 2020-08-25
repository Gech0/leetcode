package dp;

public class T121_maxProfit {
    public int maxProfit(int[] prices) {
        /*
        注：输入为[]时，易导致空指针
         */
        if (prices.length == 0) return 0;
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < dp[i - 1]) {
                dp[i] = prices[i];
            } else {
                dp[i] = dp[i - 1];
                int profit = prices[i] - dp[i - 1];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(new T121_maxProfit().maxProfit(prices));
    }
}
