import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode2612 {
    private int find(int[] f, int x) {
        return f[x] == x ? x : (f[x] = find(f, f[x]));
    }

    private void merge(int[] f, int x, int y) {
        int fx = find(f, x), fy = find(f, y);
        f[fx] = fy;
    }

    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        int[][] fa = new int[2][n + 2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                fa[i][j] = j;
            }
        }
        for (int ban : banned) {
            merge(fa[ban % 2], ban, ban + 2);
        }
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(p);
        ans[p] = 0;
        merge(fa[p % 2], p, p + 2);
        while (!q.isEmpty()) {
            int i = q.poll();
            int mn = Math.max(i - k + 1, k - i - 1);
            int mx = Math.min(i + k - 1, n * 2 - k - i - 1);
            int fi = 0;
            for (int j = mn; j <= mx; j = fi + 2) {
                fi = find(fa[mn % 2], j);
                if (fi > mx) {
                    break;
                }
                ans[fi] = ans[i] + 1;
                q.add(fi);
                merge(fa[mn % 2], fi, fi + 2);
            }
        }
        return ans;
    }
}
