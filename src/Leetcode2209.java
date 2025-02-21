public class Leetcode2209 {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int n = floor.length();
        int[][] dp = new int[n + 1][numCarpets + 1];
        
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + (floor.charAt(i - 1) == '1' ? 1 : 0);
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= numCarpets; j++) {
                dp[i][j] = dp[i - 1][j] + (floor.charAt(i - 1) == '1' ? 1 : 0);
                
                if (i >= carpetLen) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - carpetLen][j - 1]);
                } else {
                    dp[i][j] = Math.min(dp[i][j], 0);
                }
            }
        }
        
        return dp[n][numCarpets];
    }
}
