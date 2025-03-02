public class Leetcode132 {
    public int minCut(String s) {
        int n = s.length();
        // 预处理回文串
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || isPalindrome[j + 1][i - 1])) {
                    isPalindrome[j][i] = true;
                }
            }
        }

        // 动态规划数组
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = i; // 初始化为最坏情况
        }

        for (int i = 0; i < n; i++) {
            if (isPalindrome[0][i]) {
                dp[i] = 0; // 如果 s[0:i] 是回文串，不需要分割
                continue;
            }
            for (int j = 1; j <= i; j++) {
                if (isPalindrome[j][i]) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }

        return dp[n - 1];
    }
}
