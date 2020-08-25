public class M46_translateNum {
    public static void main(String[] args) {
        M46_translateNum t = new M46_translateNum();
        System.out.println(t.translateNum(12258));
        System.out.println(t.translateNum(506));
    }
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            char cur = s.charAt(i-1);
            char pre = s.charAt(i-2);
            if (pre < '2' && pre > '0' ||
                    (pre == '2' && cur < '6')) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}
