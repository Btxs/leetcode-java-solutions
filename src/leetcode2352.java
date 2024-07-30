import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetcode2352 {
    // Equal Row and Column Pairs
    public int equalPairs(int[][] grid) {
        Map<String, Integer> map = new HashMap<>();
        int n = grid.length;
        
        // 将每一行转换为字符串并存储在map中，键是行的字符串表示，值是出现次数
        for (int[] row : grid) {
            StringBuilder sb = new StringBuilder();
            for (int num : row) {
                sb.append(num).append(",");
            }
            String key = sb.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int count = 0;
        // 遍历每一列，将每一列转换为字符串并与map中的行进行比较
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(grid[j][i]).append(",");
            }
            String key = sb.toString();
            if (map.containsKey(key)) {
                count += map.get(key);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        leetcode2352 solution = new leetcode2352();
        int[][] grid1 = {{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
        System.out.println(solution.equalPairs(grid1)); // 输出：1

        int[][] grid2 = {{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}};
        System.out.println(solution.equalPairs(grid2)); // 输出：3
    }
}
