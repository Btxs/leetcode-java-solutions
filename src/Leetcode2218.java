import java.util.List;

public class Leetcode2218 {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        // Initialize memoization table with -1 to indicate uncomputed states
        int[][] memo = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(memo[i], -1);
        }
        return dfs(n - 1, k, piles, memo);
    }

    private int dfs(int pileIndex, int coinsLeft, List<List<Integer>> piles, int[][] memo) {
        // Base case: no more piles to consider
        if (pileIndex < 0 || coinsLeft <= 0) {
            return 0;
        }
        
        // Check if the result is already computed
        if (memo[pileIndex][coinsLeft] != -1) {
            return memo[pileIndex][coinsLeft];
        }

        int maxCoins = dfs(pileIndex - 1, coinsLeft, piles, memo); // Skip current pile

        // Try taking some coins from the current pile
        int currentMaxValue = 0;
        for (int take = 0; take < Math.min(coinsLeft, piles.get(pileIndex).size()); take++) {
            currentMaxValue += piles.get(pileIndex).get(take);
            maxCoins = Math.max(maxCoins, dfs(pileIndex - 1, coinsLeft - take - 1, piles, memo) + currentMaxValue);
        }

        // Memoize the result before returning
        return memo[pileIndex][coinsLeft] = maxCoins;
    }
}
