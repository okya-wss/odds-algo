package algo.dp.区间dp;

/**
 * 516 longest-palindromic-subsequence	最长回文子序列
 *
 * @author shuaishuai.wang
 * @date 2023-02-22
 **/
public class LongestPalindromicSubsequence_516 {
    public static int longestPalindromeSub(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        //i 从最后一个字符开始往前遍历，j 从 i + 1 开始往后遍历，这样可以保证每个子问题都已经算好了
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n-1];
    }


    public static void main(String[] args) {
        longestPalindromeSub("bbbab");
    }
}
