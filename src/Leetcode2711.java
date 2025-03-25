import java.util.HashSet;
import java.util.Set;

public class Leetcode2711 {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            int x = i, y = 0;
            Set<Integer> set = new HashSet<>();
            while (x < m && y < n) {
                res[x][y] += set.size();
                set.add(grid[x][y]);
                x++;
                y++;
            }
        }

        for (int j = 1; j < n; ++j) {
            int x = 0, y = j;
            Set<Integer> set = new HashSet<>();
            while (x < m && y < n) {
                res[x][y] += set.size();
                set.add(grid[x][y]);
                x++;
                y++;
            }
        }

        for (int i = 0; i < m; ++i) {
            int x = i, y = n - 1;
            Set<Integer> set = new HashSet<>();
            while (x >= 0 && y >= 0) {
                res[x][y] -= set.size();
                res[x][y] = Math.abs(res[x][y]);
                set.add(grid[x][y]);
                x--;
                y--;
            }
        }

        for (int j = n - 2; j >= 0; --j) {
            int x = m - 1, y = j;
            Set<Integer> set = new HashSet<>();
            while (x >= 0 && y >= 0) {
                res[x][y] -= set.size();
                res[x][y] = Math.abs(res[x][y]);
                set.add(grid[x][y]);
                x--;
                y--;
            }
        }
        return res;
    }
}
