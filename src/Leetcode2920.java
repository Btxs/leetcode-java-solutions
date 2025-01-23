import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode2920 {
    public int maximumPoints(int[][] edges, int[] coins, int k) {
        List<Integer>[] g = new ArrayList[coins.length];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            g[x].add(y);
            g[y].add(x);
        }
        return dfs(0, -1, g, coins, k)[0];
    }

    private int[] dfs(int x, int fa, List<Integer>[] g, int[] coins, int k) {
        int[] s = new int[14];
        for (int y: g[x]) {
            if (y == fa) {
                continue;
            }
            int[] fy = dfs(y, x, g, coins, k);
            for (int j = 0; j < 14; j++) {
                s[j] += fy[j];
            }
        }
        for (int j = 0; j < 13; j++) {
            s[j] = Math.max((coins[x] >> j) - k + s[j], (coins[x] >> (j + 1)) + s[j + 1]);
        }
        s[13] += (coins[x] >> 13) - k;
        return s;
    }
}
