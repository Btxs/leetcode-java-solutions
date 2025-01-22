import java.util.Arrays;

public class Leetcode1561 {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length;
        int ans = 0;
        for (int i=n/3; i<n; i+=2) {
            ans += piles[i];
        }
        return ans;
    }
}
