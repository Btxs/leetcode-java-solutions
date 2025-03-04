public class Leetcode1745 {
    public boolean canSplitIntoThreePalindromes(String s) {
        int n = s.length();
        // 预处理回文串信息
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            // 单个字符一定是回文串
            dp[i][i] = true;
        }
        //
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (length == 2 || dp[i+1][j-1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        // 遍历所有可能的分割点
        for (int i = 0; i < n - 2; i++) {
            // 如果 s[0..i] 不是回文串，跳过
            if (!dp[0][i]) {
                continue;
            }
            for (int j = i + 1; j < n - 1; j++) {
                if (dp[i+1][j] && dp[j+1][n-1]) {
                    return true;
                }
            }
        }
        return false;
    }
}
