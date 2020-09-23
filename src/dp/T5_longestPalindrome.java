package dp;

import java.util.Arrays;

public class T5_longestPalindrome {
//    public String longestPalindrome(String s) {
//        /*
//        测试用例：
//        1、空串
//        2、最小为单个字符
//        3、单数回文串
//        4、偶数回文串
//         */
//        if (s == null || s.length() < 2) {
//            return s;
//        }
//        StringBuilder res = new StringBuilder();
//        int[] dp = new int[s.length()];
//        Arrays.fill(dp, 1);
//
//        /*
//        回文串长度为奇数的情况
//         */
//        for (int i = 1; i < s.length(); i++) {
//            int flag = 1;
//            if (s.charAt(i) != s.charAt(i-1)) {
//                while (i - flag >= 0 && i + flag < s.length()) {
//                    if (s.charAt(i-flag) == s.charAt(i + flag)) {
//                        dp[i] += 2;
//                        flag++;
//                    } else {
//                        break;
//                    }
//                }
//            } else {
//                dp[i] = 2;
//                while (i - flag - 1>= 0 && i + flag < s.length()) {
//                    if (s.charAt(i-flag - 1) == s.charAt(i+flag)) {
//                        dp[i] += 2;
//                        flag++;
//                    } else {
//                        break;
//                    }
//                }
//            }
//        }
//
//
//        int max = 0;
//        for (int i = 1; i < dp.length; i++) {
//            if (dp[i] > dp[max]) {
//                max = i;
//            }
//        }
//        int left = max - dp[max]/2;
//        int right = max + dp[max]/2 + 1;
//        if (max % 2 == 0 && max != 0) {
//            right -= 1;
//        }
//        return s.substring(left, right);
//    }



    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }


    public static void main(String[] args) {
        String s = "ac";
        System.out.println(new T5_longestPalindrome().
                longestPalindrome(s));
    }
}
