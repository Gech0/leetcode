package dp;

public class T647_countSubstrings {
    /*
    字符串中的回文串个数
     */
    public int countSubstrings(String s) {
        int len = s.length();
        int count = 0;
        boolean[][] dp = new boolean[len][len];
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = (j-i==1 || dp[i+1][j-1]);
                }
                if (dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(new T647_countSubstrings().countSubstrings(s));
    }
}
